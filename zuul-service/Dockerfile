FROM registry.cn-shanghai.aliyuncs.com/audi_micro_service/micro-service/java:8

MAINTAINER wangquanzhou audi.car@qq.com

ADD target/zuul-service-1.0-SNAPSHOT.jar /zuul-service.jar

ENTRYPOINT ["java","-jar","/zuul-service.jar","--spring.profiles.active=local","--ipAddress=39.101.191.157"]
