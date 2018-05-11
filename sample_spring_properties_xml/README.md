# Spring on Properties with XML
In Spring framework, data properties file can be assessed in beans through XML configuration.

## XML Configuration
- Application context is configured in config file ``appContext.xml``
- Properties file is imported inside [app text config file](src/main/resources/appContext.xml)
```xml
<context:annotation-config/>
<context:property-placeholder location="metadata.properties"/>
<context:component-scan base-package="com.home"/>
```

## Properties
[Properties file](src/main/resources/metadata.properties) content:
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