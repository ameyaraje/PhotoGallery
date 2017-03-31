package org.ameya.controller;

import org.ameya.model.*;
import org.ameya.db.*;
import java.util.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/photos")
public class PhotoController {

	private static HashMap<Integer, ArrayList<Photo>> photosInAlbum = DBConn.getPhotosInAlbums();
	private static HashMap<Integer, Album> albums = DBConn.getAlbums();

	@RequestMapping(method = RequestMethod.GET, value = "/{photoId}")
	public static Photo getPhoto(@PathVariable Long photoId) {
		for (ArrayList<Photo> p: photosInAlbum.values()) {
			for (Photo ph: p) {
				if (ph.getAlbumId() == photoId)
					return ph;
			}
		}
		System.out.println("Photo does not exist in database");
		return null;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{photoId}")
	public static void removePhoto(@PathVariable Long photoId) {
		for (ArrayList<Photo> p: photosInAlbum.values()) {
			for (Photo ph: p) {
				if (ph.getAlbumId() == photoId)
					p.remove(ph);
			}
		}
		System.out.println("Removed photo from the database");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addPhoto")
	public static void addPhoto(@RequestBody Photo photo) {
		
		//int code = photos.get(photo.getAlbumId()).size()+1;
		if(photosInAlbum.containsKey(photo.getAlbumId())){
			photosInAlbum.get(photo.getAlbumId()).add(photo);			
		} else{
			ArrayList<Photo> newAlbum =  new ArrayList<>();
			newAlbum.add(photo);
			photosInAlbum.put(photo.getAlbumId(), newAlbum);
		}
		
	}
}
