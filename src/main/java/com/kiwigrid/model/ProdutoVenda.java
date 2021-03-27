package com.kiwigrid.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class ProdutoVenda extends PanacheEntity {
	
	@ManyToOne(optional = false)
	private Produto produto;

	@NotNull
	@Positive
	private Integer quantidade;

	public ProdutoVenda() {}

	public ProdutoVenda(Produto produto, Integer quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	@Transient
	public Double getSubTotal() {
		Double preco = this.getProduto().getPreco();
		preco = preco != null ? preco : 0;

		return preco * this.getQuantidade();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
