# Proyecto ADN Mutante

El proyecto consiste en una API que recibe una secuencia de ADN representada como un arreglo de Strings y determina si corresponde a un mutante.
El análisis se basa en la búsqueda de patrones de cuatro caracteres iguales (A, T, C o G) alineados en distintas direcciones dentro de la matriz.

Además de la verificación, el sistema:

- Guarda cada ADN procesado usando un hash único para evitar registros repetidos
- Expone un endpoint /stats que muestra estadísticas acumuladas
- Está documentado con Swagger para facilitar pruebas
- Utiliza una base de datos en memoria H2 como almacenamiento temporal
- Este desarrollo sigue una arquitectura por capas y aplica buenas prácticas de validación, manejo de errores y estructuración del código.

## Estructura del Proyecto

El proyecto está estructurado en capas: controladores, servicios, repositorios y entidades.

- **Controladores**: Manejan las solicitudes HTTP y las respuestas.
- **Servicios**: Contienen la lógica del negocio y las operaciones relacionadas con el ADN.
- **Repositorios**: Interactúan con la base de datos.
- **Entidades**: Representan las estructuras de datos que se almacenan en la base de datos.

## Arquitectura del Proyecto
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── appMutante/
│   │               ├── AppMutanteApplication.java      (Clase principal)
│   │               │
│   │               ├── Config/
│   │               │   └── SwaggerConfig.java          (Configuración OpenAPI)
│   │               │
│   │               ├── Controllers/
│   │               │   └── MutantController.java       (Endpoints API REST)
│   │               │
│   │               ├── DTO/
│   │               │   ├── DnaRequest.java             (Objeto entrada JSON)
│   │               │   ├── StatsResponse.java          (Objeto salida Stats)
│   │               │   └── ErrorResponse.java          (Objeto salida Error)
│   │               │
│   │               ├── Entity/
│   │               │   └── DnaRecord.java              (Tabla BD H2)
│   │               │
│   │               ├── Exception/                      (Paquete nuevo)
│   │               │   ├── GlobalExceptionHandler.java (Manejador global)
│   │               │   └── DnaHashCalculationException.java (Excepción custom)
│   │               │
│   │               ├── Repository/
│   │               │   └── DnaRecordRepository.java    (Interfaz JPA)
│   │               │
│   │               ├── Service/
│   │               │   ├── MutantDetector.java         (Lógica algorítmica pura)
│   │               │   ├── MutantService.java          (Lógica negocio/guardado)
│   │               │   └── StatsService.java           (Lógica estadísticas)
│   │               │
│   │               └── Validator/
│   │                   ├── DnaValidator.java           (Lógica validación)
│   │                   └── ValidDna.java               (Anotación @ValidDna)
│   │
│   └── resources/
│       └── application.properties                      (Config BD y puerto)
│
└── test/
└── java/
└── com/
└── example/
└── appMutante/
├── Controllers/
│   └── MutantControllerTest.java   🆕 (Tests de Integración)
│
└── Service/
├── MutantDetectorTest.java     (Tests Algoritmo - Mínimo 17)
├── MutantServiceTest.java      (Tests Mocks con Hash)
└── StatsServiceTest.java       (Tests Matemáticos)

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
8. **En render:** https://ejerciciomutantes.onrender.com
9. **Instrucciones en swagger ejecutar en el Post/mutant**
{
"dna": ["AAAACT","CAGTAC","TTAAAT","AGACGG","CCTCTA","TCACTG"]
}
Retorna 200 si es mutante, 403 si es humano, 400 si es ADN invalido
 
**response headers**
connection: keep-alive
content-length: 0
date: Tue,25 Nov 2025 14:59:10 GMT
keep-alive: timeout=60
**response en get status**

**Response body**
Download
{
"ratio": 0,
"count_mutant_dna": 1,
"count_human_dna": 0
}
**Response headers**
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

- Configuración:
**JDBC URL: jdbc:h2:mem:testdb**
**User: sa**
**Pass:**


# Diagrama de secuencia en: https://docs.google.com/document/d/1t2iURUWNBE_SR4z47Ofqt762xVFTgY2KBxJVj4wZDeM/edit?usp=sharing  
# Pruebas de la api en: https://drive.google.com/file/d/11rGL1XIouFp80qHwx17EYuVFc-ku6P0t/view?usp=sharing 
# Autor del Proyecto:
**Nombre y Apellido: Celeste Sierra**
**Legajo: 51097**
**Curso: 3k9, Desarrollo de Software**