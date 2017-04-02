package org.ameya.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.ameya.db.DBUtil;
import org.ameya.db.MongoUtil;
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
	private DBUtil dbUtil = DBUtil.create();
	private MongoUtil mongoUtil = MongoUtil.create();
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Album> getAlbums() {
		return mongoUtil.getAlbums();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{albumId}")
	public Collection<Photo> getPhotos(@PathVariable int albumId){
		return dbUtil.getPhotosInAlbum(albumId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{albumId}")
	public void deleteAlbum(@PathVariable int albumId) {
		dbUtil.removeAlbum(albumId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addAlbum(@RequestBody List<Album> albums) {
		for(Album album : albums){			
			dbUtil.addAlbum(album);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{albumId}")
	public boolean updateAlbum(@RequestBody Album album, @PathVariable int albumId) {
		return dbUtil.updateAlbum(album, albumId);
	}
}
