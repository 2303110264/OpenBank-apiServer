# 1단계: Maven을 사용하여 애플리케이션 빌드
FROM maven:3.8.1-jdk-11 AS builder
WORKDIR /usr/local/src

# Maven의 설정 파일인 pom.xml을 복사합니다.
COPY pom.xml .

# 필요한 의존성을 다운로드 받습니다.
RUN mvn dependency:go-offline

# 소스 코드를 복사하고 애플리케이션을 빌드합니다.
COPY src .
COPY src/main/resources/koyeb.properties .
RUN mvn package

# 2단계: War 파일을 Tomcat 서버에 배포
FROM tomcat:9.0-jdk11-openjdk-slim AS deploy-war
COPY --from=builder ./target/*.war /usr/local/tomcat/webapps/ROOT.war

# 3단계: Tomcat 서버 실행
EXPOSE 8080
CMD ["catalina.sh", "run", "-Dserver.servlet.context-path=/obapi/"]
