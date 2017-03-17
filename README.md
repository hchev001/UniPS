# BackEnd

UniPS will allow university employees and students to inquire about businesses/services and review them.  It will consist of four roles: Administrators, Business Entities, Registered Users, and Guests. Department and businesses can voluntarily register in the UniPS web service so they can provide better access to information and services.

## Dependencies
-SpringSource Tool Suite
-MySql Workbench

## Database

### Setup
The database will be using is a local database and the credentials are:
<pre>
spring.datasource.username=root
spring.datasource.password=root
</pre>

**Note: You will need to have MySql Configured in your computer and make sure the MySql Server is running.

### Traceability and Version Control
Place all queries necessary to restore / replicate database state in the /sql folder. 

## Mail

Email credentials
<pre>
spring.mail.username=unipsi2017@gmail.com
spring.mail.password=success2017
</pre>

## Turning on the Back-end

- Import the project into Eclipse (Make sure you have the dependencies installed)
- Turn on Mysql local server
- Run the class **UniPsApplication** under the main packages and visit
	<pre>
	localhost:8080
	</pre>
	
# FrontEnd

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.0.0-rc.1.

## Styling

The CSS framework in use for this application is Bootstrap 4. Be sure to look at examples on website, as bootstrap 3 code may not render properly.
<pre>
https://v4-alpha.getbootstrap.com/
</pre>


### Development server
Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

### Bootstrap Dependency
We are using version 4.X of Bootstrap. If you are receiving bootstrap dependency errors after calling ng serve or ng build. Please follow the instructions in the following link to install Bootstrap 4 as a global reference. 
https://github.com/angular/angular-cli/wiki/stories-include-bootstrap

For Bootstrap 4 documenation, please visit:
https://v4-alpha.getbootstrap.com/

### Fake Rest Service
Set up a json server if you need a fake REST service. More information can be found at https://jsonplaceholder.typicode.com/

### Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive/pipe/service/class/module`.

### Build

Run `ng build --output-path ../static` to build the project. The build artifacts will be stored in the `static/` directory. Use the `-prod` flag for a production build. 

### Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

### Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).
Before running the tests make sure you are serving the app via `ng serve`.

### Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

