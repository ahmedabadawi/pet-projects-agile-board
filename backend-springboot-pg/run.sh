#!/bin/bash
NETWORK_NAME=dev-agileboard
DB_NAME=dev-agileboard
DB_PASSWORD=Password123
DB=dev-agileboard-db
BACKEND=dev-agileboard-backend
docker network create $NETWORK_NAME
docker container run --rm --name $DB \
  -e POSTGRES_PASSWORD=Password123 --detach --publish 5432:5432 \
  --network $NETWORK_NAME \
  postgres

# Create database
sleep 2s
docker container exec $DB sh -c "echo 'localhost:5432:postgres:postgres:$DB_PASSWORD' > ~/.pgpass && chmod 0600 ~/.pgpass && createdb --username postgres --no-password $DB_NAME"

docker container run --rm --name $BACKEND \
  --detach --publish 8080:8080 \
  --network $NETWORK_NAME \
  agileboard-backend:springboot
