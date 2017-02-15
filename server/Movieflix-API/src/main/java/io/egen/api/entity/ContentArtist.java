package io.egen.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CONTENT_ARTIST")
@IdClass(ContentArtistId.class)
public class ContentArtist {
	
	@Id
	private String contentId;
	
	@Id
	private String artistId;
	
    @NotNull
    @Enumerated(EnumType.STRING) // Helps to persist enums as String in DB instead of Ordinal
    @Column(name = "ARTIST_TYPE")
    private ArtistType artistType;
    
	//@JoinColumn(name = "CONTENT_ID", updatable = false, insertable = false, referencedColumnName = "ID")
	
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Content.class)
	@PrimaryKeyJoinColumn(name="CONTENTID", referencedColumnName="ID")
    @JsonIgnore
	private Content content;
	
	//@JoinColumn(name = "ARTIST_ID", updatable = false, insertable = false, referencedColumnName = "ID")
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Artist.class)
	@PrimaryKeyJoinColumn(name="ARTISTID", referencedColumnName="ID")
	@JsonIgnore
	private Artist artist;

	public ContentArtist(){
	}
	
	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public ArtistType getArtistType() {
		return artistType;
	}

	public void setArtistType(ArtistType artistType) {
		this.artistType = artistType;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
}
