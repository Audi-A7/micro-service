FROM hub.audi.com:1010/micro-service/java:8

MAINTAINER wangquanzhou audi.car@qq.com

ADD target/gateway-service-1.0-SNAPSHOT.jar /gateway-service.jar

ENTRYPOINT ["java","-jar","/gateway-service.jar","--spring.profiles.active=local","--ipAddress=192.168.199.219"]
