#!/bin/bash
docker container stop dev-agileboard-backend
docker container stop dev-agileboard-db
docker network rm dev-agileboard
