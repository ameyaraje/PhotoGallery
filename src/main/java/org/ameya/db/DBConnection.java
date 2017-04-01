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

	public boolean removeAlbum(int albumId) {
		if(albums.containsKey(albumId)){
			return false;
		}
		photosInAlbum.remove(albumId);
		return true;
	}

	public void addPhoto(Photo photo) {
		int albumId = photo.getAlbumId();
		Collection<Photo> photos = photosInAlbum.get(albumId);
		if(photos == null){
			photos = new HashSet<>();
			photosInAlbum.put(albumId, photos);
		}
		photos.add(photo);
		photosfromId.put(photo.getPhotoId(), photo);		
	}

	public boolean removePhoto(int photoId) {
		Photo photo = getPhoto(photoId);
		if(photo == null){
			return false;
		}
		int albumId = photo.getAlbumId();
		Collection<Photo> photos = photosInAlbum.get(albumId);
		photos.remove(photo);
		photosfromId.remove(photoId);
		return true;
	}

	public Photo getPhoto(int photoId) {
		return photosfromId.get(photoId);
	}

	public Collection<Photo> getPhotosInAlbum(int albumId) {
		return photosInAlbum.get(albumId);
	}
}
