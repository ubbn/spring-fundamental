# Spring via Java class (Autowired)
Spring configuration can be done through pure java class without XML at all. And using ``@Autowired`` annonation, spring automatically discovers and injects all services, repositories annonated in a given package.

## Configuration Class
- No need for xml config file ``applicationContext.xml``
- Only Java class annotated with ``@Configuration`` and ``@ComponentScan({<package path>})``
- No definition for by bean in java config class because Spring automatically scans/discovers them itself
- However implementation class of services and repositories must be annonated accordingly for Spring to find them

## Configuration

```java
@Configuration
@ComponentScan({'com.hem'})
public class AppConfig {
}
```

## Example Injection
```java
@Service("fooCustomerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository = new CustomerRepositoryImpl();
    ...
}
```

## Resolve
```java
ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
CustomerService service = appContext.getBean("fooCustomerService", CustomerService.class);
```