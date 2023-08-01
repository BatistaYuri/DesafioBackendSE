package br.com.softexpert.desafio.models;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Person {
	@NotNull
	private Integer id;
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	@Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	@NotNull
	private Boolean payer;
	public Person(Integer id, String name, String email, Boolean payer) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.payer = payer;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getPayer() {
		return payer;
	}
	public void setPayer(Boolean payer) {
		this.payer = payer;
	}

	@Override
	public boolean equals(Object obj) {
		Person other = (Person) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(email, other.email) && Objects.equals(payer, other.payer);
	}
}
