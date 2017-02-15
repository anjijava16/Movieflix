package io.egen.api.service;

import java.util.List;

import io.egen.api.entity.Content;

public interface ContentService {

	public List<Content> getAll();

	public Content getOne(String id);

	public Content post(Content content);

	public Content put(String id, Content content);

	public void delete(String id);
}
