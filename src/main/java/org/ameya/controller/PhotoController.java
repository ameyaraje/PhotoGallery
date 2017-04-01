package org.ameya.controller;

import java.util.List;

import org.ameya.db.DBConnection;
import org.ameya.model.Photo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/photos")
public class PhotoController {

	private DBConnection dbConnection = DBConnection.create();

	@RequestMapping(method = RequestMethod.GET, value = "/{photoId}")
	public Photo getPhoto(@PathVariable int photoId) {
		return dbConnection.getPhoto(photoId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{photoId}")
	public boolean removePhoto(@PathVariable int photoId) {
		return dbConnection.removePhoto(photoId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addPhoto(@RequestBody List<Photo> photos) {
		for(Photo photo:photos){
			dbConnection.addPhoto(photo);		
		}
	}
}
