#!/usr/bin/env bash
mvn clean package

docker image rm -f zuul-service
docker build -t zuul-service:latest ./zuul-service/

docker image rm -f user-service
docker build -t user-service:latest ./user-service/

docker image rm -f eureka-service
docker build -t eureka-service:latest ./eureka-service/

docker image rm -f infrastructure-service
docker build -t infrastructure-service:latest ./infrastructure-service/