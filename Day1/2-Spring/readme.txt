Layered architecture is the most common architecture. The idea is divide the application into different components
 with similar functionalities and these are further grouped together under same name.
 As a result, each layer performs a specific role within the application.
 
 Example:-
 DAO Layer, Service Layer, GUI Layer etc

 Each class in Java must be in package.
 Package name should be reverse order of the domain we are working with.
 com.walmart.api.coupon.dao.impl
 
 
 
 Coupling -
 Degree to which one class/layer knows about the other one is coupling.
 
 One layer should talk to other only via public interface of the other layer.
 
 Here we are creating object and hence application class is tightly coupled with couponJpaDaoImpl
 
 So the core principle of Spring is Dependency Injection(DI)
 The idea is we ask spring cotainer to objects for our app, which then can be injected at runtime depending on the requirement
 every obj in the spring container is called as Bean, hence spring container is also called as Bean container
 Once the bean container is ready, we can ask for a specific bean type from container using getBean() method
 
 Steps to use spring:-
 
 	- Add appropriate dependencies()
 	-  create configuration classes for specific modules
 though initially spring was written for dependency injection, with time it has evolved and added many features, but to use these features we have to do configurations
 these configs can be time consuming, error prone, repetitive
 
 // to be completed