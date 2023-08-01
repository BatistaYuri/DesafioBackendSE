package br.com.softexpert.desafiojavabackend.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.softexpert.desafio.models.Bill;
import br.com.softexpert.desafio.models.Order;
import br.com.softexpert.desafio.models.Person;

public class BillCreator {
	
	public static Bill createBill() {
		List<Order> orders = new ArrayList<Order>();
		Person person = new Person(0, "Yuri", "yuri.b.1114@gmail.com", true);
		Order order1 = new Order(0, new BigDecimal(40), null);
		Order order2 = new Order(0, new BigDecimal(2), null);
		Order order3 = new Order(0, new BigDecimal(40), person);
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		List<BigDecimal> additions = new ArrayList<BigDecimal>();
		additions.add(new BigDecimal(8));
		List<BigDecimal> discounts = new ArrayList<BigDecimal>();
		discounts.add(new BigDecimal(20));
		return new Bill(0, orders, additions, discounts);
	}

}
