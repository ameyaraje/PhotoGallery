package org.ameya.Loader;

import org.ameya.db.*;
import org.springframework.stereotype.Component;

@Component
public class JSONLoader {
	private DBConn photosInAlbums;
	private DBConn albumMap;
	
	private static final String ALBUMS_URI = "https://jsonplaceholder.typicode.com/albums";
	private static final String PHOTOS_URI = "https://jsonplaceholder.typicode.com/photos";
	
	
	
}
