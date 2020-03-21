FROM registry.cn-shanghai.aliyuncs.com/audi_micro_service/micro-service/java:8

MAINTAINER wangquanzhou audi.car@qq.com

ADD target/gateway-service-1.0-SNAPSHOT.jar /gateway-service.jar

ENTRYPOINT ["java","-jar","/gateway-service.jar","--spring.profiles.active=local","--ipAddress=39.101.191.157"]
