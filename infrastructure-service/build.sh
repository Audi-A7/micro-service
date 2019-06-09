#!/usr/bin/env bash
mvn package

docker image rm -f infrastructure-service
docker build -t infrastructure-service:latest .