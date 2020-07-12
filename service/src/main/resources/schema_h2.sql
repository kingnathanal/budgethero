CREATE TABLE User (
    id IDENTITY,
    username VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE UserDetail (
    id IDENTITY,
    user_id BIGINT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(60)
);