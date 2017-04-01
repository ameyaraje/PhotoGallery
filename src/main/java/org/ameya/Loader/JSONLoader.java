package org.ameya.Loader;

import java.net.MalformedURLException;
import java.net.URL;

import org.ameya.db.*;
import org.ameya.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JSONLoader {
	private DBConnection photosInAlbums;
	private DBConnection albumMap;
	
	private static final String ALBUMS_URI = "https://jsonplaceholder.typicode.com/albums";
	private static final String PHOTOS_URI = "https://jsonplaceholder.typicode.com/photos";
	
//	@Autowired
//	public JSONLoader(DBConn photosInAlbums) {
//		this.photosInAlbums = photosInAlbums;
//	}
//	
//	void run(ApplicationArguments args) throws MalformedURLException {
//		ObjectMapper mapper = new ObjectMapper();
//		URL albumsUri = new URL(ALBUMS_URI);
//		//photosInAlbums = mapper.readValues(albumsUri, albumMap);
//		
//		ObjectMapper mapper2 = new ObjectMapper();
//		URL photosUri = new URL(PHOTOS_URI);
//		//photosInAlbums = mapper.readValue(photosUri, Photo.class);
//		
//	}
	
}
