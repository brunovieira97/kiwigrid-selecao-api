package com.kiwigrid.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.kiwigrid.exception.ResourceNotFoundException;
import com.kiwigrid.model.Produto;

@ApplicationScoped
public class ProdutoService implements Service<Produto, Long> {
	
	public List<Produto> findAll() {
		return Produto.listAll();
	}

	public Produto findById(Long id) throws ResourceNotFoundException {
		Produto produto = Produto.findById(id);

		if (produto == null)
			throw new ResourceNotFoundException();

		return produto;
	}

	public Produto create(Produto produto) {
		produto.persist();

		return produto;
	}

	public void update(Long id, Produto produtoNew) throws ResourceNotFoundException {
		Produto produto = this.findById(id);

		produto = this.updateProduto(produto, produtoNew);
		produto.persist();
	}

	public void delete(Long id) throws ResourceNotFoundException {
		Produto produto = this.findById(id);

		produto.delete();
	}

	private Produto updateProduto(Produto produto, Produto produtoNew) {
		produto.setNome(produtoNew.getNome());
		produto.setPreco(produtoNew.getPreco());

		return produto;
	}
}
