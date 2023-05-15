 -- drop database hospitaldatabase;

create database hospitaldatabase;
use hospitaldatabase;

CREATE TABLE employees (
employees_ID integer NOT NULL AUTO_INCREMENT,
 name_employee varchar(32) NOT NULL, 
 gender varchar(32),
 phoneNum varchar(32), 
 dateOfBirth date,
 salary real, role varchar(32),
 name_bulding varchar(32) NOT NULL,
 city varchar(32) NOT NULL,
 PRIMARY KEY (employees_ID));
 alter table employees  auto_increment=12000;
 
CREATE TABLE pateint (pateint int NOT NULL AUTO_INCREMENT,
 pateint_Name varchar(32),
 gender varchar(32), phoneNum real,
 dateOfBirth date,
 insurance varchar(32),
 name_bulding varchar(32) NOT NULL,
 city varchar(32),
 PRIMARY KEY (pateint));
 
 CREATE TABLE secretaries (employees_ID int NOT NULL,
 PRIMARY KEY (employees_ID),
 FOREIGN KEY (employees_ID) REFERENCES employees (employees_ID));
 
 CREATE TABLE doctor (employees_ID int NOT NULL, 
PRIMARY KEY (employees_ID),
 FOREIGN KEY (employees_ID) REFERENCES employees (employees_ID));
 
CREATE TABLE diagnosis (diagnosis_ID int NOT NULL AUTO_INCREMENT, 
pateintpateint int NOT NULL,
 treatment_discription varchar(32), 
  pateint_Name varchar(32), 
 diagnosis_description varchar(32),
 dateOfDiagnosis date, 
 doctor_ID int NOT NULL,
 PRIMARY KEY (diagnosis_ID),
 FOREIGN KEY (pateintpateint) REFERENCES pateint (pateint),
 FOREIGN KEY (doctor_ID) REFERENCES doctor (employees_ID));
 alter table diagnosis drop foreign key diagnosis_ibfk_1 ;
alter table diagnosis drop foreign key diagnosis_ibfk_2;
alter table diagnosis  auto_increment=100;


 
 
CREATE TABLE payment (payment_ID int NOT NULL AUTO_INCREMENT,
 datePayment date,
 doctor_ID int NOT NULL,
 secretaries_ID int NOT NULL,
 pateint_id int NOT NULL,
 cost real,
 PRIMARY KEY (payment_ID),
 FOREIGN KEY (doctor_ID) REFERENCES doctor (employees_ID),
 FOREIGN KEY (secretaries_ID) REFERENCES secretaries (employees_ID),
 FOREIGN KEY (pateint_id) REFERENCES pateint (pateint));
 
CREATE TABLE appointments (appointments_ID int NOT NULL AUTO_INCREMENT,
 dateApponitments date,
 secretaries_ID int NOT NULL,
 doctor_ID int NOT NULL,
 pateint_id int NOT NULL,
 time varchar(32),


 PRIMARY KEY (appointments_ID),
 FOREIGN KEY (secretaries_ID) REFERENCES secretaries (employees_ID),
 FOREIGN KEY (doctor_ID) REFERENCES doctor (employees_ID),
 FOREIGN KEY (pateint_id) REFERENCES pateint (pateint));
 alter table appointments drop foreign key appointments_ibfk_1 ;
alter table appointments drop foreign key appointments_ibfk_2 ;
alter table appointments drop foreign key appointments_ibfk_3 ;
 alter table employees  auto_increment=12000;




select * from  diagnosis;
select * from  pateint;

select * from  employees;
alter table payment drop foreign key payment_ibfk_1 ;
alter table payment drop foreign key payment_ibfk_2 ;
alter table payment drop foreign key payment_ibfk_3 ;
show create table appointments;

select * from  payment;