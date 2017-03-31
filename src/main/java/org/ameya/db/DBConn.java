package org.ameya.db;

import java.util.*;
import org.ameya.model.*;

public class DBConn {

	private static HashMap<Integer, ArrayList<Photo>> photosInAlbum = new HashMap<>();
	private static HashMap<Integer, Album> albumMap = new HashMap<>();

	public static HashMap<Integer, ArrayList<Photo>> getPhotosInAlbums() {
		return photosInAlbum;
	} 
	
	public static HashMap<Integer, Album> getAlbums() {
		return albumMap;
	}
	
	

}
