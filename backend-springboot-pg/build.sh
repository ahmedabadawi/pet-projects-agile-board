#!/bin/bash
mvn clean package
BACKEND_IMAGE_TAG=agileboard-backend:springboot
docker image rm -f $BACKEND_IMAGE_TAG
docker image build -t $BACKEND_IMAGE_TAG .
