package br.com.softexpert.desafio.models;

import java.math.BigDecimal;

public class Order {
	private Integer id;
	private BigDecimal price;
	private Person person;
	public Order(Integer id, BigDecimal price, Person person) {
		super();
		this.id = id;
		this.price = price;
		this.person = person;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
