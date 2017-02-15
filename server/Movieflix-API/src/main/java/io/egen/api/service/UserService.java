package io.egen.api.service;

import java.util.List;

import io.egen.api.entity.User;

public interface UserService {

	public List<User> getAll();

	public User getOne(String id);

	public User post(User user);

	public User put(String id, User user);

	public void delete(String id);
}
