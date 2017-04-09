@echo off

set DIR=%~dp0


:: Build the Angular project
cd ./frontEnd
echo Installing dependencies
call npm install

echo Building the frontend...
call ng build
cd /d "%DIR%"


:: Clean the maven backend and rebuild
cd ./backend
echo Cleaning the backend...
call mvnw clean
echo Installing the backend...
call mvnw install
cd /d "%DIR%"

:: Start mysql
:: Not really a way to do it in the script
echo Remember to start the MySql if not running.


pause