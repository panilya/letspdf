FROM openjdk:11
CMD java -classpath src/main/java com.panilya.letspdfserver.LetspdfServerApplication
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080