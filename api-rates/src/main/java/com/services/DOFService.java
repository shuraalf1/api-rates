package com.services;

import com.model.Provider;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class DOFService {

	public Provider getRate(){
		Provider proveedor = new Provider();
		try {
			Document webPage = Jsoup
					.connect("https://www.banxico.org.mx/tipcamb/tipCamMIAction.do")
					.get();
			Element registro  = webPage.getElementsByClass("renglonNon").get(5).getAllElements().first();
			String fecha = registro.getElementsByTag("td").get(0).text().replaceAll("\\s+","");
			String valor = registro.getElementsByTag("td").get(2).text().replaceAll("\\s+","");
			Date dateAux=new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
			proveedor.setLast_updated(dateAux);
			proveedor.setValue(Double.parseDouble(valor));
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return proveedor;
	}


}
