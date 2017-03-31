package org.ameya.controller;

import org.ameya.model.*;
import org.ameya.db.*;
import java.util.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/albums")
public class albumController {
	
	
	private static HashMap<Integer, ArrayList<Photo>> photosInAlbum = DBConn.getPhotosInAlbums();
	private static HashMap<Integer, Album> albums = DBConn.getAlbums();

	
	@RequestMapping(method = RequestMethod.GET)
	public HashMap<Integer, ArrayList<Photo>> getAlbums() {
		return photosInAlbum;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{albumId}")
	public List<Photo> getPhotos(@PathVariable Long albumId) {
		return photosInAlbum.get(albumId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{albumId}")
	public void deleteAlbum(@PathVariable Long albumId) {
		if (photosInAlbum.get(albumId).size() > 0) {
			System.out.println("Cannot delete album since it has photos in it");
		}
		else {
			photosInAlbum.remove(photosInAlbum.get(albumId));
			System.out.println("Successfully deleted album from database");
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addAlbum")
	public static void addAlbum(Album album) {
		int code = photosInAlbum.size()+1;
		photosInAlbum.put(code, new ArrayList<Photo>());
		albums.put(code, album);
	}
	
}
