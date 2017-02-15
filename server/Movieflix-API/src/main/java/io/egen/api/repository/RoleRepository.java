package io.egen.api.repository;

import java.util.List;

import io.egen.api.entity.Role;

public interface RoleRepository {

	public List<Role> findAll();

	public Role findOne(String id);
	
	public Role findByName(String name);

	public Role create(Role Role);

	public Role update(Role Role);

	public void delete(Role Role);
}
