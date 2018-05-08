# Spring via XML
Here our java project uses Spring framework as dependency injector and its configuration is done through pure XML file

## XML Configuration
- Most common approach, yet simplest
- Uses spring application context file which is XML configuration file
- Services are injected inside XML file in 3 different ways (through Setter, Constructor and Autowiring)
- Services are resolved via ``AplicationContext``, central interface in Spring application for providing configuration information to application


## Application Context File
- Spring context file which is sort of HashMap
- Commonly named ``applicationContext.xml`` as convention. Name or extension doesn't matter as long as it is XML file
- Has namespaces which aid validation of configuration

## Injection
Injection is done in three different ways in xml config file. 
1. through **Constructor**

```xml
<bean name="fooCustomerService" class="com.home.service.CustomerServiceImpl">
    <constructor-arg index="0" ref="fooCustomerRepository"/>
</bean>
```

2. through **Setter**
```xml
<bean name="fooCustomerService" class="com.home.service.CustomerServiceImpl">
    <property name="customerRepository" ref="fooCustomerRepository"/>
</bean>
```

or shorthand way, property tag can be child attribute to bean.

```xml
<bean name="fooCustomerService" class="com.home.service.CustomerServiceImpl"
    p:customerRepository-ref="fooCustomerRepository"
/>
```

3. through **Autowiring**

Spring does automatic inferring to find & set required references in the below implementation class from other injected beans. It can autowire through by constructor, by type or by name.

```xml
<bean name="fooCustomerService"
      class="com.home.service.CustomerServiceImpl" autowire="constructor">
</bean>
```

## Resolve
When the service is needed, it is resolved by value in their name attribute.
Below bean ```CustomerServiceImpl``` has reference to (uses it as property inside) another bean which has name ```fooCustomerRepository```.
This bean is resolved in application with its name ```fooCustomerService``` as below: 
```java
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
CustomerService customerService = context.getBean("fooCustomerService", CustomerService.class);
```
