package com.services;

import com.model.Provider;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
@Service
public class BanxicoService {
	public Provider getRate()
	{
		Provider proveedor = new Provider();
		try {
			final String uri = "https://www.banxico.org.mx/SieAPIRest/service/v1/series/SF43718/datos/oportuno?token=ff1698e757b9fcc543ea95f9a1f07d34975dd613073cc368503cc6f000e718cf";
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_XML);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
			HttpEntity<String> entity = new HttpEntity<>("body", headers);
			ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
			Document doc = Jsoup.parse(String.valueOf(result), "", Parser.xmlParser());
			Element obs = doc.getElementsByTag("series").get(0)
					.getElementsByTag("serie").get(0)
					.getElementsByTag("Obs").get(0);
			String valor = obs.getElementsByTag("dato").get(0).text().replaceAll("\\s+","");
			String fecha = obs.getElementsByTag("fecha").get(0).text().replaceAll("\\s+","");
			Date dateAux=new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
			proveedor.setLast_updated(dateAux);
			proveedor.setValue(Double.parseDouble(valor));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return proveedor;
	}
}