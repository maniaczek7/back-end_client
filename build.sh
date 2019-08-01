#!/bin/bash
# remember to click maven install to create JAR file!
eval $("C:\Program Files\Docker Toolbox\docker-machine.exe" env dev)
docker build -t rmichniewskihome/application:back-end_login .
docker push rmichniewskihome/application:back-end_login
ssh ec2 docker pull rmichniewskihome/application:back-end_login
ssh ec2 docker rm -f back-end_login
ssh ec2 docker run -d --name=back-end_login -p 8082:8082 --rm rmichniewskihome/application:back-end_login
ssh ec2 docker ps
