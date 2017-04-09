#!/bin/bash

DIR=$(pwd)

# Build the Angular project
cd ./frontEnd
echo Installing dependencies
npm install

echo Building the frontend...
ng build
cd $DIR


# Clean the maven backend and rebuild
cd ./backend
echo Cleaning the backend...
mvn clean
echo Installing the backend...
mvn install
cd $DIR


# Start mysql
# Not really a way to do it in the script
echo "Remember to start the MySql if not running."
