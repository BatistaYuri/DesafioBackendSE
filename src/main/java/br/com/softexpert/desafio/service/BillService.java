package br.com.softexpert.desafio.service;

import java.util.List;

import br.com.softexpert.desafio.models.Bill;
import br.com.softexpert.desafio.models.dto.PaymentResponseDTO;

public interface BillService {

	List<PaymentResponseDTO> payment(Bill bill, String company);

}
