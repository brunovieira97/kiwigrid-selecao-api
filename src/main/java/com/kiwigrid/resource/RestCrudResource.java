package com.kiwigrid.resource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kiwigrid.exception.ResourceNotFoundException;
import com.kiwigrid.service.Service;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class RestCrudResource<Entity, ID> {

	@Inject
	Service<Entity, ID> service;

	@GET
	public Response findAll() {
		return Response
			.status(Response.Status.OK)
			.entity(service.findAll())
			.build();
	}

	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") ID id) {
		try {
			return Response
				.status(Response.Status.OK)
				.entity(this.service.findById(id))
				.build();
		} catch (ResourceNotFoundException e) {
			return Response
				.status(Response.Status.NO_CONTENT)
				.build();
		}
	}

	@POST
	@Transactional
	public Response create(@Valid Entity entity) {
		return Response
			.status(Response.Status.CREATED)
			.entity(this.service.create(entity))
			.build();
	}

	@PUT
	@Path("/{id}")
	@Transactional
	public Response update(@PathParam("id") ID id, @Valid Entity entity) {
		try {
			this.service.update(id, entity);

			return Response
				.status(Response.Status.OK)
				.build();
		} catch (ResourceNotFoundException e) {
			return Response
				.status(Response.Status.NO_CONTENT)
				.build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Transactional
	public Response delete(@PathParam("id") ID id) {
		try {
			this.service.delete(id);

			return Response
				.status(Response.Status.OK)
				.build();
		} catch (ResourceNotFoundException e) {
			return Response
				.status(Response.Status.NO_CONTENT)
				.build();
		}
	}
}
