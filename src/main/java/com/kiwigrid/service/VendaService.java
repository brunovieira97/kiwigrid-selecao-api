package com.kiwigrid.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.kiwigrid.exception.ResourceNotFoundException;
import com.kiwigrid.model.Venda;

@ApplicationScoped
public class VendaService implements Service<Venda, Long> {

	@Override
	public List<Venda> findAll() {
		return Venda.listAll();
	}

	@Override
	public Venda findById(Long id) throws ResourceNotFoundException {
		Venda venda = Venda.findById(id);

		if (venda == null)
			throw new ResourceNotFoundException();

		return venda;
	}

	@Override
	public void create(Venda venda) {
		venda.persist();
	}

	@Override
	public void update(Long id, Venda vendaNew) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Long id) {
		throw new UnsupportedOperationException();
	}
	
}
