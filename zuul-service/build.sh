#!/usr/bin/env bash
mvn package

docker image rm -f zuul-service
docker build -t zuul-service:latest .