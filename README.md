# spring-boot-sample-crud
Ejercicio practico con spring-boot, algo de bootstrap, JPA, MySQL

# Pasos a seguir:

- Descargar el proyecto desde el branch "master"
- En el acrchivo "application.yml" se debe configurar la Base de Datos (esquema, usuario, contraseña), que para este ejercicio se uso MySQL.
NOTA: no se genera una base de datos en memoria. La tabla se genera en automático una vez conectada a la BD y arracando el proyecto.
- Compilar: mvn clean install
- Inicializar: mvn spring-boot:run
- Ingresar: http://localhost:8095/
NOTA: El puerto puede configurarse dentro del mismo archivo "application.yml".
