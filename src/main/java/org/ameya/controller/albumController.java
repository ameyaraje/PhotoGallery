package org.ameya.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.ameya.db.DBConnection;
import org.ameya.model.Album;
import org.ameya.model.Photo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/albums")
public class AlbumController {
	private DBConnection dbConnection = DBConnection.create();

	public AlbumController() {
		init();
	}

	private void init() {
		dbConnection.addAlbum(new Album("album1", 1));
		dbConnection.addAlbum(new Album("album2", 78));
		ArrayList<Photo> photos = new ArrayList<>();
		Photo photo = new Photo(1, "photoTitle", "url", 1);
		photos.add(photo );
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public HashMap<Integer, Album> getAlbums() {
		return dbConnection.getAlbums();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{albumId}")
	public Collection<Photo> getPhotos(@PathVariable int albumId){
		return dbConnection.getPhotosInAlbum(albumId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{albumId}")
	public boolean deleteAlbum(@PathVariable int albumId) {
		return dbConnection.removeAlbum(albumId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addAlbum(@RequestBody List<Album> albums) {
		for(Album album : albums){			
			dbConnection.addAlbum(album);
		}
	}
}
