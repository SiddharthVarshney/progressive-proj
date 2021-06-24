CREATE DATABASE project;
\c project;
CREATE TABLE users(
    userId SERIAL,
    userEmail varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    userName varchar(50) NOT NULL,
    dateOfCreation TIMESTAMP DEFAULT current_timestamp,
    gender varchar(10),
    userRating decimal(2,1),
    PRIMARY KEY (userId),
    UNIQUE (userEmail)
);