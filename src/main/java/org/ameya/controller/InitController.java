package org.ameya.controller;

import java.io.IOException;

import org.ameya.db.DBUtil;
import org.ameya.loader.DataLoader;
import org.ameya.model.Album;
import org.ameya.model.Photo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/init")
public class InitController {
	
	private DBUtil databaseUtil = DBUtil.create();

	private static final String ALBUMS_URI = "https://jsonplaceholder.typicode.com/albums";
	private static final String PHOTOS_URI = "https://jsonplaceholder.typicode.com/photos";
	DataLoader dataLoader = new DataLoader();
	
	@RequestMapping(method = RequestMethod.POST)
	public void initialize() throws IOException {
		Album[] albums = dataLoader.readUri(ALBUMS_URI, Album[].class);
		Photo[] photos = dataLoader.readUri(PHOTOS_URI, Photo[].class);
		databaseUtil.addAlbum(albums);
		databaseUtil.addPhoto(photos);
	}
}
