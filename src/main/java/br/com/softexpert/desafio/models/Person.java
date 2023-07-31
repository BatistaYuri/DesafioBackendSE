package br.com.softexpert.desafio.models;

import java.util.Objects;

public class Person {
	private Integer id;
	private String nome;
	private String email;
	public Person(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		Person other = (Person) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(email, other.email);
	}
}
