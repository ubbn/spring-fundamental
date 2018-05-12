# Spring fundamental
The project aims to demonstrate practical use of [Spring framework](https://spring.io/) in java application. 

## Spring

Spring framework facilitates java project to work effiently and allows developers to focus on business logic part of the application. Developers don't need to code complex boilerplate codes which are responsible for mundane general tasks like managing connection to database, handling exceptions and other repetitive tasks.

### Features of Spring
- **Supports J2EE**  
Lightweight, simple to use, Highly reliable, meets standard of enterprise applications as built around best practices
- **Simple POJO**  
Spring uses beans which are POJO. POJO is plain old java object. Developers don't need to implement interfaces or extend classes, just write simple java classes for business logic with necessary. Those classes have to be configured as beans which provide all magics of Spring
- **Removes configuration code**   
Removes configuration codes from business logic codes. And configurations are separated in xml file or java classes. 
- **Design patterns**
Provides dependency injection out of box and supports interface driven development by using practical design patterns like singleton, factory etc. 

### Inner Working of Spring
In Spring, beans are java classes which are barebone of your application and they are assembled and managed by Spring IoC container. All beans' instantiation and initialization handled by Spring. Spring configuration metadata is totally decoupled from Spring IoC container itself and there are three different methods:
- XML based configuration file
- Annontation-based (with minimal XML or java config)
- Java-based configuration class

By default any bean in Spring is in **Singleton** scope. It can be configured differently using ``@Scope`` annotation with other value such as **Prototype**, **Session**, **Request** etc.   

Beans are resolved via ``AplicationContext``, central interface in Spring application for providing configuration information to application. 

## Sample Application
The same application is developed in 5 different ways to demonstrate how Spring can help and how it can be configured. 

### Application architecture
The sample application is structured into several logical layers:
- **Customer model** that describes data
- **Customer repository** stores customers data and provides access to it
- **Customer service** provide business logical service
- **Application class** utilizes service

### No Spring
[Here](https://github.com/ubbn/spring-fundamental/tree/master/sample), it is a basic java maven project without Spring

### Spring with pure XML
[Here](https://github.com/ubbn/spring-fundamental/tree/master/sample_spring_xml/), Spring is used and configured with **pure XML** file

### Spring with XML & annotation
[Here](https://github.com/ubbn/spring-fundamental/tree/master/sample_spring_xml_anno/), Spring is used and configured with **minimal XML** file and **java annotations** in bean injection classes

### Sample with java config
[Here](https://github.com/ubbn/spring-fundamental/tree/master/sample_spring_java/), Spring is used and configured with **pure java** class, no change in bean injection classes

### Sample with java config & annotation
[Here](https://github.com/ubbn/spring-fundamental/tree/master/sample_spring_java_anno/), Spring is used and configured with **java** class and **annotations** in bean injection classes

## Sample Application with Properties
The same application acccesses data in properties through java configuration and xml configuration

### Sample and Properties with java config
[Here](https://github.com/ubbn/spring-fundamental/tree/master/sample_spring_properties_java/), Spring accesses application data in properties file through **java** configuration

### Sample and Properties with xml config
[Here](https://github.com/ubbn/spring-fundamental/tree/master/sample_spring_properties_xml/), Spring accesses application data in properties file through **xml** configuration
