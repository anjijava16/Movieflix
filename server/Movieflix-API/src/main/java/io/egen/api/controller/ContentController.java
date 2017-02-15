package io.egen.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api.entity.Content;
import io.egen.api.service.ContentService;

@RestController
@RequestMapping(value = "contents")
public class ContentController {

	@Autowired
	private ContentService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Content> getAll() {
		return service.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Content getOne(@PathVariable("id") String id) {
		return service.getOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Content post(@RequestBody Content content) {
		return service.post(content);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Content put(@PathVariable("id") String id, @RequestBody Content content) {
		return service.put(id, content);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}