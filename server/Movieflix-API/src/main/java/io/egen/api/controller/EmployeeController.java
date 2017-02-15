package io.egen.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api.entity.Employee;
import io.egen.api.service.EmployeeService;

@RestController
@RequestMapping(value = "employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Employee findOne(@PathVariable("id") String empId) {
		return service.findOne(empId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Employee create(@RequestBody Employee emp) {
		return service.create(emp);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Employee update(@PathVariable("id") String id, @RequestBody Employee emp) {
		return service.update(id, emp);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}