# RetoBackend Sura
Descripción breve del proyecto.

Requisitos previos
Java 17 o superior
Gradle 3.0 o superior
MySQL 5.7 o superior
MongoDB 4.0 o superior
Instalación
Clona este repositorio en tu máquina local.
Importa el proyecto en tu IDE favorito como un proyecto de Gradle.
Configura las credenciales de la base de datos en el archivo application.properties:
properties
Copy code
# Configuración de MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/db_sura
spring.datasource.username=usuario_mysql
spring.datasource.password=contraseña_mysql

# Configuración de MongoDB
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=nombre_basedatos
spring.data.mongodb.username=usuario_mongo
spring.data.mongodb.password=contraseña_mongo
Asegúrate de que MySQL y MongoDB estén en ejecución en tu máquina local o cambia las configuraciones para apuntar a tus bases de datos en la nube.
Uso
Explica cómo usar el proyecto y proporciona ejemplos de endpoints, si corresponde.

Base de Datos
El proyecto utiliza tanto una base de datos relacional con MySQL como una base de datos no relacional con MongoDB.

MySQL
La base de datos relacional MySQL se utiliza para almacenar [describir qué se almacena en MySQL, por ejemplo, datos de usuarios, registros de transacciones, etc.].

MongoDB
La base de datos no relacional MongoDB se utiliza para [describir qué se almacena en MongoDB, por ejemplo, registros de actividad, datos de configuración, etc.].

Contribución
Explica cómo otros desarrolladores pueden contribuir al proyecto. Por ejemplo, puedes incluir instrucciones para bifurcar el repositorio y enviar solicitudes pull.

Problemas conocidos
Enumera problemas conocidos o errores que los usuarios deben tener en cuenta.

Licencia
Indica la licencia bajo la cual se distribuye el proyecto. Por ejemplo:

Este proyecto se distribuye bajo la licencia MIT. Consulta el archivo LICENSE para obtener más información.

Recuerda personalizar este README con detalles específicos de tu proyecto, como el nombre del proyecto, el contenido de las bases de datos, etc. También asegúrate de incluir cualquier otro detalle relevante sobre el proyecto, como la estructura de directorios o configuraciones adicionales.

Espero que este README te ayude a empezar con tu proyecto de Spring Boot que utiliza tanto MySQL como MongoDB. ¡Buena suerte con tu proyecto! Si tienes alguna otra pregunta o necesitas más ayuda, no dudes en preguntar.

# Proyecto realizado por: 
- Alejandro Londoño Pérez
- Alexander Gallo López
- Lina Valeria Medina Escobar
- Juan Pablo Giraldo Tamayo





