# CRM Application

Simple CRM application that is designed to work on your local machine with local MySQL database.

## Getting Started

To run this application you need to import it to your IDE from github  

import Maven  
SetUp JDK1.8.0_221 project  
Import MySQL Database schema from   
```
CRM/MySQL Schema/CRM DatabaseSchema.sql
```
To Connect to database you need to change LOGIN and PASSWORD for your database in 
> src/Main/java/hibernate/utility/DBConfig.java
```
                settings.put(Environment.USER, "LOGIN");
                settings.put(Environment.PASS, "PASSWORD");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
```

### Prerequisites

JAVA supported IDE (IntelliJ, NetBeans, Eclipse, etc)  
MySQL workbench  

```
Give examples
```

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [MySQL Workbench](https://www.mysql.com/products/workbench/) - Database  

## Authors

* **Aigairs Indrikovs** - *Project Manager* - (https://github.com/AigarsIndrikovs)  
* **Peteris Zevalds** - (https://github.com/PeterisZevalds)  

## Known issues

* UI needs improvements

