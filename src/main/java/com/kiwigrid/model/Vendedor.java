package com.kiwigrid.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Vendedor extends PanacheEntity {
	
	@NotBlank
	private String nome;

	@NotBlank
	@Column(unique = true)
	@Size(min = 5, max = 5)
	private String matricula;

	@JsonIgnore
	@OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY)
	private List<Venda> vendas;

	public Vendedor() {}

	public Vendedor(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}

	@Transient
	public Integer getQuantidadeVendas() {
		return vendas.size();
	}

	@Transient
	public Double getValorTotalVendas() {
		return vendas
			.stream()
			.map(venda -> venda.getValorTotal())
			.mapToDouble(Double::doubleValue)
			.sum();
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

	public List<Venda> getVendas() {
		return this.vendas;
	}

}
