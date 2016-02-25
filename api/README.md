Prerequisites:
--------------
- Jdk 1.7
- Maven 3+

Build the project:
------------------
Create a standalone Instance
mvn spring-boot:run

Available Services:
-------------------
Can be found at http://localhost:8080/server.

The accepted json format is as follows:

	{
	  "serverDescription": "Continous Integration",
  	  "serverApplication": "Gerrit",
	  "serverStatus": "ACTIVE",
	  "serverIP": "10.0.0.5",
	  "serverMachineReadableName": "Tucano"
	}
