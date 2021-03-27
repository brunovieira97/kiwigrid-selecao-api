package com.kiwigrid.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.kiwigrid.exception.ResourceNotFoundException;
import com.kiwigrid.model.Vendedor;

@ApplicationScoped
public class VendedorService implements Service<Vendedor, Long> {

	@Override
	public List<Vendedor> findAll() {
		return Vendedor.listAll();
	}

	@Override
	public Vendedor findById(Long id) throws ResourceNotFoundException {
		Vendedor vendedor = Vendedor.findById(id);

		if (vendedor == null)
			throw new ResourceNotFoundException();

		return vendedor;
	}

	@Override
	public void create(Vendedor vendedor) {
		vendedor.persist();
	}

	@Override
	public void update(Long id, Vendedor vendedorNew) throws ResourceNotFoundException {
		Vendedor vendedor = this.findById(id);

		vendedor = this.updateVendedor(vendedor, vendedorNew);
		vendedor.persist();	
	}

	@Override
	public void delete(Long id) throws ResourceNotFoundException {
		Vendedor vendedor = this.findById(id);

		vendedor.delete();	
	}

	public List<Vendedor> searchByMatricula(String matricula) {
		return Vendedor
			.find("matricula like ?1", "%" + matricula + "%")
			.list();
	}

	private Vendedor updateVendedor(Vendedor vendedor, Vendedor vendedorNew) {
		vendedor.setMatricula(vendedorNew.getMatricula());
		vendedor.setNome(vendedorNew.getNome());

		return vendedor;
	}
	
}
