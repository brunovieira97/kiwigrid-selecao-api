package com.kiwigrid.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.kiwigrid.model.Vendedor;
import com.kiwigrid.service.VendedorService;

@Path("/vendedores")
public class VendedorResource extends RestCrudResource<Vendedor, Long> {
	
	@GET
	@Path("/search")
	public List<Vendedor> searchByMatricula(@QueryParam("matricula") String matricula) {
		return ((VendedorService) service)
			.searchByMatricula(matricula);
	}
}
