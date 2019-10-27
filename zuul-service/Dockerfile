FROM hub.audi.com:1010/micro-service/java:8

MAINTAINER wangquanzhou audi.car@qq.com

ADD target/zuul-service-1.0-SNAPSHOT.jar /zuul-service.jar

ENTRYPOINT ["java","-jar","/zuul-service.jar","--spring.profiles.active=local","--ipAddress=172.20.150.108"]
