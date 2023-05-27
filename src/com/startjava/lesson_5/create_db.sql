DROP DATABASE IF EXISTS jaegers;

CREATE DATABASE jaegers;

DROP TABLE IF EXISTS jaegers;

CREATE TABLE jaegers (
    id SERIAL PRIMARY KEY,
    model_name TEXT,
    mark TEXT,
    height INTEGER,
    weight INTEGER,
    status TEXT,
    origin TEXT,
    launch_date DATE,
    kaiju_kill INTEGER
);

\echo 'инициализация базы данных'
\ir init_db.sql

\echo 'выполнение запросов'
\ir queries.sql