#!/usr/bin/env bash
mvn clean package

docker image rm -f hub.audi.com:1010/micro-service/zuul-service
docker build -t hub.audi.com:1010/micro-service/zuul-service:latest ./zuul-service/
docker push hub.audi.com:1010/micro-service/zuul-service:latest

docker image rm -f hub.audi.com:1010/micro-service/user-service
docker build -t hub.audi.com:1010/micro-service/user-service:latest ./user-service/
docker push hub.audi.com:1010/micro-service/user-service:latest

docker image rm -f hub.audi.com:1010/micro-service/eureka-service
docker build -t hub.audi.com:1010/micro-service/eureka-service:latest ./eureka-service/
docker push hub.audi.com:1010/micro-service/eureka-service:latest

docker image rm -f hub.audi.com:1010/micro-service/infrastructure-service
docker build -t hub.audi.com:1010/micro-service/infrastructure-service:latest ./infrastructure-service/
docker push hub.audi.com:1010/micro-service/infrastructure-service:latest