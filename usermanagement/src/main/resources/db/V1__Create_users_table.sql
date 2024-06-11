CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE users (
                       id BIGINT PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       contact_number VARCHAR(15)
);
