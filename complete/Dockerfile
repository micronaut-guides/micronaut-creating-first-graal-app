FROM oracle/graalvm-ce:20.1.0-java8 as graalvm
#FROM oracle/graalvm-ce:20.1.0-java11 as graalvm # For JDK 11
RUN gu install native-image

COPY . /home/app/micronaut-graal-app
WORKDIR /home/app/micronaut-graal-app

RUN native-image --no-server -cp build/libs/complete-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-graal-app/micronaut-graal-app /app/micronaut-graal-app
ENTRYPOINT ["/app/micronaut-graal-app"]
