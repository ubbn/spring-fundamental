# Spring via Annotation
Here our project uses Spring with annotaion configuration

## Annotation Configuration
- Uses annotations (``Service``, ``Repository`` etc) from ``org.springframework.stereotype`` package
- Every bean is configured by those those annotations

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


## Application Context File
XML config file ``applicationContext.xml`` is still used but not when defining beans.
```xml
<context:annotation-config />
<context:component-scan base-package="com.home" />
```

## Autowiring
Injected beans are referenced through autowiring in 3 different ways.
1. through **Constructor**
The most recommended way by Spring community
```java
@Autowired
public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
}
```

2. through **Setter**
```xml
@Autowired
public void setCustomerRepository(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository
}
```

3. through **Property**

```xml
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
