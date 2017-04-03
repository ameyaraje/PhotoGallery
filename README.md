# PhotoAlbumManager Application

A REST based Photo-Album manager application. Developed using Java, SpringBoot and MongoDB.

Performs CRUD operations on Albums and Photos. 


Required - 
- Java 7
- Maven
- MongoDB


To set up the project -  
```git clone https://github.com/ameyaraje/PhotoGallery.git```  
```cd PhotoGallery```  
```mvn install```  
- Deploy the WAR file called 'albummanager.war' in your server


The following are the URIs to perform operations -
1. Initialization
	- POST: /init -> Initializes the database with values from the URL (https://jsonplaceholder.typicode.com/albums  and   https://jsonplaceholder.typicode.com/photos)

2. Photos
	- POST: /photos -> Takes a list of photos as input
	- GET: /photos -> Returns all photos
	- GET: /photos/{photoId} -> Returns photo with that ID
	- PUT: /photos/{photoId} -> Updates photo with that ID
	- DELETE: /photos/{photoId} -> Deletes photo with that ID

3. Albums
	- POST: /albums -> Takes a list of albums as input
	- GET: /albums -> Returns all albums
	- GET: /albums/{albumId} -> Returns all photos in that albumId
	- PUT: /albums/{albumId} -> Updates album with that ID
	- DELETE: /albums/{albumId} -> Deletes album with that ID