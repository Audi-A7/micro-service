#!/usr/bin/env bash
mvn package

docker image rm -f user-service
docker build -t user-service:latest .