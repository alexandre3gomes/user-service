FROM openjdk:14-alpine
ENV WAIT_VERSION 2.7.2
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/$WAIT_VERSION/wait /app/wait
ADD build/libs/*.jar /app/app.jar
ADD devops-utils/init.sh /app/init.sh
ADD devops-utils/cert/keystore.p12 /app
RUN chmod +x /app/wait
RUN chmod +x /app/init.sh
EXPOSE 8081
ENTRYPOINT ["./app/init.sh"]