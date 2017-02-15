package io.egen.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.api.entity.Content;

@Repository
public class ContentRepositoryImpl implements ContentRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Content> findAll() {
		TypedQuery<Content> query = em.createNamedQuery("Content.findAll", Content.class);
		return query.getResultList();
	}

	@Override
	public Content findOne(String id) {
		return em.find(Content.class, id);
	}

	@Override
	public Content create(Content content) {
		em.persist(content);
		return content;
	}

	@Override
	public Content update(Content content) {
		return em.merge(content);
	}

	@Override
	public void delete(Content content) {
		em.remove(content);
	}
}