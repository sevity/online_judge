#!/bin/bash

PORT=$1

docker run -e SPRING_APPLICATION_JSON='{"server":{"port":'"$PORT"'}}' -p $PORT:$PORT -e DATABASE_URL=jdbc:postgresql://192.168.0.20:5432/online_judge -e DATABASE_USERNAME=online_judge_admin -e DATABASE_PASSWORD=abcd123$ auth-service



