DROP DATABASE IF EXISTS jaegers;

CREATE DATABASE jaegers;

DROP TABLE IF EXISTS jaegers;

CREATE TABLE jaegers (
    id SERIAL PRIMARY KEY,
    model_name text,
    mark text,
    height integer,
    weight integer,
    status text,
    origin text,
    launch_date date,
    kaiju_kill integer
);

\echo 'инициализация базы данных'
\ir init_db.sql

\echo 'выполнение запросов'
\ir queries.sql