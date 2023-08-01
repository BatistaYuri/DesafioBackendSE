package br.com.softexpert.desafiojavabackend.util;

import java.math.BigDecimal;

import br.com.softexpert.desafio.models.Person;
import br.com.softexpert.desafio.models.dto.PaymentResponseDTO;

public class PaymentResponseDTOCreator {

	public static PaymentResponseDTO createPaymentResponseDTO() {
		return new PaymentResponseDTO(new Person(0, "Yuri", "yuri.b.1114@gmail.com", true), new BigDecimal(6.08), "");
	}
}
