package org.ameya.controller;

import java.util.Collection;
import java.util.List;

import org.ameya.db.DBUtil;
import org.ameya.db.MongoUtil;
import org.ameya.model.Photo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/photos")
public class PhotoController {

	private DBUtil dbUtil = DBUtil.create();
	private MongoUtil mongoUtil = MongoUtil.create();

	@RequestMapping(method = RequestMethod.GET)
	public List<Photo> getPhotos() {
		return mongoUtil.getAllPhotos();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{photoId}")
	public Photo getPhoto(@PathVariable int photoId) {
		return dbUtil.getPhoto(photoId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{photoId}")
	public void removePhoto(@PathVariable int photoId) {
		dbUtil.removePhoto(photoId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addPhoto(@RequestBody List<Photo> photos) {
		for(Photo photo:photos){
			dbUtil.addPhoto(photo);		
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{photoId}")
	public boolean updatePhoto(@RequestBody Photo photo, @PathVariable int photoId) {
		return dbUtil.updatePhoto(photo, photoId);
	}
}
