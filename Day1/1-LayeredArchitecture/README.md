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
