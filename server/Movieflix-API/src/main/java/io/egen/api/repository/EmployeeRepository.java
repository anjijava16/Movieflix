package io.egen.api.repository;

import java.util.List;

import io.egen.api.entity.Employee;

public interface EmployeeRepository {

	public List<Employee> findAll();

	public Employee findOne(String id);
	
	public Employee findByEmail(String email);

	public Employee create(Employee emp);

	public Employee update(Employee emp);

	public void delete(Employee emp);
}
