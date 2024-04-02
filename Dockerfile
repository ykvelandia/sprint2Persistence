# Utiliza una imagen base con OpenJDK 17 y Gradle 7.4.0
FROM gradle:7.5 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos de tu proyecto al directorio de trabajo
COPY . .

# Construye tu aplicación con Gradle
RUN gradle build --no-daemon

# Cambia a una imagen más ligera de OpenJDK 17 para la ejecución
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR de tu aplicación al directorio de trabajo
COPY --from=build /app/build/libs/bookings-0.0.1-SNAPSHOT.jar .
COPY --from=build /app/src/main/resources/application.properties .

# Exponer el puerto que utilizará la aplicación
EXPOSE 8082

# Define el comando de inicio de la aplicación
CMD ["java", "-jar", "bookings-0.0.1-SNAPSHOT.jar"]