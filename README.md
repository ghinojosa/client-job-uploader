# client-job-uploader

Programa que extrae órdenes de trabajo de un endpoint del cliente, y carga esas mismas ordenes en el endpoint de VisualBoard.

## Version de OpenJDK
Para compilar y correr el programa se necesita al menos la versión 11 de OpenJK.

` Amazon Corretto 11.0.14 `

Si esa versión no es la que se tiene instalada por default o si no se desea instalar como la versión por default, el programa se puede compilar desde un IDE (IntelliJ) especificando la version 11 de JDK.

## Compilar

` mvn clean compile assembly:single `

Creará el archivo "client-job-uploader-jar-with-dependencies.jar". El nombre puede cambiarse a algo más corto (e.g. client-job-uploader.jar o uploader.jar).

## Correr
Para correr el programa:</br>
` java -jar client-job-uploader.jar <client-endpoint> <visualboard-domain> <api-key> `

Ejemplo:
```
java -jar client-job-uploader.jar http://192.168.1.1 acme aBtGgdAsdfa
```
