FROM oracle/graalvm-ce:19.3.1-java8 as graalvm
#FROM oracle/graalvm-ce:19.3.1-java11 as graalvm # For JDK 11
RUN gu install native-image

COPY . /home/app/micronaut-graal-app
WORKDIR /home/app/micronaut-graal-app

RUN native-image --no-server --static -cp build/libs/complete-*-all.jar

FROM scratch
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-graal-app/micronaut-graal-app /micronaut-graal-app/micronaut-graal-app
ENTRYPOINT ["/micronaut-graal-app/micronaut-graal-app"]
