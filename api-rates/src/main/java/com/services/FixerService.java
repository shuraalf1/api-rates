package com.services;

import com.google.gson.Gson;
import com.model.DataFixer;
import com.model.Provider;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class FixerService {

	public Provider getRate()
	{
		Provider proveedor = new Provider();
		try {
		final String uri = "http://data.fixer.io/api/latest?access_key=21bdac824ce7568017692f79ff1a5cbe&format=1";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		DataFixer dataFixer = new Gson().fromJson(result, DataFixer.class);
		proveedor.setValue(dataFixer.getRates().getmXN());
		Date dateAux = new SimpleDateFormat("yyyy-MM-dd").parse(dataFixer.getDate());
		proveedor.setLast_updated(dateAux);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return proveedor;
	}


}
