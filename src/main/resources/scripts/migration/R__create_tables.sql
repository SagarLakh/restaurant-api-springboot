CREATE TABLE IF NOT EXISTS restaurants (
     id             INTEGER NOT NULL,
     name           VARCHAR NOT NULL,
     description    VARCHAR NOT NULL,
     city           VARCHAR NOT NULL,
     address        VARCHAR NOT NULL,
     PRIMARY KEY (id)
);