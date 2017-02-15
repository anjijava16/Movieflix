package io.egen.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Role;
import io.egen.api.exception.BadRequestException;
import io.egen.api.exception.EntityNotFoundException;
import io.egen.api.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Role> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Role findOne(String id) {
		Role emp = repository.findOne(id);
		if (emp == null) {
			throw new EntityNotFoundException("Role not found");
		}
		return emp;
	}

	@Override
	@Transactional
	public Role create(Role role) {
		Role existing = repository.findByName(role.getName());
		if (existing != null) {
			throw new BadRequestException("Role already exists");
		}
		return repository.create(role);
	}

	@Override
	@Transactional
	public Role update(String id, Role role) {
		Role existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Role not found");
		}
		return repository.update(role);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Role existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Role not found");
		}
		repository.delete(existing);
	}
}