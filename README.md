# Sample Reverse String Spring-Boot App with API's

## Built with
* Gradle
* SpringBoot
* Java8

* Can run the App in any IDE like IntelliJ OR by using `./gradlew bootRun` at root of the project.

## Gradle Commands to use from root of the project
* Build Project : `./gradlew clean build`
* Run the jar to launch App with `java -jar  build/libs/reverse-0.0.1-SNAPSHOT.jar`

### Docker Image Creation steps from root of the project. There are two ways we can create images. Use any one of them. 
1. Build without `Dockerfile`. Requires Docker Daemon should be running on System
    * Run `./gradlew clean build`
    * Run `./gradlew jibDockerBuild --image=latest/reverse-0.0.1` to create the image.
    * Run the Image with `docker run -p 8080:8080 -t latest/reverse-0.0.1`

2. Build with `Dockerfile`. Requires Docker Daemon should be running on System
    * Run `./gradlew clean build`
    * Run `docker build -t latest/reverse-0.0.2 .`
    * Run the Image with `docker run -p 8080:8080 -t latest/reverse-0.0.2`



## Test API
* curl -X GET --header 'Accept: application/json' 'http://localhost:8080/reverse?value=jkdfhkjdhasdjkfhsdjkfhsdjkfhkasdjlf'




