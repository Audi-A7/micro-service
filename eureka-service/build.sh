#!/usr/bin/env bash
mvn package

docker build -t eureka-service:latest .