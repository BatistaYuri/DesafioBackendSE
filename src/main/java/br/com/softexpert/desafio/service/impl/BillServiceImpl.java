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

		List<Order> payerOrders = bill.getOrders().stream().filter(order -> !order.getPerson().getPayer()).toList();

		return payerOrders.stream().collect(Collectors.groupingBy((order) -> order.getPerson().getId(),
				Collectors.collectingAndThen(Collectors.reducing(new Order(), Order::merge), (order) -> {
					return new BillPerson(order.getPerson(), this.getTotalPerson(totalOrders, order.getPrice(),
							bill.getAdditions(), bill.getDiscounts()));
				})));
	}

	private BigDecimal getTotalPerson(BigDecimal total, BigDecimal totalPerson, List<BigDecimal> additions,
			List<BigDecimal> discounts) {
		BigDecimal additionPerPerson = totalPerson.multiply(additions.stream().reduce(BigDecimal.ZERO, BigDecimal::add))
				.divide(total, 2, RoundingMode.HALF_UP);
		BigDecimal discountPerPerson = totalPerson.multiply(discounts.stream().reduce(BigDecimal.ZERO, BigDecimal::add))
				.divide(total, 2, RoundingMode.HALF_UP);
		return totalPerson.add(additionPerPerson).subtract(discountPerPerson).setScale(2, RoundingMode.HALF_EVEN);
	}
}
