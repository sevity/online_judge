#!/bin/bash

# Load environment variables from .env file
export $(cat .env | xargs)

# Run Spring Boot application
mvn spring-boot:run

