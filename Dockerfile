# ESTÁGIO 1: Build (A "Obra")
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia apenas o pom.xml para baixar as dependências (otimiza o cache do Docker)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código fonte e compila o projeto gerando o .jar
COPY src ./src
RUN mvn clean package -DskipTests

# ESTÁGIO 2: Run (A "Casa Pronta")
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia apenas o arquivo .jar que foi gerado no estágio anterior
COPY --from=build /app/target/*.jar app.jar

# Define o comando para rodar a aplicação
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]