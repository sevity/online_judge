#!/bin/bash

PORT=$1
trap 'docker stop frontend-service' EXIT
docker run --rm\
  --name frontend-service\
  --network host \
  -p $PORT:$PORT \
  -e PORT=$PORT \
  frontend-service

