#!/usr/bin/env bash
mvn package

docker image rm -f eureka-service
docker build -t eureka-service:latest .