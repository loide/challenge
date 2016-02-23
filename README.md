Prerequisites:
--------------
Java 1.7
Maven 3+

Build the project:
------------------
Create a standalone Instance
mvn spring-boot:run

Available Services:
-------------------
Can be found at http://localhost:8080/servers.

The accepted json format is as follows;
{
  "serverId": 1,
  "serverMachineReadableName": "Tucano",
  "serverDescription": "Continuous Integration",
  "serverApplications": "Jenkins",
  "serverStatus": "ACTIVE"
}
