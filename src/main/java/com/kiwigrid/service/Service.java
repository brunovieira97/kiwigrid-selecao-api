package com.kiwigrid.service;

import java.util.List;

import com.kiwigrid.exception.ResourceNotFoundException;

public interface Service<Entity, ID> {
	
	public List<Entity> findAll();

	public Entity findById(ID id) throws ResourceNotFoundException;

	public Entity create(Entity entity);

	public void update(ID id, Entity entity) throws ResourceNotFoundException;

	public void delete(ID id) throws ResourceNotFoundException;

}
