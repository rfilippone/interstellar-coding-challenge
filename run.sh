#!/usr/bin/env bash

./gradlew assemble || exit 1
docker build -t java_gdal -f Docker/Dockerfile Docker/ || exit 2
docker run -v `pwd`/data:/data -v `pwd`/build/libs:/libs -p 8080:8080 java_gdal java -jar libs/coding-challenge-0.0.1-SNAPSHOT.jar || exit 3

