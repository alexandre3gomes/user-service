FROM openjdk:14-alpine
ENV WAIT_VERSION 2.7.2
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/$WAIT_VERSION/wait /app/wait
ADD devops-utils/init.sh /app/init.sh
RUN chmod +x /app/wait
RUN chmod +x /app/init.sh
EXPOSE 8081
ADD build/libs/*.jar /app/app.jar
ENTRYPOINT ["./app/init.sh"]