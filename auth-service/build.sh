#!/bin/bash

# Load environment variables from .env file
export $(cat .env | xargs)

./mvnw clean package

