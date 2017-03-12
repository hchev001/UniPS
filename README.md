# UniPS

UniPS will allow university employees and students to inquire about businesses/services and review them.  It will consist of four roles: Administrators, Business Entities, Registered Users, and Guests. Department and businesses can voluntarily register in the UniPS web service so they can provide better access to information and services.


#Dependencies

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

#Testing

All API testings can be done without restriction by running the class **UniPsApplicationTests** under the test packages and using the address
<pre>
localhost:9999/
</pre>
