## 📦 Docker Setup & Usage for Spring Boot App

### 1️⃣ What is Docker?

Docker is a platform that lets you package your application and all its dependencies into a **single portable unit** called a **container**.

* Runs the same way on any machine (no “works on my machine” issues).
* Lightweight compared to virtual machines.
* Perfect for deploying Java/Spring Boot applications.

---

### 2️⃣ Prerequisites

* **Install Docker Desktop** ([Download here](https://www.docker.com/products/docker-desktop))
* Verify installation:

```bash
docker --version
```

---

### 3️⃣ Building the Spring Boot JAR

Before creating a Docker image, compile and package the Spring Boot application:

```bash
mvn clean package
```

This creates a `.jar` file inside the `target/` folder.

---

### 4️⃣ Writing the Dockerfile

```dockerfile
FROM eclipse-temurin:17
# Base image → Java 17 JDK from Eclipse Temurin

LABEL maintainer="mail_id"
# Metadata about the image (maintainer info)

WORKDIR /app
# Working directory inside the container

COPY target/springboot-docker-1-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo.jar
# Copy JAR file from local target folder into /app in container

ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]
# Command to run when the container starts
```

---

### 5️⃣ Building the Docker Image

```bash
docker build -t springboot-docker-app .
```

* `-t` → tag (name) for the image
* `.` → build context (current folder)

Check images:

```bash
docker images
```

---

### 6️⃣ Running the Container

#### Run in foreground (interactive):

```bash
docker run -p 8080:8080 springboot-docker-app
```

* Maps **host port 8080** → **container port 8080**

#### Run in detached mode:

```bash
docker run -d -p 8080:8080 springboot-docker-app
```

* `-d` → detached mode (runs in background)

---

### 7️⃣ Tagging for Docker Hub

Tag image for your Docker Hub account:

```bash
docker tag springboot-docker-app keerthan173/springboot-docker-app:latest
```

---

### 8️⃣ Logging in to Docker Hub

```bash
docker login
```

If already logged in, Docker will use saved credentials.

---

### 9️⃣ Pushing Image to Docker Hub

```bash
docker push keerthan173/springboot-docker-app:latest
```

---

### 🔟 Pulling Image from Docker Hub

On any machine:

```bash
docker pull keerthan173/springboot-docker-app:latest
docker run -p 8080:8080 keerthan173/springboot-docker-app:latest
```

---

### 🛠 Useful Commands

| Command                      | Description                             |
| ---------------------------- | --------------------------------------- |
| `docker ps`                  | List running containers                 |
| `docker ps -a`               | List all containers (including stopped) |
| `docker stop <container_id>` | Stop a running container                |
| `docker rm <container_id>`   | Remove a container                      |
| `docker rmi <image_id>`      | Remove an image                         |
| `docker logs <container_id>` | Show container logs                     |

---

### 📌 Summary Flow

1. **Build JAR** → `mvn clean package`
2. **Write Dockerfile**
3. **Build image** → `docker build -t app_name .`
4. **Run locally** → `docker run -p 8080:8080 app_name`
5. **Tag for Docker Hub** → `docker tag ...`
6. **Push to Docker Hub** → `docker push ...`
7. **Pull anywhere** → `docker pull ...` and run

---
