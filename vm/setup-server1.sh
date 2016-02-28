#!/bin/bash

echo "Installing Git........................................."
sudo apt-get update -qq
sudo apt-get install -y git

echo "Adding Server1 to Server-api..........................."
sh createserver1.sh
