package br.com.softexpert.desafiojavabackend.util;

import java.math.BigDecimal;

import br.com.softexpert.desafio.models.dto.PaymentResponseDTO;

public class PaymentResponseDTOCreator {

	public static PaymentResponseDTO createPaymentResponseDTO() {
		return new PaymentResponseDTO("Pedro", new BigDecimal(6.08), "");
	}
}
