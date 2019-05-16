FROM oracle/graalvm-ce:1.0.0-rc16 as graalvm
COPY . /home/app/micronaut-graal-app
WORKDIR /home/app/micronaut-graal-app
RUN native-image --no-server -cp build/libs/complete-*.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-graal-app/micronaut-graal-app .
ENTRYPOINT ["./micronaut-graal-app"]
