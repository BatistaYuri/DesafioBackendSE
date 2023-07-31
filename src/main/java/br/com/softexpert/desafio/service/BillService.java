package br.com.softexpert.desafio.service;

import br.com.softexpert.desafio.models.Bill;

public interface BillService {

	void payment(Bill bill, String company);

}
