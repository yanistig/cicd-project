#CI/CD Test Project

### Description
This project use JDBC to connect with the postgres Database and then generate data with Faker to insert it into the corresponding table.
### Install Postgresql
Before you run the project make sure that you have tha latest version of postgresql , otherwise you cann install it using the folloing command :
>sudo apt install postgresql

### Run SQL script
Run the following command to create the corresponding database, user and table :
>sudo -i -u postgres
>psql -U postgres -f psqlScript.sql

### Run Project
To run the project use the following command :
>mvn install
