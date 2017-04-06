@echo off

set DIR=%~dp0


:: 
:: Build the Angular project
::
echo Building the frontend...
cd ./frontEnd
call ng build
cd /d "%DIR%"

::
:: Clean the maven backend and rebuild
::
cd ./backend
echo Cleaning the backend...
call mvnw clean
echo Installing the backend...
call mvnw install
cd /d "%DIR%"

::
:: Start mysql
:: 
call "C:\Program Files\MySQL\MySQL Server 5.7\bin\mysqld"


pause