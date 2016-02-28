Prerequisites:
--------------
- Vagrant 1.7.4 >
- Virtual Box

Build the project:
------------------
First, start Virtualbox.
Then, execute:

$./deploy

It will create two vm using vagrant. The first vm is serverapi, which will run the webserver.
The second vm, server1, is a test server which will be deployed and inserted in the webserver.

This process will take some time, so go grab a coffee :)

Open http://localhost:9000 in your favorite browser and you will see the server created.


Available Services:
-------------------
CRUD can be found at http://localhost:9000

The accepted json format is as follows:

	{
	  "serverDescription": "Continous Integration",
	  "serverApplication": "Gerrit",
	  "serverStatus": "ACTIVE",
	  "serverIP": "10.0.0.5",
	  "machineReadableName": "Tucano"
	}

Notes:
------
- This environment was tested in an Ubuntu 15.04 host.
- When click on Access button, to view server details, it will open an xterm process to logged in the server vm.


Known Issues:
-------------
Do not validate field's values when create/updating server by web ui.
