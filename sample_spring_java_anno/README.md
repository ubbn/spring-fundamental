# Spring via Java class (Autowired)
Spring configuration can be done through separate config java class and annonations in bean implementation classes. And using ``@Autowired`` annonation, spring automatically discovers and injects all services & repositories annonated in a given package.

## Configuration Class
- No need for xml config file ``applicationContext.xml``
- Only Java class annotated with ``@Configuration`` and ``@ComponentScan({<package path>})``
- No definition for bean in java config class because Spring automatically scans/discovers them itself
- However bean implementation classes must be annonated accordingly for Spring to find them

## Configuration
[Java configuration class](src/main/java/AppConfigAnno.java) is very minimal as below
```java
@Configuration
@ComponentScan({'com.hem'})
public class AppConfig {
}
```

## Example Injection
Bean implementation classes must be annotated for Spring to inject them automatically,  i.e. ``@Service``. And beans can be referenced with each other through ``@Autowired``
```java
@Service("fooCustomerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository = new CustomerRepositoryImpl();
    ...
}
```

## Resolve
Each bean is resolved in [application](src/main/java/Application.java) by its name defined with ``@Bean`` annotation
```java
ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
CustomerService service = appContext.getBean("fooCustomerService", CustomerService.class);
```