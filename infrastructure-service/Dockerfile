FROM hub.audi.com:1010/micro-service/java:8

MAINTAINER wangquanzhou audi.car@qq.com

ADD target/infrastructure-service-1.0-SNAPSHOT.jar /infrastructure-service.jar

ENTRYPOINT ["java","-jar","/infrastructure-service.jar","--spring.profiles.active=local","--ipAddress=172.16.59.132"]



