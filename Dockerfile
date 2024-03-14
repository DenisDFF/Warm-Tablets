FROM gradle as builder
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src
RUN gradle build

FROM eclipse-temurin
EXPOSE 8080
COPY --from=builder /home/gradle/src/build/libs/demo-0.0.1-SNAPSHOT.jar /opt/
COPY files/start.sh /opt/
RUN ["chmod", "755", "/opt/start.sh"]
CMD /opt/start.sh
