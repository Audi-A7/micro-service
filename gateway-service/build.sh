#!/usr/bin/env bash
mvn package

docker image rm -f gateway-service
docker build -t gateway-service:latest .