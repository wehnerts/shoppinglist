FROM openjdk:17

ENV ENVIRONMENT=prod

ADD backend/target/shoppinglist.jar shoppinglist.jar

EXPOSE 8080

CMD [ "sh", "-c", "java -Dserver.port=$PORT -jar /shoppinglist.jar" ]

