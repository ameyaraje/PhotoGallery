package org.ameya.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

public class Photo {
	
	private int albumId;	
	private String photoTitle;
	private String url;
	private int photoId;
	
	public Photo() {
		
	}
	
	public Photo(int albumId, String photoTitle, String url, int photoId) {
		this.albumId = albumId;
		this.photoTitle = photoTitle;
		this.url = url;
		this.photoId = photoId;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getPhotoTitle() {
		return photoTitle;
	}

	public void setPhotoTitle(String photoTitle) {
		this.photoTitle = photoTitle;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getPhotoId() {
		return photoId;
	}
	
	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}
}
