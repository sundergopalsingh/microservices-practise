Circuit Breaker
This pattern is used to prevent cascading failures because of network connectivity, timeout, service unavailability issue
Circuit is in 3 possible states:-
1. Closed State - means calls to microservices are allowe. This is desirable and default state.
2. Open state - In this state, the call is not allowed to remote microservice. This is a bad state and not desirable.
3. Half Open - In this state, only few calls are allowed to remote microservice.

Steps for resilience4j:
- Add appropriate dependency (resilience4j)
- Add appropriate properties in application.properties
- Write a fallback method which returns some user friendly response to client
	- Signature of the fallback method must match with the method for which fallback was written (method which is annotated with @CircuitBreaker)
	- it must have extra parameter added with throwable

Because MS need to communicate with each other via REST call, and REST call might fail it is possible for cascading failure.
In order to avoid this cascading failure we must make sure that our system is resilient for failures

Exactly to do this spring cloud offers a library known as resilience4j
Note:- In old versions of cloud hystrix was used.
Note:- In old versions of spring cloud, for load balancing ribbon was used.
Note: In old versions of spring cloud zuul was used instead of api gateway.

