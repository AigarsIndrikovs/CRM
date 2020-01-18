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
```

### Prerequisites

JAVA supported IDE (IntelliJ, NetBeans, Eclipse, etc)  
MySQL workbench  

## Running the tests

Tests are made for TaskService class;
To check getTaskById in check box need to be real text from DB with this id
No special requirements for other tests


### Break down into end to end tests

Tests check are the TaskService methods is working and made needed actions in DB.

 @Test
    void addTask() {
        int taskCountBefore = taskList.size();
        taskService.addTaskForTest("JUnit test");
        taskList = taskService.getSortedTask(true);
        taskList.size();
        assertEquals(taskList.size(),taskCountBefore + 1 );
    }

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [MySQL Workbench](https://www.mysql.com/products/workbench/) - Database  
* [Hibernate](https://hibernate.org/) - mapping tool for the Java

## Authors

* **Aigairs Indrikovs** - *Project Manager* - (https://github.com/AigarsIndrikovs)  
* **Peteris Zevalds** - (https://github.com/PeterisZevalds)  

## Known issues

* UI needs improvements

