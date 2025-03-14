#IMAGEN MODELO
FROM eclipse-temurin:17.0.14_7-jdk

#DIRECTORIO RAIZ DE NUESTRO CONTENEDOR
#ES UNA CARPETA DENTRO DEL CONTENEDOR
WORKDIR /root

#COPIAR Y PEGAR ARCHIVOS DENTRO DEL CONTENEDOR
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

#DESCARGAR DEPENDENCIAS
RUN ./mvnw dependency:go-offline

#COPIAR EL CODIGO FUENTE EN LA CARPETA "src"
COPY ./src /root/src

#NO EJECUTAR TEST CON EL COMANDO -DskipTests
RUN ./mvnw clean install -DskipTests

#CORRER LA APLICACIÖN
ENTRYPOINT ["java", "-jar", "/root/target/prueba-backend-cicd-0.0.1-SNAPSHOT.jar"]
