# Etapa 1: Compilação do código-fonte
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copiar o pom.xml e baixar dependências para cache otimizado
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar o código-fonte e compilar o projeto
COPY src ./src
RUN mvn clean package -DskipTests
RUN ls -l /app/target/

# Etapa 2: Criar a imagem final mais leve
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiar o JAR gerado da etapa de build
COPY --from=builder /app/target/app-0.0.1.jar app.jar

# Expor a porta da aplicação
EXPOSE 8080

# Definir o comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]


# 1. Gerando Imagem Docker:
# docker build -t app_backend .
#
# 2. Executando container em docker:
# docker run --add-host=host.docker.internal:172.17.0.1 --name app_backend -p 8080:8080 -d app_backend 
#
# 3. Testar:
# http://localhost:8080/
