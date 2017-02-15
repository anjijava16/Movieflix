package io.egen.api.repository;

import java.util.List;

import io.egen.api.entity.Content;

public interface ContentRepository {

	public List<Content> findAll();

	public Content findOne(String id);

	public Content create(Content content);

	public Content update(Content content);

	public void delete(Content content);
}
