#!/bin/bash
FRONTEND=dev-agileboard-frontend
docker container run --rm --name $FRONTEND \
  --detach --publish 88:80 \
  --volume $(pwd)/dist/agile-board-ui:/usr/share/nginx/html \
  agileboard-frontend:ng
