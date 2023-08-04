Web application is meant for human consumption
Web service is meant for application consumption

The most common format of exchanging the data is JSON
To create a REST service in Spring we need to follow below steps:-
 - Create a new Class. Annotate this class with @RestController.
 - Define methods in this class. Annotate respective methods with appropriate annotation.
 - Add spring boot starter web dependency
 
Monolithic Application:
- It is a traditional way of building the application
- All the functionalities of a project exists in the single code base, then this is called as monolithic application
- It is a big single code base application
- It is deployed as a single unit

Drawbacks of Monolithic:-
- It becomes too large in size with time.
- Even for a small change, we need to re deploy whole application
- Scaling up/down is difficult in monolithic 
- It is very difficult to adopt new technology which is well suited for a particular functionality

In order to overcome these problems, we can divide our application into multiple small independent functionalities based on business

Such application is called as microservices application
Each microservice is developed and deployed independently on separate hardware.

One microservice must perform one single specific job

Scaling up/down of a specific microservice is possible
A change in one microservice need re deployment of that service, other microservices are unaffected.
We are free to choose appropriate technology for each microservice.

Important features of microservices:-
- Small autonomous services(based on business functionalities) working together
- Developed and deployed independently
- They are cloud enabled

