FROM hub.audi.com:1010/micro-service/java:8

MAINTAINER wangquanzhou audi.car@qq.com

ADD target/eureka-service-1.0-SNAPSHOT.jar /eureka-service.jar

ENTRYPOINT ["java","-jar","/eureka-service.jar","--spring.profiles.active=local","--ipAddress=172.16.59.128","--HOST_NAME=eurekaService"]



