package br.com.softexpert.desafio.models;

import java.math.BigDecimal;

public class BillPerson {
	private Person person;
	private BigDecimal price;
	public BillPerson(Person person, BigDecimal price) {
		super();
		this.person = person;
		this.price = price;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
