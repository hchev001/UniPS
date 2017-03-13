# UniPS

UniPS will allow university employees and students to inquire about businesses/services and review them.  It will consist of four roles: Administrators, Business Entities, Registered Users, and Guests. Department and businesses can voluntarily register in the UniPS web service so they can provide better access to information and services.


#Dependencies
-SpringSource Tool Suite
-MySql Workbench

#Database

##Setup
The database will be using is a local database and the credentials are:
<pre>
spring.datasource.username=root
spring.datasource.password=root
</pre>

**Note: You will need to have MySql Configured in your computer and make sure the MySql Server is running.

##Traceability and Version Control
Place all queries necessary to restore / replicate database state in the /sql folder. 

#Mail

Email credentials
<pre>
spring.mail.username=unipsi2017@gmail.com
spring.mail.password=success2017
</pre>

#Turning on the Back-end

- Import the project into Eclipse (Make sure you have the dependencies installed)
- Turn on Mysql local server
- Run the class **UniPsApplication** under the main packages and visit
	<pre>
	localhost:8080
	</pre>
	

#Styling

The CSS framework in use for this application is Bootstrap 4. Be sure to look at examples on website, as bootstrap 3 code may not render properly.
<pre>
https://v4-alpha.getbootstrap.com/
</pre>
