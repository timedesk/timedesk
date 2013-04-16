Timedesk
========

Timedesk is a web based project resource management system developed using Spring MVC. It provides features for Human Resource Management, Project
Management, Training Management and Employee Role Readiness Management. It is specially designed for managing software projects in IT organizations.

Timedesk was initially developed by a group of students who read for Masters in Eneterprise Application Development conducted by Sheffield Hallam University, United Kingdom at SLIIT, Colombo in year 2011. First it was hosted at Google Code: http://code.google.com/p/timedesk and moved to Github in year 2013.

New Features of Timedesk Beta 1.0
====================================
1. Added new attribute to Employee entity to hold Maximum Allocation.
2. Added validations to Project Member Allocation process to verify available allocation percentage before
allocating a member to a project.
3. Added user profile page to display logged in user information and linked it to the header. This will list out user 
security roles and employees of the user.
4. Added help text and links to all pages.


Issues Fixed in Timedesk Beta 1.0
====================================
1. Master detail record structures do not get refreshed once new child records are added.


Knows Issues of Timedesk Beta 1.0
====================================
1. Employee max allocation does not consider the time period. As a result an employee can only be allocated 
to the given maximum amount for all projects.
2. When creating and updating child records parent key is not properly set. This is set to the first parent record.

Technology Stack
==================

Persistence API
- Hibernate/EclipseLink
Business Logic Implementation
- Java EE 5
Web Client Implementation
- Spring MVC 3.0
Master Page Implementation for Web Client
- Apache Tiles 2.0
Code Generation + Client Framework
- Spring Roo 1.1.0
User Authentication
- Spring Security 3.0


System Requirements
=====================

Operating System
 Fedora 14/Ubuntu 10.10/Windows 7 Ultimate
Database Server
 MySQL Community Server 5.5.8
Application Server
 Apache Tomcat 6.0.29
Runtime Environment
 Java (JDK 1.6.23)
- Maven 2.2.1
- Spring Roo 1.1.0


Installation
==============

1. Download and install Apache Tomcat 6.0.29
2. Download and install Spring Tool Suite 2.5.1.
   This will contain Apache Maven 2.2.1, Spring Roo 1.1.0 and STS IDE 2.5.1.
3. Append Maven path and Spring Roo path including the bin folder to the 
   global path variable.
4. Download and install MySQL Community Server 5.5.8.
5. Extract timedesk-beta-1.0.zip and go to the extracted directory.
6. Deploy latest sql file found in database folder in the MySQL server.
   This will create the timedesk database and insert sample data.
7. Update database url, username and password in source\timedesk\src\main\resources\META-INF\spring\database.properties file.  
8. Go in to source\timedesk directory.
9. Run the command mvn tomcat:run. 
   This will build and deploy the web application in a local tomcat 
   server instance.
10. Now open a web browser and go to URL http://localhost:8080/timedesk.
11. Login using username:admin and password:admin.

