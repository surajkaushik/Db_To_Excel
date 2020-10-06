# Db_To_Excel
Steps

1. Download Eclipse -> https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2019-12/R/eclipse-jee-2019-12-R-win32-x86_64.zip 

2. Download AdoptOpenJDK - > https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=openj9
   	After downloading set the path in Enviroment Variable, if not done automatically.

3. Downlaod Maven -> https://maven.apache.org/download.cgi 
   	After downloading set the path in Enviroment Variable, if not done automatically.

4. Download Oracle and configure and then set them up in Application.properties file as 
	service Name -> xe
	Host Name -> localhost
	
	spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
	spring.datasource.username=system
	spring.datasource.password=root

	Download OJDBC jar file -> https://jar-download.com/?search_box=ojdbc8+jar

5. Download and Import The Springboot Project as Maven Project by Importing.

6. After Importing the project, do a maven update.

7. Execute all the SQL queries.

8. Execute the program.

9. goto any browser type -> http://localhost:4444/excel and your excel file will get downloaded.

