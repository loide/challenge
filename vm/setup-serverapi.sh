#!/bin/bash

echo "Installing Java 8......................................"
sudo apt-get install -y python-software-properties
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update -qq
sudo apt-get install -y openjdk-8-jdk

echo "Installing Maven......................................."
sudo apt-get install -y maven

echo "Installing MongoDB....................................."
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv EA312927
echo "deb http://repo.mongodb.org/apt/ubuntu trusty/mongodb-org/3.2 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.2.list
sudo apt-get update -qq
sudo apt-get install -y mongodb-org
sudo service mongod start

echo "Installing xterm for access servers"
sudo apt-get install -y xterm

echo "Deploying Server-api..................................."
cd api
mvn clean package
java -jar target/challenge-rest-service-0.1.0.jar &
