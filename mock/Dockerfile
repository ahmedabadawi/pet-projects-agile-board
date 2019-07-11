FROM openjdk:8-jre-alpine

ENV WIREMOCK_VERSION 2.23.2

RUN mkdir -p /var/wiremock \
  && wget http://repo1.maven.org/maven2/com/github/tomakehurst/wiremock-standalone/$WIREMOCK_VERSION/wiremock-standalone-$WIREMOCK_VERSION.jar \
  -O /var/wiremock/wiremock.jar

WORKDIR /home/wiremock

VOLUME /home/wiremock/mappings

EXPOSE 8080 8443

CMD java -jar /var/wiremock/wiremock.jar
