# RESTproject
Simple spring boot dockerized REST project

## Challenge
All the necessary information is contained in this file. 
There are no logical puzzles. The requirement is simple, but it is important to demonstrate clean code and good test coverage.
Do the absolute bare minimum work required for the application. Out of the box, configurations will do just fine.
There is no time limit, but it shouldn’t take more than 60-90min. 

In a basic Dockerized Springboot Maven application, develop a single REST endpoint GET /greeting which behaves in a manner that fulfills the following criteria:

1. Given the following input values account=personal and id=123 
and the allowable values for an account are personal and business
and the allowable values for id are all positive integers
then return "Hi, userId 123".

2. Given the following input values account=business and type=small and 
and the allowable values for an account are personal and business
and the allowable values for type are small and big
then return an error that the path is not yet implemented.

3. Given the following input values account=business and type=big and 
and the allowable values for an account are personal and business
and the allowable values for type are small and big
then return "Welcome, business user!".

We should be able to:
- build the application with Maven
- build the Docker image and run it
- make a request to localhost:5000/greeting and verify the behavior
Please provide an archive with the source code and a list of the terminal commands to build and run the application.

## Prerequisite
- Java 8
- Maven
- Docker

## Running Instructions
- Open command prompt in the project directory.
- Creating the jar file run ``` mvn clean package ```
- Building the docker image run ``` docker build -t restproject . ```
- Running the docker container run ``` docker run -p 5000:8080 restproject ```
- open http://localhost:5000/greeting?account=[value]&account=[value]&type=[value]

## Useful things to know:
- The application can also be run using:
  1. By using ``` mvnw spring-boot:run ``` in project directory command prompt.
  2. By using ``` java -jar RESTproject-0.0.1-SNAPSHOT.jar ``` in target folder command prompt.
  when you run this way you use http://localhost:8080/greeting?account=[value]&account=[value]&type=[value] for opening
- If you get compilation errors use ``` SET JAVA_HOME=C:\Program Files\Java\jdk[version number] ``` (if you don't have Java_home set in Environment variables)
