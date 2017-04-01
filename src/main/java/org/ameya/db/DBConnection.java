package org.ameya.db;

import java.util.*;
import org.ameya.model.*;

public class DBConnection {

	private HashMap<Integer, Collection<Photo>> photosInAlbum = new HashMap<>();
	private HashMap<Integer, Album> albums = new HashMap<>();
	private HashMap<Integer, Photo> photosfromId = new HashMap<>();
	private static DBConnection dbConnection;
	
	private DBConnection(){
		
	}
	
	public HashMap<Integer, Collection<Photo>> getPhotosInAlbums() {
		return photosInAlbum;
	} 
	
	public HashMap<Integer, Album> getAlbums() {
		return albums;
	}
	
	public static DBConnection create(){
		if(dbConnection == null){
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}

	public void addAlbum(Album album) {
		albums.put(album.getId(), album);		
		
	}

	public void removeAlbum(int albumId) {
		albums.remove(albumId);		
	}

	public void addPhoto(Photo photo) {
		int albumId = photo.getAlbumId();
		Collection<Photo> photos = photosInAlbum.get(albumId);
		if(photos == null){
			photos = new HashSet<>();
			photosInAlbum.put(albumId, photos);
		}
		photos.add(photo);
	}

	public void removePhoto(Long photoId) {
		Photo photo = getPhoto(photoId);
		int albumId = photo.getAlbumId();
		Collection<Photo> photos = photosInAlbum.get(albumId);
		photos.remove(photo);
	}

	public Photo getPhoto(Long photoId) {
		return photosfromId.get(photoId);
	}
}
