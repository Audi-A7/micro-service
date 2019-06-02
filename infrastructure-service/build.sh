#!/usr/bin/env bash
mvn package

docker build -t infrastructure-service:latest .