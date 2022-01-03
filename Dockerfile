FROM tomcat:8.5.73-jdk17-openjdk
COPY /target/Education.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]