package io.egen.api.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Artist.findAll", query = "SELECT a FROM Artist a")
})
public class Artist {

	@Id
	private String id;
	
	private String name;
	
	private List<ContentArtist> contentArtists;
	
	public Artist(){
		this.id = UUID.randomUUID().toString();
		contentArtists = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ContentArtist.class)
    public List<ContentArtist> getContentArtists() {
        return contentArtists;
    }

    public void setContentArtists(List<ContentArtist> contentArtists) {
        this.contentArtists = contentArtists;
    }

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", contentArtists=" + contentArtists + "]";
	}
    
}
