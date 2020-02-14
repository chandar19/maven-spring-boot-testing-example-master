FROM tomcat:9.0.31-jdk8-openjdk

ENV WEBAPPS_HOME /usr/local/tomcat/webapps
ENV PROJECT_HOME /usr/local/tomcat


COPY target/maven-spring-boot-testing-example.war $WEBAPPS_HOME/maven-spring-boot-testing-example.war

WORKDIR $PROJECT_HOME

CMD ["sh", "bin/catalina.sh", "run"]
