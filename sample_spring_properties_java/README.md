# Spring on Properties with Java
In Spring framework, data properties file can be assessed in beans through pure Java configuration.

## Java Configuration
No xml file, only java config class is defined as below
```java
@Configuration
@ComponentScan({"com.home"})
@PropertySource({"metadata.properties"})
public class AppConfig {
}
```

## Properties
[metadata.properties](src/main/resources/metadata.properties) file content:
```properties
dbUsername=bbn
dbPassword=pwd
```

## Injection
Property values are injected through autowiring in [beans implementation](src/main/java/com/home/repository/CustomerRepositoryImpl.java).
```java
@Value("${dbUsername}")
private String dbUsername;
```

## Resolve
Bean is resolved in [application](src/main/java/Application.java)
```java
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
CustomerService customerService = context.getBean(CustomerService.class);
```
