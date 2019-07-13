#!/bin/bash
ng build
FRONTEND_IMAGE_TAG=agileboard-frontend:ng
docker image rm -f $FRONTEND_IMAGE_TAG
docker image build -t $FRONTEND_IMAGE_TAG .
