package org.ameya.db;

import org.ameya.model.Album;
import org.ameya.model.Photo;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.*;

public class MongoUtil {
	private static final String DATABASE_NAME = "albummanager";
	private static final String HOST = "localhost:27017";
	private final Datastore datastore;
	private MongoClient mongoClient;
	private static MongoUtil mongoUtil = null;

	private MongoUtil () {
//		MongoClientURI uri  = new MongoClientURI(HOST);
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
	
	



}
