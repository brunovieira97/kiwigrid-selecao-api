package com.kiwigrid.resource;

import javax.ws.rs.Path;

import com.kiwigrid.model.Produto;

@Path("/produtos")
public class ProdutoResource extends RestCrudResource<Produto, Long> {
	
}
