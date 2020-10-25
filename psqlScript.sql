CREATE user testcicd;

ALTER ROLE testcicd with createdb;

CREATE DATABASE testdatabase; 

alter database testdatabase owner to testcicd;

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO testcicd;

alter user testcicd with encrypted password 'helloWorld';

\c testdatabase 

CREATE TABLE IF NOT EXISTS client (
firstname varchar(200), 
lastname varchar(200), 
age int, 
job varchar(200), 
height int, 
weight int, 
city varchar(200)); 

ALTER TABLE client OWNER TO testcicd;
