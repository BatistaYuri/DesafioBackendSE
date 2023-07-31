package br.com.softexpert.desafio.models;

import java.math.BigDecimal;
import java.util.List;

public class Bill {
	private Integer id;
	private List<Order> orders;
	private List<BigDecimal> additions;
	private List<BigDecimal> discounts;
	public Bill(Integer id, List<Order> orders, List<BigDecimal> additions, List<BigDecimal> discounts) {
		super();
		this.id = id;
		this.orders = orders;
		this.additions = additions;
		this.discounts = discounts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<BigDecimal> getAdditions() {
		return additions;
	}
	public void setAdditions(List<BigDecimal> additions) {
		this.additions = additions;
	}
	public List<BigDecimal> getDiscounts() {
		return discounts;
	}
	public void setDiscounts(List<BigDecimal> discounts) {
		this.discounts = discounts;
	}
	
}
