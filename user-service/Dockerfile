FROM hub.audi.com:1010/micro-service/java:8

MAINTAINER wangquanzhou audi.car@qq.com

ADD target/user-service-1.0-SNAPSHOT.jar /user-service.jar

ENTRYPOINT ["java","-jar","/user-service.jar","--spring.profiles.active=local","--ipAddress=172.16.59.128","--mysqlAddress=172.20.150.108"]



