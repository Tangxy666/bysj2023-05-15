FROM openjdk:jdk-oraclelinux8
MAINTAINER Equent
ENV JAVA_OPTS="-Dspring.output.ansi.enabled=always -XX:+UseG1GC -Xms512m -Xmx1024m -XX:SurvivorRatio=8"
# 服务启动配置
# 服务名称
ENV SERVICE_NAME="soccerPro-server"
# 服务版本
ENV SERVICE_VERSION="1.0.0-SNAPSHOT"
COPY target/soccerPro-0.0.1-SNAPSHOT.jar /deployments/app.jar
# 服务暴露端口
EXPOSE 8088
WORKDIR /deployments
CMD [ "sh", "-c", "java ${JAVA_OPTS} -jar /deployments/app.jar" ]