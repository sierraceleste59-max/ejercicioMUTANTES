# Proyecto ADN Mutante

Este proyecto es una API REST que permite verificar si un humano es mutante basándose en su secuencia de ADN. La verificación se realiza mediante un algoritmo que busca secuencias de cuatro letras iguales de forma horizontal, vertical y diagonal. El resultado de la verificación se guarda en una base de datos H2 y se pueden obtener estadísticas de las verificaciones realizadas.

## Estructura del Proyecto

El proyecto está estructurado en capas: controladores, servicios, repositorios y entidades.

- **Controladores**: Manejan las solicitudes HTTP y las respuestas.
- **Servicios**: Contienen la lógica del negocio y las operaciones relacionadas con el ADN.
- **Repositorios**: Interactúan con la base de datos.
- **Entidades**: Representan las estructuras de datos que se almacenan en la base de datos.

## Arquitectura del Proyecto
**Controllers/**
**DTO/**
**Service/**
**Repository/**
**Entity/**
**Validator/**
**Exception/**
**Config/**

## El Proyecto incluye
Tests unitarios del detector
Tests del servicio
Tests del controlador
Tests de integración

**Para ejecutar todos los tests:**
bash
./gradlew test


## Tecnologías Utilizadas

- Java 17 
- Spring Boot 
- Spring Web 
- Spring Data JPA 
- H2 Database 
- Swagger / OpenAPI 
- Gradle 
- Lombok 
- JUnit + Mockito

## Instrucciones para Ejecutar la Aplicación

1. **Descargar o clonar el repositorio en zip**
2. **Descomprimir el proyecto**
3. **Usar un IDE (Entorno de desarrollo integrado) para abrir el proyecto**
4. **Ejecutar la aplicacion desde el IDE**
5. **Para probar las peticiones de la API**
6. **3. Probar con Postman o Swagger**
7. **Para swagger es de la siguiente manera** http://localhost:8080/swagger-ui/index.html#/
8. **En render:**


🔹 Swagger en Render https://backendfinal-4pg1.onrender.com/swagger-ui/index.html

🔹 Swagger local http://localhost:8080/swagger-ui/index.html
  En la parte de prueba de post/mutant colocar:

9.**Instrucciones en swagger ejecutar en el Post/mutant**
{
"dna": ["AAAACT","CAGTAC","TTAAAT","AGACGG","CCTCTA","TCACTG"]
}
Retorna 200 si es mutante, 403 si es humano
 
**response headers**
connection: keep-alive
content-length: 0
date: Tue,25 Nov 2025 14:59:10 GMT
keep-alive: timeout=60
**response en get status**

----------Response body------------
Download
{
"ratio": 0,
"count_mutant_dna": 1,
"count_human_dna": 0
}
----------Response headers----------
connection: keep-alive
content-type: application/json
date: Tue,25 Nov 2025 14:59:36 GMT
keep-alive: timeout=60
transfer-encoding: chunked
**/stats-get**
Response
{
"count_mutant_dna": 40,
"count_human_dna": 100,
"ratio": 0.4
}
## QUE HACE EL ALGORITMO
**Algoritmo isMutant**

La detección se realiza mediante: Validación de matriz NxN
Verificación de caracteres válidos: A, T, C, G
Búsqueda en:Horizontal →, Vertical ↓ , Diagonal ↘ ,Diagonal ↙
Terminación anticipada cuando se detectan 2 o más secuencias

Implementado en:
src/main/java/.../Service/MutantDetector.java

# Implementacion en H2
Para abrir la consola H2 local:
Levantar la app
Ir a: http://localhost:8080/h2-console

Configuración:
**JDBC URL: jdbc:h2:mem:testdb**
**User: sa**
**Pass:**


# Diagrama de secuencia en: https://drive.google.com/file/d/1TdxzuaSUWimfJVyycOKsgWNfMvhZHPbc/view?usp=drive_link 
# Autor del Proyecto:
**Nombre y Apellido: Celeste Sierra**
**Legajo: 51097**
**Curso: 3k10, Desarrollo de Software**