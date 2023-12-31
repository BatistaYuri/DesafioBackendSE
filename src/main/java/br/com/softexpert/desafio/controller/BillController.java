package br.com.softexpert.desafio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.softexpert.desafio.service.BillService;
import br.com.softexpert.desafio.models.Bill;
import br.com.softexpert.desafio.models.dto.PaymentResponseDTO;

@RestController
@CrossOrigin
@RequestMapping("/api/bill")
public class BillController {

	@Autowired
	BillService billService;

	@PostMapping
	public List<PaymentResponseDTO> payment(@RequestParam String companyPayment, @RequestBody(required = true) @Valid Bill bill) {
		return billService.payment(bill, companyPayment);
	}

}
