# student-spring-boot

Notes:
user data -> interacts with controller or API -> interacts with service -> service implements from -> Interface 

docker-compose up -d

docker ps

docker exec -it postgres bash

then psql -U amigoscode

\l - to list all db


CREATE DATABASE student;

\c student


INSERT INTO student(id,name,email,age)
VALUES (nextval('student_id_sequence'),'Nikhil','nikhil@gmail.com',22);

In POSTMAN
localhost:8080/api/v1/student - GET
