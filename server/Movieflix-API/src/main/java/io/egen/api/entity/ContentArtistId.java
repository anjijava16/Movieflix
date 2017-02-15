package io.egen.api.entity;

import java.io.Serializable;

import javax.persistence.Transient;

public class ContentArtistId implements Serializable {

	private static final long serialVersionUID = 5377601138377917767L;
	
	private String contentId;
	private String artistId;
	
	@Transient
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	
	@Transient
	public String getArtistId() {
		return artistId;
	}
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}
	
	
}