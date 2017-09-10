#!/usr/bin/env bash
mvn clean install
docker build -t spring-mvc-example:latest .
#docker push rameshr/alpine-tomcat8:latest
