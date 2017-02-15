package io.egen.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Role;
import io.egen.api.entity.User;
import io.egen.api.exception.BadRequestException;
import io.egen.api.exception.EntityNotFoundException;
import io.egen.api.repository.RoleRepository;
import io.egen.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	@Transactional(readOnly = true)
	public List<User> getAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User getOne(String id) {
		User emp = repository.findOne(id);
		if (emp == null) {
			throw new EntityNotFoundException("User not found");
		}
		return emp;
	}

	@Override
	@Transactional
	public User post(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if (existing != null) {
			throw new BadRequestException("User with this email already exists");
		}
		Role role = roleRepository.findByName("User");
		user.setRole(role);
		return repository.create(user);
	}

	@Override
	@Transactional
	public User put(String id, User user) {
		User existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		user.setId(id);
		Role role = roleRepository.findByName("User");
		user.setRole(role);
		return repository.update(user);
	}
	
	@Override
	@Transactional
	public void delete(String id) {
		User existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		repository.delete(existing);
	}
}