mvn clean package

rm /usr/local/tomcat/webapps/test.war

cp target/albummanager-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/test.war