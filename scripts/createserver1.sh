#!/bin/bash

THISHOST=$(hostname)
APPLICATIONS=$(dpkg --get-selections | cut -f1)

DESCRIPTION="Version Control Server"
STATUS="ACTIVE"
IP=$(/sbin/ifconfig eth0 | sed -n '2 p' | awk '{print $2}' | awk -F":" '{print $2}')

VAR=$(echo "{\"serverDescription\":\""$DESCRIPTION"\",\"serverApplications\":\""$APPLICATIONS"\",\"serverStatus\":\""$STATUS"\",\"serverIP\":\""$IP"\",\"machineReadableName\":\""$THISHOST"\"}")

curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d "$VAR" http://10.0.2.2:9000/server
