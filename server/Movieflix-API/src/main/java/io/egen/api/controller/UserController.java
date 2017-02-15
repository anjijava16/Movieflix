package io.egen.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api.entity.User;
import io.egen.api.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAll() {
		return service.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public User getOne(@PathVariable("id") String id) {
		return service.getOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public User post(@RequestBody User user) {
		return service.post(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public User put(@PathVariable("id") String id, @RequestBody User user) {
		return service.put(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}