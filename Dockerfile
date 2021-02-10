FROM openjdk:11
WORKDIR /
ADD build/libs/medical-app-0.0.1-SNAPSHOT.jar app.jar
RUN useradd -m myuser
USER myuser
EXPOSE 8080
CMD java -Djava.security.egd=file:/dev/./urandom -jar app.jar -Dspring.profiles.active=docker
