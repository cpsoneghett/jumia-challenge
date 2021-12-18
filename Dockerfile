FROM tomcat:8.5.73-jdk11-corretto
ENV SAMPLE_DB_DATASOURCE=jdbc:sqlite:webapps/sample.db
COPY target/*.war /usr/local/tomcat/webapps/jumia-app.war
COPY src/main/resources/db/sample.db /usr/local/tomcat/webapps/sample.db
CMD ["catalina.sh","run"]