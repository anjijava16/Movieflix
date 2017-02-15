package io.egen.api.service;

import java.util.List;

import io.egen.api.entity.Artist;

public interface ArtistService {

	public List<Artist> getAll();

	public Artist getOne(String id);

	public Artist post(Artist artist);

	public Artist put(String id, Artist artist);

	public void delete(String id);
}
