# Java-JDBC-Application
Please Download MySQL server, MySQL Workbench, MySQL JConnector(for jar file) from **WWW.MySQL.COM**

<b>Java-JDBC-Application</b>

Create DB:

CREATE DATABASE database_name;

<b>Create Table:</b>

Use MyDB;

CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    PRIMARY KEY (ID)
);


<b>Insert Records</b>:

Insert into MyDB.Persons
(ID, LastName, FirstName, Age)
values
(1, 'Last 1', 'First 1', 22)


<b>Query to set permissions to root to access localhost: Please run this in SQL workbench:</b>

FLUSH PRIVILEGES;
ALTER USER 'root'@'localhost' IDENTIFIED BY ‘password';


Driver = “com.mysql.cj.jdbc.Driver”;

Connection url = “jdbc:mysql://localhost:3306/MyDB”;


<b>Connect From Command Line:</b>

Open your Mac terminal and type the command: mysql -u root -p
Now enter the Mysql password when prompted. After entering it should connect you to the MySQL server instance.
