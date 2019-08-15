#!/bin/bash
# remember to click maven/gradle install to create JAR file!
./gradlew clean build
eval $("C:\Program Files\Docker Toolbox\docker-machine.exe" env dev)
docker build -t rmichniewskihome/back-end_login:latest .
docker push rmichniewskihome/back-end_login:latest
ssh ec2 docker pull rmichniewskihome/back-end_login:latest
ssh ec2 docker rm -f back-end_login:latest
ssh ec2 docker run -d --name=back-end_login -p 8082:8082 --rm rmichniewskihome/back-end_login:latest
ssh ec2 docker ps
