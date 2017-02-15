package io.egen.api.service;

import java.util.List;

import io.egen.api.entity.Role;

public interface RoleService {

	public List<Role> findAll();

	public Role findOne(String id);

	public Role create(Role role);

	public Role update(String id, Role role);

	public void delete(String id);
}
