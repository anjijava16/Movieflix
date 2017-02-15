package io.egen.api.repository;

import java.util.List;

import io.egen.api.entity.Artist;

public interface ArtistRepository {

	public List<Artist> findAll();

	public Artist findOne(String id);

	public Artist create(Artist artist);

	public Artist update(Artist artist);

	public void delete(Artist artist);
}
