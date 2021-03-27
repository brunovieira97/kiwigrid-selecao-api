package com.kiwigrid.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Produto extends PanacheEntity {
	
	@NotBlank
	private String nome;
	
	@NotNull
	@PositiveOrZero
	private Double preco;

	public Produto() {}

	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
