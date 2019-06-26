#!/bin/bash
docker run --rm --name postgres -e POSTGRES_PASSWORD=Password123 -d -p 5432:5432 postgres
