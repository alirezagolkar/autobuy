# Auto Buy Application
Auto buy project using Java version 11, Spring Boot, Spring Data JPA, MySql and Hibernate.

### Purpose ###
The purpose of the application is publishing vehicles with a base price. Then users of the application are able to bid for the vehicles. The vehicle will be sold to the user with the highest.

### Settings ###

#### Database Configuration ####
- Download the MySql database from https://www.mysql.com/downloads/.
- Create a database and call it `autobuy` 
- Run the application, the `autobuy` database tables gets generated automatically.
- For Demo purpose there is no Authentication setup, so no User authentication is required when sending request to the API.


### Deploy Instructions ###
- Open IntelliJ Idea.
- Navigate to
 ```
 File > Open 
 ```

Click Browse and navigate to the project folder, select `pom.xml` from the project root and click OK.
- Wait for Maven to download the dependencies.
- Go to Java Resources inside the project opened in IntelliJ Idea, locate the file
 ```
 src/main/java > com.dealers.autobuy.AutobuyApplication.java
 ```
Right-click the file > Run as Java Application.
The server with the back end will be running.
