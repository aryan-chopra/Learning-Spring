USE learning_spring;

CREATE TABLE IF NOT EXISTS accounts(
id INT PRIMARY KEY AUTO_INCREMENT,
name varchar(50) NOT NULL,
balance double NOT NULL
);
