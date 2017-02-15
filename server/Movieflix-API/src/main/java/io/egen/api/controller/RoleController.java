package io.egen.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api.entity.Role;
import io.egen.api.service.RoleService;

@RestController
@RequestMapping(value = "roles")
public class RoleController {

	@Autowired
	private RoleService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Role> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Role findOne(@PathVariable("id") String id) {
		return service.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Role create(@RequestBody Role role) {
		return service.create(role);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Role update(@PathVariable("id") String id, @RequestBody Role role) {
		return service.update(id, role);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}