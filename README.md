This Project is based on Java Swings and MySQL, with the use of OMDB API.
this includes 8 classes, the program begins from splash.java class, 
it then goes into Login.java, if the user is new we have a signup option which is handeld by SignUp.java class
after login, the user is prompted to Project.java class the user can search a movie, the results are displayed, 
the user also has an option to add it to his MovieList.

total classes
() Splash
() Conn    #establishes connection with database
() Login
() SignUp
() Project
() API  #retrieves data from OMDB
() Display
() Movies


Database Tables

() UserDetails ( id,name,username,password)
() Movies (id,title,year)

Queries used
() create database fasal
() use fasal
() create table UserDetails (id int NOT NULL, AUTO_INCREMENT,name varchar(35),username varchar(35),password varchar(35))
() create table Movies(id int,title varchar(35),year varchar(4))

Use java jdbc Driver to establish connection to application
