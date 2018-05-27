FROM openjdk:8-jre-slim

COPY . /app/

WORKDIR /app

RUN chmod +x beat.sh

ENTRYPOINT ["/app/beat.sh"]