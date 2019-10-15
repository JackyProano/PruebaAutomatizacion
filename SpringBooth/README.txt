En postgress crear una base de datos con el nombre ninjaRmm
spring.datasource.username=postgres
spring.datasource.password=maza261109 
el puerto sobre el cual se encuentra levantada la base de datos es 5433;

NOTA SI desea cambiar el nombre de la base, el puerto, uhsuario o clave  debe cambiar el archivo de configuracion sprinng application.properties
spring.datasource.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5433/ninjaRmm
spring.datasource.username=postgres
spring.datasource.password=maza261109


Luego ejecutar el siguiente script
dataBaseEsquema.sql:
Luego ejecutar
initialScript.sql


descargar la aplicacion de 
https://github.com/marcozaragocin/rmm-services.git

hubicarse eel directorio donde esta la app compilar la app mvn clean install;
ejecutar la aplicacion con el comando mvn spring-boot:run



Estos son los endPoints para pruebas.
Obtiene los dispositivos del customer dado su credencial
http://localhost:8080/customerDevice/getAll/1103605513
Elimina los dispositivos del Customer
http://localhost:8080/customerDevice/deleteDevice/1103605513/PRUEBA
Agrega un dispositivo
http://localhost:8080/customerDevice/addDevice/1103605513/MAC/ANTIVIRUS_MAC/PRUEBA


Obtiene  todos los servicios adquiridos por el customer
http://localhost:8080/customerService/getAll/1103605513
Borra servicios del customer
http://localhost:8080/customerService/deleteService/1103605513/PRUEBA/ANTIVIRUS_MAC
agrega servicios
http://localhost:8080/customerService/add/1103605513/PRUEBA/ANTIVIRUS_WIN

calcula el costo de servicios y dispositivos
http://localhost:8080/customerService/getCost/1103605513