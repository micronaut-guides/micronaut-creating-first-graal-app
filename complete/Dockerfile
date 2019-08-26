FROM oracle/graalvm-ce:19.2.0 as graalvm
COPY . /home/app/micronaut-graal-app
WORKDIR /home/app/micronaut-graal-app
RUN gu install native-image
RUN native-image --no-server -cp build/libs/complete-*-all.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-graal-app .
ENTRYPOINT ["./micronaut-graal-app"]
