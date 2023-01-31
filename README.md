Please Download MySQL server, MySQL Workbench, MySQL JConnector(for jar file) from WWW.MySQL.COM

# Java-JDBC-Application
Java-JDBC-Application
/*Create DB*/

CREATE DATABASE database_name;

/*Create Table*/

Use MyDB;

CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    PRIMARY KEY (ID)
);


/*Insert Recored to table*/

Insert into MyDB.Persons
(ID, LastName, FirstName, Age)
values
(1, 'Last 1', 'First 1', 22)


/*Query to set permissions to root to access localhost: Please run this in SQL workbench*/

FLUSH PRIVILEGES;
ALTER USER 'root'@'localhost' IDENTIFIED BY ‘password';


Driver = “com.mysql.cj.jdbc.Driver”;

Connection url = “jdbc:mysql://localhost:3306/MyDB”;



/*Connect From Command Line*/

Open your Mac terminal and type the command: mysql -u root -p


Now enter the Mysql password when prompted


After entering it should connect you to the MySQL server instance.
