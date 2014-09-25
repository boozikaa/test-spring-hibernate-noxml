test-spring-hibernate-noxml
===========================

**Reference:** [spring4-hibernate4-integration](http://www.beingjavaguys.com/2014/05/spring4-hibernate4-integration.html)

**Prerequisite**

- Spring 4

- Hibernate 4

- Maven 3

- Database: PostgreSQL
```sql
-- Table: employee

-- DROP TABLE employee;

CREATE TABLE employee
(
  id SERIAL  NOT NULL,
  email character varying(255),
  first_name character varying(255),
  last_name character varying(255),
  phone character varying(255),
  CONSTRAINT employee_pk PRIMARY KEY (id)
)

INSERT INTO "employee" ("first_name", "last_name", "email", "phone") VALUES  
 ( 'Virat', 'Kohli', 'virat@beingjavaguys.com', '89876787890'),  
 ( 'Sachin', 'Tendulkar', 'sachin@india.com', '89898989898'),  
 ( 'Virendra', 'Sehwag', 'viru@delhi.com', '8976778789');  
```

- Tomcat 8.0: add DataSource in context.xml
```xml
<Resource 
	name="jdbc/springhibernate_db" 
	auth="Container"
	type="javax.sql.DataSource" 
	username="postgres" 
	password="password"
	driverClassName="org.postgresql.Driver" 
	url="jdbc:postgresql://localhost:5432/springhibernate_db"
	maxActive="100" 
	maxIdle="30" 
	maxWait="10000" 
	validationQuery="select 1" 
	testOnBorrow="true"
	testOnReturn="true"
	testWhileIdle="true"
    timeBetweenEvictionRunsMillis="1800000"
    numTestsPerEvictionRun="3"
    minEvictableIdleTimeMillis="1800000"
/> 
``` 
[JNDI Datasource HOW-TO](http://tomcat.apache.org/tomcat-8.0-doc/jndi-datasource-examples-howto.html)



