-- liquibase formatted sql

-- changeset see1rg:1
CREATE TABLE public.messages (
                                     id SERIAL PRIMARY KEY,
                                     message TEXT
);
