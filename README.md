# EnterpriseJavaApplications
                                            Practical Assignments of Enterprise java 


1. Create a Application which converts an amount of money from one currency to other. Use database to store the inter-currency multiplication factor in database. Use EJB and web application.

2.  Using JMS technology create an application where a stock application sends share prices with comma separated name-value pairs (e.g “reliance:53,tata=45,wipro:76”). The message is subscribed by four clients. As soon as the clients recieve the message they update the share prices at their end. . Only JMS api is to be used.

3. Create an EJB for making a blockchain for three text files. Store final hashes and proof of work for every file in the database  with column names filename, finalhash and prof_of_work (nounce). The essential condition of the proof of work is getting a hash whose numeric value is “The  resulting hash should have two zeroes as prefix”. Also given the final hashes of three files test whether the application is in a block chain or not. Use sha-256 for calculating hash. Use java.security package for hashing . (You can refere online knowledge for block chain and hashing)

4.There are  Three tables department, Employee and Project. Department and Employee are in one to many relationship while project and employee have manay to many relationship Create CRUD and multiple search operations using Java Persistence API and EJB. Test all the method with servlets.

5. Modify the above assignment by converting all the logic to be based on REST design pattern and a Jersey Client. Test all the method with servlets.

6. Use Java EE-8 security on the above application  for authentication and authorization to access various method of REST logic. e.g. all crud operations can be access by admin while all search operations are done allowed to admin as well as users.

