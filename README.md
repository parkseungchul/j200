# Spring Boot Tips 

## [1. How to make YUM(DEV, STAGING, PROD) files useful]()
### Method called when application starts
- ApplicationListener
### How to allocate variables
- @Value("${ ~ }")
### How to active a profile by parameter
- java -jar -Dspring.profiles.active=prod
### YML file priority
- YUM file inside jar file < Local YML File

## [2. How to use logback.xml]()
### Type 1. Use parameter
#### logback.xml ${LOG_PATH}
## Type 2. Use spring profile
### logback.xml springProfile element

## [3. How to make AOP(Controller, Service, DAO)]()     

## [5. How to make JUnit(Controller, Service, DAO)]()  
### profile
### security
