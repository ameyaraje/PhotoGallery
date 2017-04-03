# PhotoAlbumManager Application

A REST based Photo-Album manager application. Developed using Java, SpringBoot and MongoDB.

Performs CRUD operations on Albums and Photos. 


Required - 
- Java 7
- Maven
- MongoDB


To set up the project - 
- git clone https://github.com/ameyaraje/PhotoGallery.git
- cd PhotoGallery
- mvn install


To run the project - 
- Run the WAR file called albummanager
- Start local server, go to localhost:8080/albummanager/init to load all inital data (HTTP POST is needed for this call)


The following are the URIs to perform operations -
1. Photos
	- POST: /photos -> Takes a list of photos as input
	- GET: /photos -> Returns all photos
	- GET: /photos/{photoId} -> Returns photo with that ID
	- PUT: /photos/{photoId} -> Updates photo with that ID
	- DELETE: /photos/{photoId} -> Deletes photo with that ID

2. Albums
	- POST: /albums -> Takes a list of albums as input
	- GET: /albums -> Returns all albums
	- GET: /albums/{albumID} -> Returns all photos in that albumId
	- PUT: /albums/{albumId} -> Updates album with that ID
	- DELETE: /albums/{albumId} -> Deletes album with that ID