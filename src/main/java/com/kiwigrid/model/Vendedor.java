package com.kiwigrid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Vendedor extends PanacheEntity {
	
	@NotBlank
	private String nome;

	@NotBlank
	@Column(unique = true)
	@Size(min = 5, max = 5)
	private String matricula;

	public Vendedor() {}

	public Vendedor(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
