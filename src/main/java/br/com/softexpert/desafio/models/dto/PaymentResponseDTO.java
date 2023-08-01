package br.com.softexpert.desafio.models.dto;

import java.math.BigDecimal;

import br.com.softexpert.desafio.models.Person;

public class PaymentResponseDTO {
	private Person person;
	private BigDecimal price;
	private String url;
	public PaymentResponseDTO(Person person, BigDecimal price, String url) {
		super();
		this.person = person;
		this.price = price;
		this.url = url;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
