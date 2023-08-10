#!/bin/bash

PORT=$1

docker run \
  --network host \
  -p $PORT:$PORT \
  -e PORT=$PORT \
  frontend-service

