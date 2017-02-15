package io.egen.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Artist;
import io.egen.api.entity.Content;
import io.egen.api.entity.ContentArtist;
import io.egen.api.exception.BadRequestException;
import io.egen.api.exception.EntityNotFoundException;
import io.egen.api.repository.ArtistRepository;
import io.egen.api.repository.ContentRepository;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentRepository repository;
	
	@Autowired
	private ArtistRepository artistRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Content> getAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Content getOne(String id) {
		Content emp = repository.findOne(id);
		if (emp == null) {
			throw new EntityNotFoundException("content not found");
		}
		return emp;
	}

	@Override
	@Transactional
	public Content post(Content content) {
		Content existing = repository.findOne(content.getId());
		if (existing != null) {
			throw new BadRequestException("content already exists");
		}
		
		List<ContentArtist> contentArtists = new ArrayList<>();
		
		Iterator<ContentArtist> it = content.getContentArtists().iterator();
		while(it.hasNext()){
			ContentArtist ca = it.next();
			Artist artist = artistRepository.findOne(ca.getArtistId());
			if(artist != null){
				ca.setArtist(artist);
				ca.setArtistId(artist.getId());
				ca.setContent(content);
				ca.setContentId(content.getId());
				contentArtists.add(ca);
				
				artist.getContentArtists().add(ca);
				artistRepository.update(artist);
			}
		}
		content.setContentArtists(contentArtists);
		return repository.create(content);
	}

	@Override
	@Transactional
	public Content put(String id, Content content) {
		Content existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("content not found");
		}
		
		List<ContentArtist> contentArtists = new ArrayList<>();
		
		Iterator<ContentArtist> it = existing.getContentArtists().iterator();
		while(it.hasNext()){
			ContentArtist ca = it.next();
			Artist artist = artistRepository.findOne(ca.getArtistId());
			
			if(artist != null){
				artist.getContentArtists().remove(ca);
				artistRepository.update(artist);
			}
			
			existing.getContentArtists().remove(ca);	
		}
		existing = repository.update(existing);
		
		replaceContent(existing, content);
		
		it = content.getContentArtists().iterator();
		while(it.hasNext()){
			ContentArtist ca = it.next();
			Artist artist = artistRepository.findOne(ca.getArtistId());
			if(artist != null){
				ca.setArtist(artist);
				ca.setArtistId(artist.getId());
				ca.setContent(existing);
				ca.setContentId(existing.getId());
				contentArtists.add(ca);
				
				artist.getContentArtists().add(ca);
				artistRepository.update(artist);
			}
		}
		existing.setContentArtists(contentArtists);
		
		return repository.update(existing);
	}
	
	@Override
	@Transactional
	public void delete(String id) {
		Content existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("content not found");
		}
		repository.delete(existing);
	}
	
	private void replaceContent(Content existing, Content content){
		existing.setGenre(content.getGenre());
		existing.setImdbRating(content.getImdbRating());
		existing.setImdbVotes(content.getImdbVotes());
		existing.setPlot(content.getPlot());
		existing.setTitle(content.getTitle());
		existing.setType(content.getType());
		existing.setYear(content.getYear());
	}
}