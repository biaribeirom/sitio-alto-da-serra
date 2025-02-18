FROM eclipse-temurin:21-jdk-jammy as build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN --mount=type=cache,target=/root/.m2 ./mvnw -f $HOME/pom.xml clean package

#
# Package stage
#
FROM eclipse-temurin:21-jre-jammy
ARG JAR_FILE=/usr/app/target/*.jar
COPY --from=build $JAR_FILE /app/runner.jar
EXPOSE 8000
WORKDIR /app
# copy db in
COPY --from=build /usr/app/data/projeto.mv.db /app/data/projeto.mv.db
ENTRYPOINT java -jar ./runner.jar