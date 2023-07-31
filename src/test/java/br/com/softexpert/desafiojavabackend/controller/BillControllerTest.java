package br.com.softexpert.desafiojavabackend.controller;

import java.math.BigDecimal;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.softexpert.desafio.controller.BillController;
import br.com.softexpert.desafio.models.Bill;
import br.com.softexpert.desafio.models.dto.PaymentResponseDTO;
import br.com.softexpert.desafio.service.BillService;
import br.com.softexpert.desafiojavabackend.util.BillCreator;
import br.com.softexpert.desafiojavabackend.util.PaymentResponseDTOCreator;

@ExtendWith(SpringExtension.class)
class BillControllerTest {
	
	@InjectMocks
	private BillController billController;
	
	@Mock
	private BillService billServiceMock;
	
	private Bill bill;
	
	@BeforeEach
	void setUp() {
		this.bill = BillCreator.createBill();
		List<PaymentResponseDTO> responses = List.of(PaymentResponseDTOCreator.createPaymentResponseDTO());
		BDDMockito.when(billServiceMock.payment(this.bill, "mercado_pago")).thenReturn(responses);
	}

	@Test
	@DisplayName("validate values mercado pago")
	void validateValuesMercadoPago() {
		List<PaymentResponseDTO> responses = billController.payment("mercado_pago", this.bill);
		
		Assertions.assertThat(responses).isNotNull();
		
		Assertions.assertThat(responses).isNotEmpty();
		
		Assertions.assertThat(responses.get(0).getPrice()).isEqualTo(new BigDecimal(6.08));
	}

}
