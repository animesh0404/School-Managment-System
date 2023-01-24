FROM eclipse-temurin:17-jre-alpine
COPY target/school-management-system.jar school-management-system.jar
ENTRYPOINT ["java","-jar","school-management-system.jar"]

EXPOSE 8080 5432

ENV POSTGRES_HOST=localhost
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=root
ENV POSTGRES_DB=sms