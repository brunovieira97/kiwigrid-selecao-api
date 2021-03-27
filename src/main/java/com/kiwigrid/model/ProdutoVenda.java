package com.kiwigrid.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class ProdutoVenda extends PanacheEntity {
	
	@JsonBackReference(value = "produto_produtoVenda")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Produto produto;

	@NotNull
	@Positive
	private Integer quantidade;

	@JsonBackReference(value = "venda_produtoVenda")
	@ManyToOne(fetch = FetchType.LAZY)
	private Venda venda;

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

	public Venda getVenda() {
		return venda;
	}

}
