package br.com.softexpert.desafio.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.softexpert.desafio.service.BillService;
import br.com.softexpert.desafio.service.MercadoPagoService;
import br.com.softexpert.desafio.models.Bill;
import br.com.softexpert.desafio.models.BillPerson;
import br.com.softexpert.desafio.models.CompanyPaymentEnum;
import br.com.softexpert.desafio.models.Order;
import br.com.softexpert.desafio.models.dto.PaymentResponseDTO;

@Service("billService")
public class BillServiceImpl implements BillService {

	@Autowired
	MercadoPagoService mercadoPagoService;

	@Override
	public List<PaymentResponseDTO> payment(Bill bill, String company) {
		Map<Integer, BillPerson> totalPerPerson = this.getTotalPerPerson(bill);
		switch (CompanyPaymentEnum.fromString(company)) {
			case MERCADO_PAGO:
			default: 
				return mercadoPagoService.payment(totalPerPerson);
		}
	}

	private Map<Integer, BillPerson> getTotalPerPerson(Bill bill) {
		BigDecimal totalOrders = bill.getOrders().stream().reduce(BigDecimal.ZERO,
				(subtotal, order) -> subtotal.add(order.getPrice()), BigDecimal::add);
		
		List<Order> payerOrders = bill.getOrders().stream().filter(order -> order.getPerson() != null).toList();
		
		Map<Integer, BigDecimal> totalOrdersPersonId = payerOrders.stream()
				.collect(Collectors.groupingBy((order) -> order.getPerson().getId(),
						Collectors.reducing(BigDecimal.ZERO, Order::getPrice, BigDecimal::add)));
		
		return payerOrders.stream()
				.collect(Collectors.toMap((order) -> order.getPerson().getId(), (order) -> new BillPerson(order.getPerson(), 
						this.getTotalPerson(totalOrders, totalOrdersPersonId.get(order.getPerson().getId()), bill.getAdditions(), bill.getDiscounts()))));
	}


	private BigDecimal getTotalPerson(BigDecimal total, BigDecimal totalPerson, List<BigDecimal> additions,
			List<BigDecimal> discounts) {
		BigDecimal additionPerPerson = totalPerson.multiply(additions.stream().reduce(BigDecimal.ZERO, BigDecimal::add))
				.divide(total);
		BigDecimal discountPerPerson = totalPerson.multiply(discounts.stream().reduce(BigDecimal.ZERO, BigDecimal::add))
				.divide(total);
		return totalPerson.add(additionPerPerson).subtract(discountPerPerson).setScale(2, RoundingMode.HALF_EVEN);
	}
}
