package br.com.softexpert.desafio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;

import br.com.softexpert.desafio.models.BillPerson;
import br.com.softexpert.desafio.models.dto.PaymentResponseDTO;
import br.com.softexpert.desafio.service.MercadoPagoService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Service("mercadoPagoService")
public class MercadoPagoServiceImpl implements MercadoPagoService {
	@Value("${mercado_pago_access_token}")
	private String mercadoPagoAccessToken;

	@Override
	public List<PaymentResponseDTO> payment(Map<Integer, BillPerson> totalPerPerson) {
		MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);
		PaymentClient client = new PaymentClient();
		List<PaymentResponseDTO> responses = new ArrayList<>();

		totalPerPerson.forEach((key, value) -> {
			try {
				PaymentCreateRequest createRequest = PaymentCreateRequest.builder().description("Divisão do lanche")
						.transactionAmount(value.getPrice()).paymentMethodId("pix")
						.payer(PaymentPayerRequest.builder().email(value.getPerson().getEmail()).firstName(value.getPerson().getName())
								.entityType("individual").type("customer").build())
						.build();

				ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
				ObjectMapper mapper = new ObjectMapper();

				Payment payment = client.create(createRequest);
				JsonNode content = mapper.readTree(
						mapper.readTree(ow.writeValueAsString(payment)).get("response").get("content").asText());
				String ticket_url = content.get("point_of_interaction").get("transaction_data").get("ticket_url")
						.asText().toString();
				responses.add(new PaymentResponseDTO(value.getPerson(), payment.getTransactionAmount(), ticket_url));
			} catch (MPApiException apiException) {
				System.out.println(apiException.getApiResponse().getContent());
				throw new RuntimeException(apiException.getApiResponse().getContent());
			} catch (MPException exception) {
				System.out.println(exception.getMessage());
				throw new RuntimeException(exception.getMessage());
			} catch (JsonProcessingException exception) {
				System.out.println(exception.getMessage());
				throw new RuntimeException(exception.getMessage());
			}

		});
		return responses;
	}
}
