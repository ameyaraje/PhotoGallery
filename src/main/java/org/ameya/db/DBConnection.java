package org.ameya.db;

import java.util.*;
import org.ameya.model.*;

public class DBConnection {

	private HashMap<Integer, ArrayList<Photo>> photosInAlbum = new HashMap<>();
	private HashMap<Integer, Album> albumMap = new HashMap<>();
	private static DBConnection dbConnection;
	
	private DBConnection(){
		
	}
	
	public HashMap<Integer, ArrayList<Photo>> getPhotosInAlbums() {
		return photosInAlbum;
	} 
	
	public HashMap<Integer, Album> getAlbums() {
		return albumMap;
	}
	
	public static DBConnection create(){
		if(dbConnection == null){
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}

	public void addAlbum(Album album) {
		
		
	}
}
