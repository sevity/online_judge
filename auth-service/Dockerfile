# 첫 번째 단계: Maven Wrapper를 사용하여 어플리케이션 빌드
# 아래 AS build부분은 docker build명령을 실행하면 진행됨
# FROM base_image형태이며 여기서는 java를 포함한 debian기반 운영체제의 이미지를 베이스로 해서 추가설정을 한다는 의미
FROM eclipse-temurin:17-jdk-jammy AS build
# 도커이미지내 작업디렉토리를 /workspace/app으로 설정.  이는 후속 RUN, CMD, ENTROYPOINT, COPY, ADD명령의 실행경로가 됨
WORKDIR /workspace/app

# maven, spring 관련 파일들을 도커로 복사
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# maven으로 스프링부트프로젝트 빌드(도커아니어도 하는거)
RUN ./mvnw install -DskipTests
# 필요한디렉토리를 만들고 빌드된 jar 압축해재. 필수는 아니고 최적화전략의 일환
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# 멀티스테이지 전략의 두 번째 단계
# jdk가 아닌 jre만 포함하는 가벼운 이미지로 전환
# 이렇게 하면 최종 이미지는 jre기준으로 되어 크기를 줄일수 있음.
FROM eclipse-temurin:17-jre-jammy  
VOLUME /tmp  # 일종의 nas설정처럼 컨테이너간 또는 컨테이너와 호스트간 데이터 공유공간을 만드는것
ARG DEPENDENCY=/workspace/app/target/dependency
# 첫번째 빌드단계에서 생성된 파일들을 새 이미지로 복사. 
# 멀티스테이지 구성의 경우 첫번째 이미지는 소멸되기 때문에 아래와 같은 복사과정이 필요.
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# 아래 부분은 docker run명령을 사용하면 진행됨(아래 ENTRYPOINT부분. 또는 CMD도 가능)
ENTRYPOINT ["java","-cp","app:app/lib/*","com.sevity.authservice.AuthServiceApplication"]
