# Spring via XML & Annotation
Here our project uses Spring with minimal XML config and java annotaion

## Application Context File
XML config file [``applicationContext.xml``](src/main/resources/applicationContext.xml) is still used. However no bean is defined in it. The given package is scanned and beans are injected automatically.
```xml
<context:annotation-config />
<context:component-scan base-package="com.home" />
```

## Annotation Configuration
Beans are annotated by ``Service``, ``Repository`` etc from ``org.springframework.stereotype`` package

```java
@Service("fooCustomerService")
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll()
            .stream().filter(x -> x.getFirstName() != null || x.getLastName() != null)
            .collect(Collectors.toList());
    }

}
```

## Autowiring
Injected beans are referenced each other through autowiring. And it can be done in 3 different ways.
1. through **Constructor**
The most recommended way by Spring community
```java
@Autowired
public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
}
```

2. through **Setter**
```java
@Autowired
public void setCustomerRepository(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository
}
```

3. through **Property**

```java
@Autowired
private CustomerRepository customerRepository;
```

## Resolve
Services are resolved via ``AplicationContext``, central interface in Spring application for providing configuration information to application. And they are resolved by value in their name attribute.
Below bean ```CustomerServiceImpl``` has reference to (uses it as property inside) another bean which has name ```fooCustomerRepository```.
This bean is resolved in application with its name ```fooCustomerService``` as below: 
```java
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
CustomerService customerService = context.getBean("fooCustomerService", CustomerService.class);
```
