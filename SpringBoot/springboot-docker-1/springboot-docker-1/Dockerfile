FROM eclipse-temurin:17
#sets the base image to Eclipse Temurin's Java 17 JDK.

LABEL maintainer="keerthank2005@gmail.com"
#Adds metadata to the image — helpful to document who maintains this image.

WORKDIR /app
#Sets the working directory inside the container to /app.
#If the directory doesn’t exist, Docker creates it.
#Any future commands like COPY, RUN, or CMD will execute inside /app.

COPY target/springboot-docker-1-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo.jar
#Copies the built JAR file from your machine (target/) into the Docker image’s /app/ directory.
#It renames the JAR inside the image to springboot-docker-demo.jar.

ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]
#Defines the default command the container runs when started —
#here, it runs your Spring Boot app using the jar file.