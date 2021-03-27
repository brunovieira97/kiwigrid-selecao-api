package com.kiwigrid.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.kiwigrid.model.Produto;
import com.kiwigrid.service.ProdutoService;

@Path("/produtos")
public class ProdutoResource extends RestCrudResource<Produto, Long> {
	
	@GET
	@Path("/stats/rankByVendas")
	public Response rankByVendas() {
		return Response
			.status(Response.Status.OK)
			.entity(((ProdutoService) service).rankByVendas())
			.build();
	}
}
