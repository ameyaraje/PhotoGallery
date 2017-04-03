package org.ameya.db;

import org.ameya.model.Album;
import org.ameya.model.Photo;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import java.util.*;

import com.mongodb.*;

public class MongoUtil {
	private static final String DATABASE_NAME = "albummanager";
	private final Datastore datastore;
	private MongoClient mongoClient;
	private static MongoUtil mongoUtil = null;

	private MongoUtil () {
		mongoClient = new MongoClient();
		Morphia morphia = new Morphia();

		morphia.mapPackage("org.ameya.model");

		datastore = morphia.createDatastore(mongoClient, DATABASE_NAME);
		datastore.ensureIndexes();
	}

	public static MongoUtil create() {
		if (mongoUtil == null) {
			mongoUtil = new MongoUtil();
		}
		return mongoUtil;
	}	
	
	public void addAlbum(Album album) {
		datastore.save(album);			
	}
	
	public void addPhoto(Photo photo) {
		datastore.save(photo);
	}
	
	public void addAlbum(Album[] albums) {
		for (Album album : albums)
			addAlbum(album);
	}
	
	public void addPhoto(Photo[] photos) {
		for (Photo photo : photos)
			addPhoto(photo);
	}
	
	public boolean removeAlbum(int albumId) {
		List<Photo> photos;
		photos = datastore.createQuery(Photo.class).field("albumId").equal(albumId).asList();
		if (photos.size() == 0) {
			datastore.delete(Album.class, albumId);
			return true;
		}
		else 
			return false;
	}

	public void removePhoto(int photoId) {
		datastore.delete(Photo.class, photoId);
	}
	
	public List<Album> getAlbums() {
		return datastore.createQuery(Album.class).asList();
	}

	public List<Photo> getAllPhotos() {
		return datastore.createQuery(Photo.class).asList();
	}

	public Photo getPhoto(int photoId) {
		return datastore.get(Photo.class, photoId);
	}

	public List<Photo> getPhotosInAlbum(int albumId) {
		return datastore.createQuery(Photo.class).field("albumId").equal(albumId).asList();	
	}

	public boolean updatePhoto(Photo photo, int photoId) {
		Photo photoFromDB = datastore.get(Photo.class, photoId);
		if (photo == null)
			return false;
		
		photoFromDB.setAlbumId(photo.getAlbumId() == 0 ? photoFromDB.getAlbumId() : photo.getAlbumId());
		photoFromDB.setId(photo.getId() == 0 ? photoFromDB.getId() : photo.getId());
		photoFromDB.setTitle(photo.getTitle() == null ? photoFromDB.getTitle() : photo.getTitle());
		photoFromDB.setUrl(photo.getUrl() == null ? photoFromDB.getUrl() : photo.getUrl());
		
		datastore.save(photoFromDB);

		return true;
	}

	public boolean updateAlbum(Album album, int albumId) {
		Album albumFromDB = datastore.get(Album.class, albumId);
		if (albumFromDB == null)
			return false;
		
		albumFromDB.setId(album.getId() == 0 ? albumFromDB.getId() : album.getId());
		albumFromDB.setTitle(album.getTitle() == null ? albumFromDB.getTitle() : album.getTitle());
		
		datastore.save(albumFromDB);
		
		return true;
	}
}
