package io.egen.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api.entity.Artist;
import io.egen.api.service.ArtistService;

@RestController
@RequestMapping(value = "artists")
public class ArtistController {

	@Autowired
	private ArtistService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Artist> getAll() {
		return service.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Artist getOne(@PathVariable("id") String id) {
		return service.getOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Artist post(@RequestBody Artist artist) {
		return service.post(artist);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Artist put(@PathVariable("id") String id, @RequestBody Artist artist) {
		return service.put(id, artist);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}