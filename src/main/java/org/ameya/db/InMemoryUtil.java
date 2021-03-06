package org.ameya.db;

import java.util.*;
import org.ameya.model.*;

public class InMemoryUtil {

	private HashMap<Integer, Collection<Photo>> photosInAlbum = new HashMap<>();
	private HashMap<Integer, Album> albums = new HashMap<>();
	private HashMap<Integer, Photo> photosfromId = new HashMap<>();
	private static InMemoryUtil dbUtil;

	public static InMemoryUtil create() {
		if (dbUtil == null) {
			dbUtil = new InMemoryUtil();
		}
		return dbUtil;
	}	

	public void addAlbum(Album album) {
		albums.put(album.getId(), album);			
	}

	public boolean removeAlbum(int albumId) {
		if (albums.containsKey(albumId)) 
			return false;

		Collection<Photo> photos = photosInAlbum.get(albumId);
		if (!photos.isEmpty()) {
			return false;
		}	
		
		albums.remove(albumId);
		photosInAlbum.remove(albumId);
		
		return true;
	}

	public boolean updateAlbum(Album album, int albumId) {
		if (!albums.containsKey(albumId))
			return false;
		
		albums.remove(albumId);
		albums.put(albumId, album);
		return true;	
	}

	public boolean addPhoto(Photo photo) {
		int albumId = photo.getAlbumId();
		Collection<Photo> photos = photosInAlbum.get(albumId);
		
		if (!albums.containsKey(albumId))
			return false;
		
		if (photos == null) {
			photos = new HashSet<>();
			photosInAlbum.put(albumId, photos);
		}
		
		photos.add(photo);
		photosfromId.put(photo.getId(), photo);		
		
		return true;
	}

	public boolean removePhoto(int photoId) {
		Photo photo = getPhoto(photoId);
		if (photo == null) 
			return false;
		
		int albumId = photo.getAlbumId();
		Collection<Photo> photos = photosInAlbum.get(albumId);
		photos.remove(photo);
		photosfromId.remove(photoId);
		
		return true;
	}

	public boolean updatePhoto(Photo photo, int photoId) {
		Photo photoFromPhotoMap = photosfromId.get(photoId);
		int albumId = photo.getAlbumId();
		Collection<Photo> photos = photosInAlbum.get(albumId);
		
		if (photoFromPhotoMap == null)
			return false;
		
		photos.remove(photoFromPhotoMap);
		photos.add(photo);

		photoFromPhotoMap.setId(photoId);
		photoFromPhotoMap.setTitle(photo.getTitle());
		photoFromPhotoMap.setUrl(photo.getUrl());
		photoFromPhotoMap.setAlbumId(photo.getAlbumId());
		return true;
	}

	public Photo getPhoto(int photoId) {
		return photosfromId.get(photoId);
	}

	public Collection<Photo> getPhotosInAlbum(int albumId) {
		return photosInAlbum.get(albumId);
	}

	public HashMap<Integer, Collection<Photo>> getPhotosInAlbums() {
		return photosInAlbum;
	} 
	
	public HashMap<Integer, Album> getAlbums() {
		return albums;
	}

	public void addAlbum(Album[] albums) {
		for (Album album: albums)
			addAlbum(album);
	}

	public void addPhoto(Photo[] photos) {
		for (Photo photo: photos)
			addPhoto(photo);
	}

	public Collection<Photo> getAllPhotos() {
		return photosfromId.values();
	}	
}
