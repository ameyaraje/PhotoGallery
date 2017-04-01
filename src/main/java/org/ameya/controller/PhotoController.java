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

	private DBConnection dbConnection = DBConnection.create();

	@RequestMapping(method = RequestMethod.GET, value = "/{photoId}")
	public Photo getPhoto(@PathVariable Long photoId) {
		return dbConnection.getPhoto(photoId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{photoId}")
	public void removePhoto(@PathVariable Long photoId) {
		dbConnection.removePhoto(photoId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addPhoto")
	public void addPhoto(@RequestBody Photo photo) {
		dbConnection.addPhoto(photo);		
	}
}
