#!/usr/bin/env bash
mvn package

docker build -t zuul-service:latest .