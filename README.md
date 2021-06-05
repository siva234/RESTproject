# RESTproject
Simple spring boot dockerized REST project

## Prerequisite
- Java 8
- Maven
- Docker

## Running Instructions
- Open command prompt in the project directory.
- Creating the jar file run ``` mvn clean package ```
- Building the docker image run ``` docker build -t restproject . ```
- Running the docker container run ``` docker run -p 5000:8080 restproject ```
- open http://localhost:5000/greeting?account=[value]&id=[value]&type=[value]

## Useful things to know:
- The application can also be run using:
  1. By using ``` mvn spring-boot:run ``` in project directory command prompt.
  2. By using ``` java -jar RESTproject-0.0.1-SNAPSHOT.jar ``` in target folder command prompt.
  when you run this way you use http://localhost:8080/greeting?account=[value]&id=[value]&type=[value] for opening
- If you get compilation errors use ``` SET JAVA_HOME=C:\Program Files\Java\jdk[version number] ``` (if you don't have Java_home set in Environment variables)
