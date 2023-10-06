#!/bin/bash

PORT=$1
trap 'docker stop problem-frontend' EXIT
docker run --rm\
  --name problem-frontend\
  --network host \
  -p $PORT:$PORT \
  -e PORT=$PORT \
  problem-frontend

