# CRUD-API

form-frontend and form-backend connected each other.

build form-frontend
- Open terminal and go form-frontend folder
- $npm install
- $npm run serve

build form-backend 
- Open terminal and go form-backend folder
- $mvn install (this command creates executable jar file)
- Go to the directory where the jar file is 
- $java [ -Dserver.port=8081 ] -jar restApp2-0.0.1-SNAPSHOT.jar  
- [-Dserver.port=8081 ] is optional 
