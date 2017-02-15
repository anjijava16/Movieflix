package io.egen.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Artist;
import io.egen.api.exception.BadRequestException;
import io.egen.api.exception.EntityNotFoundException;
import io.egen.api.repository.ArtistRepository;

@Service
public class ArtistServiceImpl implements ArtistService {

	@Autowired
	private ArtistRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Artist> getAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Artist getOne(String id) {
		Artist emp = repository.findOne(id);
		if (emp == null) {
			throw new EntityNotFoundException("artist not found");
		}
		return emp;
	}

	@Override
	@Transactional
	public Artist post(Artist artist) {
		Artist existing = repository.findOne(artist.getId());
		if (existing != null) {
			throw new BadRequestException("artist already exists");
		}
		return repository.create(artist);
	}

	@Override
	@Transactional
	public Artist put(String id, Artist artist) {
		Artist existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("artist not found");
		}
		artist.setId(id);
		return repository.update(artist);
	}
	
	@Override
	@Transactional
	public void delete(String id) {
		Artist existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("artist not found");
		}
		repository.delete(existing);
	}
}