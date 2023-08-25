FROM gradle:8.3.0-jdk11-alpine

WORKDIR /tests
COPY . /tests

CMD gradle test