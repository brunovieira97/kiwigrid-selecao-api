package com.kiwigrid.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.kiwigrid.model.Vendedor;
import com.kiwigrid.service.VendedorService;

@Path("/vendedores")
public class VendedorResource extends RestCrudResource<Vendedor, Long> {
	
	@GET
	@Path("/search")
	public Response searchByMatricula(@QueryParam("matricula") String matricula) {
		return Response
			.status(Response.Status.OK)
			.entity(
				((VendedorService) service).searchByMatricula(matricula)
			)
			.build();
	}
}
