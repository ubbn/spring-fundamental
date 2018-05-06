# Spring via Java class
Spring configuration can be done through pure java class without XML at all

## Configuration Class
- No need for xml config file ``applicationContext.xml``
- Only Java class annotated with ``@Configuration`` (from ``org.springframework.context.annotation``)
- Each method is annonated as ``@Bean`` with name attribute with unique value through 
which they are resolved in application
- Inside those methods, beans are injected via setter or constructor
- No annotation in implementation of actual bean classes

## Example Injection

```java
@Configuration
public class AppConfig {
  /**
    * Here dependent repository is injected through setter,
    * it can be done in constructor injector
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
```java
ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
CustomerService service = appContext.getBean("fooCustomerService", CustomerService.class);
```