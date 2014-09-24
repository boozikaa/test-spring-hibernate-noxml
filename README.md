test-spring-hibernate-noxml
===========================

Prerequisite

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
