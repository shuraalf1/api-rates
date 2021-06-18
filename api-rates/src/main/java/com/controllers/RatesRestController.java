package com.controllers;

import com.model.Rate;
import com.services.DOFService;
import com.services.FixerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rates")
public class RatesRestController {

	@Autowired
	private DOFService dofService;
	@Autowired
	private FixerService fixerService;

	@GetMapping("/")
	public Rate getRates() {
		Rate rate = new Rate();
		rate.setDof(dofService.getRate());
		rate.setFixer(fixerService.getRate());
		return rate;
	}

}
