# Db_To_Excel
Steps

1. Download Eclipse -> https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2019-12/R/eclipse-jee-2019-12-R-win32-x86_64.zip 

2. Download AdoptOpenJDK - > https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=openj9

3. Downlaod Maven -> https://maven.apache.org/download.cgi 
   After downloading set the path in Enviroment Variable 

4. Download Oracle and configure and then set them up in Application.properties file as 
	spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
	spring.datasource.username=system
	spring.datasource.password=root

  Download OJDBC jar file. 

5. Download and Import The Spring Project as Maven Import

6. After Importing do a maven update 

7. Execute all the SQL queries 

8. Execute the program.

