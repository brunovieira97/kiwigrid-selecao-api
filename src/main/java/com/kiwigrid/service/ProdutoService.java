package com.kiwigrid.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.kiwigrid.exception.ResourceNotFoundException;
import com.kiwigrid.model.Produto;

@ApplicationScoped
public class ProdutoService implements Service<Produto, Long> {
	
	@Override
	public List<Produto> findAll() {
		return Produto.listAll();
	}

	@Override
	public Produto findById(Long id) throws ResourceNotFoundException {
		Produto produto = Produto.findById(id);

		if (produto == null)
			throw new ResourceNotFoundException();

		return produto;
	}

	@Override
	public void create(Produto produto) {
		produto.persist();
	}

	@Override
	public void update(Long id, Produto produtoNew) throws ResourceNotFoundException {
		Produto produto = this.findById(id);

		produto = this.updateProduto(produto, produtoNew);
		produto.persist();
	}

	@Override
	public void delete(Long id) throws ResourceNotFoundException {
		Produto produto = this.findById(id);

		produto.delete();
	}

	public List<Produto> rankByVendas() {
		List<Produto> produtos = Produto.listAll();

		return produtos
			.stream()
			.sorted(Comparator.comparing(Produto::getVendidos).reversed())
			.collect(Collectors.toList());
	}

	private Produto updateProduto(Produto produto, Produto produtoNew) {
		produto.setNome(produtoNew.getNome());
		produto.setPreco(produtoNew.getPreco());

		return produto;
	}
}
