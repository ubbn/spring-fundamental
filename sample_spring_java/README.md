# Spring via Java class
Spring is configured by pure java class without any XML file

## Configuration Class
- No need for xml config file, such as ``applicationContext.xml``
- Only java class annotated with ``@Configuration`` from ``org.springframework.context.annotation``
- Each method is a bean and annonated with ``@Bean`` with name attribute with unique value through 
which it is resolved in application
- Inside those methods, beans are injected via setter or constructor
- No annotation or a change in implementation of actual bean classes

## Injection
Illustrative example of injection in [Java config class](src/main/java/AppConfig.java) is as below: 
```java
@Configuration
public class AppConfig {
  /**
    * Here dependent repository is injected through setter,
    * Also it can be done in constructor injector as well
    * @return
    */
  @Bean(name = "fooCustomerService")
  public CustomerService getCustomerService(){
      CustomerServiceImpl service = new CustomerServiceImpl();
      service.setCustomerRepository(getCustomerRepository());

      return service;
  }

  @Bean(name = "fooCustomerRepository")
  public CustomerRepository getCustomerRepository(){
      return new CustomerRepositoryImpl();
  }
}
```

## Resolve
Each bean is resolved in [application](src/main/java/Application.java) by its name defined with ``@Bean`` annotation
```java
ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
CustomerService service = appContext.getBean("fooCustomerService", CustomerService.class);
```