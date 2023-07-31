package br.com.softexpert.desafio.models.dto;

import java.math.BigDecimal;

public class PaymentResponseDTO {
	private String namePerson;
	private BigDecimal price;
	private String url;
	public PaymentResponseDTO(String namePerson, BigDecimal price, String url) {
		super();
		this.namePerson = namePerson;
		this.price = price;
		this.url = url;
	}
	public String getNamePerson() {
		return namePerson;
	}
	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
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
