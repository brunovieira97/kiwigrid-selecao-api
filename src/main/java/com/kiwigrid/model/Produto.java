package com.kiwigrid.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Produto extends PanacheEntity {
	
	@NotBlank
	private String nome;
	
	@NotNull
	@PositiveOrZero
	private Double preco;

	@JsonIgnore
	@JsonManagedReference(value = "produto_produtoVenda")
	@OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
	private List<ProdutoVenda> produtosVenda;

	public Produto() {}

	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	@Transient
	public Integer getVendidos() {
		return produtosVenda
			.stream()
			.map(produtoVenda -> produtoVenda.getQuantidade())
			.mapToInt(Integer::intValue)
			.sum();
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
