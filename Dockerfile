# 1�ܰ�: Maven�� ����Ͽ� ���ø����̼� ����
FROM maven:3.8.1-jdk-11 AS builder
WORKDIR /usr/local/src

# Maven�� ���� ������ pom.xml�� �����մϴ�.
COPY pom.xml .

# �ʿ��� �������� �ٿ�ε� �޽��ϴ�.
RUN mvn dependency:go-offline

# �ҽ� �ڵ带 �����ϰ� ���ø����̼��� �����մϴ�.
COPY src .
COPY src/main/resources/koyeb.properties .
RUN mvn package

# 2�ܰ�: War ������ Tomcat ������ ����
FROM tomcat:9.0-jdk11-openjdk-slim AS deploy-war
COPY --from=builder ./target/*.war /usr/local/tomcat/webapps/ROOT.war

# 3�ܰ�: Tomcat ���� ����
EXPOSE 8080
CMD ["catalina.sh", "run", "-Dserver.servlet.context-path=/obapi/"]
