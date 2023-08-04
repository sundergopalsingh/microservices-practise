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

Microservices communication:
- Microservices are deployed on separate hardware and it is very common that they want to communicate
- It is typically done using REST call
- Traditionally REST call can be done by using RestTemplate class given by Spring
- Making Rest calls using RestTemplate is error prone, time consuming, hence we want to make REST call easier
- To exactly solve this problem, SpringCloud offers Openfeign library
- Openfeign is used to make REST call declarative

Steps to use Openfeign
- Add appropriate dependencies (openfeign)
- Create an interface. Annotate this interface with @FeignClient
- Add appropriate attributes in FeignClient annotation.
- Declare methods in OpenFeign
	- signature of method must match with remote method we are interested in calling(method name can be changed)
	- annotate these method with exact same annotation matching with remote annotation.
- Enable Feign clients by annotating application class with @EnableFeignClients. If we do not do this we get the following exception:-
	
Description:

Field feignClient in com.walmart.api.order.rest.controller.OrderRestController required a bean of type 'com.walmart.api.order.feign.client.CouponServiceFeignClient' that could not be found.

The injection point has the following annotations:
	- @org.springframework.beans.factory.annotation.Autowired(required=true)


Action:

Consider defining a bean of type 'com.walmart.api.order.feign.client.CouponServiceFeignClient' in your configuration.

	