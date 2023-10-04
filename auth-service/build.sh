#!/bin/bash

# Java 17 환경 변수 설정
# 아래 명령등으로 인해서 하나의 서버에서 여러 버전의 java가 운용될 경우 maven안의 java버전 설정과 충돌이 나는 경우가 발견되었다.
# sudo update-alternatives --config java
# 그래서 아래 환경 변수를 추가함
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH

# Load environment variables from .env file
export $(cat .env | xargs)

./mvnw clean package

