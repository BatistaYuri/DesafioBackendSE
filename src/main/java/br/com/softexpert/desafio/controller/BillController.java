package br.com.softexpert.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.softexpert.desafio.service.BillService;
import br.com.softexpert.desafio.models.Bill;

@RestController
@CrossOrigin
@RequestMapping("/api/bill")
public class BillController {

	@Autowired
	BillService billService;

	@GetMapping
	public void payment(@RequestParam() String companyPayment, @RequestBody(required = true) Bill bill) {
		billService.payment(bill, companyPayment);
	}

}
