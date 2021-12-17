FROM maven:3.6.3 AS maven
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn clean package


FROM tomcat:8.5.73-jdk11-corretto
ENV SAMPLE_DB_DATASOURCE=jdbc:sqlite:webapps/sample.db
COPY --from=maven /usr/src/app/src/main/resources/db/sample.db /usr/local/tomcat/webapps/sample.db
COPY --from=maven /usr/src/app/target/*.war /usr/local/tomcat/webapps/jumia-app.war
CMD ["catalina.sh","run"]

