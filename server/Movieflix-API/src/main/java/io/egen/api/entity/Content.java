package io.egen.api.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({ 
	@NamedQuery(name = "Content.findAll", query = "SELECT c FROM Content c")
})
public class Content {

	@Id
	private String id;
	
	private String title;
	
	private String plot;
	
	@Column(name="IMDB_RATING")
	private float imdbRating;
	
	@Enumerated(EnumType.STRING) // Helps to persist enums as String in DB instead of Ordinal
	private ContentType type;
	
	private int year;
	
	@Enumerated(EnumType.STRING) // Helps to persist enums as String in DB instead of Ordinal
	private Genre genre;
	
	@Column(name="IMDB_VOTES")
	private int imdbVotes;

	private List<ContentArtist> contentArtists;
	
	public Content(){
		this.id = UUID.randomUUID().toString();
		contentArtists = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPlot() {
		return plot;
	}
	
	public void setPlot(String plot) {
		this.plot = plot;
	}
	
	public float getImdbRating() {
		return imdbRating;
	}
	
	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}
	
	public ContentType getType() {
		return type;
	}
	
	public void setType(ContentType type) {
		this.type = type;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public int getImdbVotes() {
		return imdbVotes;
	}
	
	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	
	@OneToMany(mappedBy = "content", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ContentArtist.class, orphanRemoval = true)
    public List<ContentArtist> getContentArtists() {
        return this.contentArtists;
    }
	
	public void setContentArtists(List<ContentArtist> contentArtists) {
        this.contentArtists = contentArtists;
    }
	
	@Override
	public String toString() {
		return "Content [id=" + id + ", title=" + title + ", plot=" + plot + ", imdbRating=" + imdbRating + ", type="
				+ type + ", year=" + year + ", genre=" + genre + ", imdbVotes=" + imdbVotes + ", contentArtists="
				+ contentArtists + "]";
	}
}
