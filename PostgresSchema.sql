CREATE DATABASE project;
\c project;
CREATE TABLE users(
    userId SERIAL,
    userName varchar(50) NOT NULL,
    email varchar(50) NOT NULL UNIQUE,
    password varchar(50) NOT NULL,
    gender varchar(10),
    rating decimal(2,1),
    createdAt TIMESTAMP DEFAULT current_timestamp,
    PRIMARY KEY (userId)
);