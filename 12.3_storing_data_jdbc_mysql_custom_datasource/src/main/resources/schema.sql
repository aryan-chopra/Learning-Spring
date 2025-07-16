USE learning_spring;

CREATE TABLE IF NOT EXISTS purchase (
id INT PRIMARY KEY AUTO_INCREMENT,
product varchar(50) NOT NULL,
price double NOT NULL
);
