package com.kiwigrid.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Venda extends PanacheEntity {
	
	@ManyToOne
	private Vendedor vendedor;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ProdutoVenda> produtos;

	public Venda() {}

	public Venda(Vendedor vendedor, List<ProdutoVenda> produtos) {
		this.vendedor = vendedor;
		this.produtos = produtos;
	}

	@Transient
	public Double getValorTotal() {
		return produtos
			.stream()
			.map(produtoVenda -> produtoVenda.getSubTotal())
			.mapToDouble(Double::doubleValue)
			.sum();
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public List<ProdutoVenda> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoVenda> produtos) {
		this.produtos = produtos;
	}

}
