package org.ameya.model;

public class Photo {

	private int albumId;
	private String title;
	private String url;
	private int id;

	public Photo() {

	}

	public Photo(int albumId, String title, String url, int photoId) {
		this.albumId = albumId;
		this.title = title;
		this.url = url;
		this.id = photoId;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
