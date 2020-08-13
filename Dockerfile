FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPS=${ADDITIONAL_OPS}

WORKDIR /opt/spring_boot

COPY /target/api-rest*.jar api_rest.jar

SHELL ["/bin/sh","-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar api_rest.jar --spring.profiles.active=${PROFILE}
