package io.egen.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Employee;
import io.egen.api.exception.BadRequestException;
import io.egen.api.exception.EntityNotFoundException;
import io.egen.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findOne(String id) {
		Employee emp = repository.findOne(id);
		if (emp == null) {
			throw new EntityNotFoundException("Employee not found");
		}
		return emp;
	}

	@Override
	@Transactional
	public Employee create(Employee emp) {
		Employee existing = repository.findByEmail(emp.getEmail());
		if (existing != null) {
			throw new BadRequestException("Employee with this email already exists");
		}
		return repository.create(emp);
	}

	@Override
	@Transactional
	public Employee update(String id, Employee emp) {
		Employee existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Employee not found");
		}
		return repository.update(emp);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Employee existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Employee not found");
		}
		repository.delete(existing);
	}
}