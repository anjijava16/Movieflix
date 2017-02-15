package io.egen.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.api.entity.Artist;

@Repository
public class ArtistRepositoryImpl implements ArtistRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Artist> findAll() {
		TypedQuery<Artist> query = em.createNamedQuery("Artist.findAll", Artist.class);
		return query.getResultList();
	}

	@Override
	public Artist findOne(String id) {
		return em.find(Artist.class, id);
	}

	@Override
	public Artist create(Artist artist) {
		em.persist(artist);
		return artist;
	}

	@Override
	public Artist update(Artist artist) {
		return em.merge(artist);
	}

	@Override
	public void delete(Artist artist) {
		em.remove(artist);
	}
}