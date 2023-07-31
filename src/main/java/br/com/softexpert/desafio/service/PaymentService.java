package br.com.softexpert.desafio.service;

import java.util.List;
import java.util.Map;

import br.com.softexpert.desafio.models.BillPerson;
import br.com.softexpert.desafio.models.dto.PaymentResponseDTO;

public interface PaymentService {

	List<PaymentResponseDTO> payment(Map<Integer, BillPerson> totalPerPerson);

}
