package org.ameya.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.ameya.db.DBConnection;
import org.ameya.model.Album;
import org.ameya.model.Photo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/albums")
public class AlbumController {
	private DBConnection dbConnection = DBConnection.create();

	public AlbumController() {
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
	public List<Photo> getPhotos(@PathVariable Long albumId){
//		if (photosInAlbum.containsKey(albumId))
//			return photosInAlbum.get(albumId);
//		else 
//			throw new Exception("Album with id  not found");
		return null;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{albumId}")
	public void deleteAlbum(@PathVariable Long albumId) {
//		if (photosInAlbum.get(albumId).size() > 0) {
//			System.out.println("Cannot delete album since it has photos in it");
//		}
//		else {
//			photosInAlbum.remove(photosInAlbum.get(albumId));
//			System.out.println("Successfully deleted album from database");
//		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addAlbum")
	public static void addAlbum(Album album) {
//		int code = photosInAlbum.size()+1;
//		photosInAlbum.put(code, new ArrayList<Photo>());
//		albums.put(code, album);
	}
}
