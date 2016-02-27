Prerequisites:
--------------
- Jdk 1.8
- Maven 3+
- MongoDB

Build the project:
------------------
Create a standalone Instance
mvn spring-boot:run

Available Services:
-------------------
CRUD can be found at http://localhost:8080

The accepted json format is as follows:

	{
	  "serverDescription": "Continous Integration",
  	  "serverApplication": "Gerrit",
	  "serverStatus": "ACTIVE",
	  "serverIP": "10.0.0.5",
	  "machineReadableName": "Tucano"
	}
