FROM 13552967920/centos7-jdk8:latest
#FROM openjdk:8
MAINTAINER 13552967920@163.com

COPY ../target/*.jar /opt/app.jar
COPY start.sh /opt/start.sh
COPY hosts /opt/hosts

RUN java -version \
    && ls /opt
    && chmod +x /opt/start.sh

#RUN cat /data/hosts >> /etc/hosts  ##配置host

EXPOSE 12380
ENTRYPOINT /bin/sh -c /opt/start.sh