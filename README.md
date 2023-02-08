# client-job-uploader

Programa que extrae órdenes de trabajo de un endpoint del cliente, y carga esas mismas ordenes en el endpoint de VisualBoard. 

## Version de OpenJDK
Para compilar y correr el programa se necesita al menos la versión 11 de OpenJK.

` Amazon Corretto 11.0.14 `

## Compilar

` mvn clean compile assembly:single `

## Correr
Para correr el programa:</br>
` java -jar client-job-uploader.jar <client-endpoint> <visualboard-domain> <api-key> `

Ejemplo:
```
java -jar client-job-uploader.jar http://192.168.1.1 acme aBtGgdAsdfa
```