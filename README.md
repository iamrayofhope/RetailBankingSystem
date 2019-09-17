# SupplyManagementSystem
Microservice built on Microservices Architecture using Spring Boot, Spring Cloud, 
and Netflix OSS frameworks such as Hystrix, Eureka.

![Service Calls](https://miro.medium.com/max/640/0*nQZhIgz34givPDhY.png)

## <a name="spring-boot-overview"></a>Spring Boot Overview
Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that can be "just run". 
Most Spring Boot applications need very little Spring configuration. Spring Boot embeds Tomcat, Jetty or Undertow directly and there is no need to deploy WAR files. You can use Spring Boot to create Java applications that can be started using java -jar or more traditional war deployments. It provides production-ready features such as metrics, health checks and externalized configuration.

## <a name="spring-cloud-overview"></a>Spring Cloud Overview
Spring Boot is app-centric. Spring Cloud builds on boot. The goal of Spring Cloud is to provide the Spring developers with an easily consumable set of tools to build distributed systems with common patterns (listed below) in distributed systems. It primarily does this by wrapping implementation stacks such as the Netflix OSS stack. These stacks are then consumed via the familiar tools of annotation-based configuration, Java configuration, and template-based programming.

* Distributed configuration: How to configure every instance of all of your services (standard boot config files checked into git or svn and distributed via config server).
* Service registration and discovery: how to locate a specific instance of a service (using Netflix Eureka)
* Client Side load balancing: intelligently choose an instance of a service to use (using Netflix Ribbon) via a smart algorithm such as: round robin or response time
* Plug into Ribbon via Spring Rest Template or Netflix Feign.
* Serve all assets and api's via a proxy that is plugged into service discovery and load balancing (Netflix Zuul).
* Stop cascading api failures with the Circuit Breaker pattern via Netflix Hystrix and visualize the health of all circuits with the Hystrix Dashboard.
* Send commands to all or some services via a lightweight message bus.
* Use oauth2 to protect resources

### <a name="spring-config-overview"></a>Spring Cloud Config Overview
Spring Cloud Config Server provides a centralized configuration service that is horizontally scalable. It uses as its data store a pluggable repository layer that currently supports local storage, Git, and Subversion. By leveraging a version control system as a configuration store, developers can easily version and audit configuration changes.

### <a name="spring-cloud-netflix-overview"></a>Spring Cloud Netflix Overview
Spring Cloud Netflix provides wrappers around several Netflix components: Eureka, Ribbon, Hystrix, and Zuul.

#### Eureka
[Eureka] (https://github.com/Netflix/eureka/wiki/Eureka-at-a-glance) is a resilient service registry implementation. A service registry is one mechanism for implementing the Service Discovery pattern. Spring Cloud Netflix enables the deployment of embedded Eureka servers by simply adding the spring-cloud-starter-eureka-server dependency to a Spring Boot application, then annotating that application’s configuration class with @EnableEurekaServer.

#### Hystrix
[Hystrix] (https://github.com/Netflix/Hystrix/wiki) provides an implementation of common fault-tolerance patterns for distributed systems such as circuit breakers and bulkheads. Circuit breakers are normally implemented as a state machine. Spring Cloud applications can leverage Hystrix by adding the spring-cloud-starter-hystrix dependency and annotating their configuration class with   @EnableCircuitBreaker. You can then add a circuit breaker to any Spring Bean method by annotating it with @HystrixCommand.

#### Hystrix Dashboard
[Hystrix Dashboard] (https://github.com/Netflix/Hystrix/wiki/Dashboard) In addition to providing the state machine behavior, Hystrix also emits a metrics stream from each circuit breaker providing important telemetry such as request metering, a response time histogram, and the number of successful, failed, and short-circuited requests.

#### Zuul
[Zuul] (https://github.com/Netflix/zuul/wiki) handles all incoming requests. It is used in combination with other Netflix components like Ribbon and Hystrix to provide a flexible and resilient routing tier for services.
