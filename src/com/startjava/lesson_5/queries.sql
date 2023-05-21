\echo 'все роботы'
SELECT *
  FROM jaegers;

\echo 'выжившие роботы'
SELECT *
  FROM jaegers
 WHERE status = 'Survived';

\echo 'роботы нескольких серий: Mark-1 и Mark-4'
SELECT *
  FROM jaegers
 WHERE mark IN ('Mark-1', 'Mark-4');

\echo 'все роботы, кроме Mark-1 и Mark-4'
SELECT *
  FROM jaegers
 WHERE mark NOT IN ('Mark-1','Mark-4');

\echo 'сортировка таблицы по убыванию по столбцу mark'
SELECT *
  FROM jaegers
 ORDER BY (mark) DESC;

\echo 'самый старый робот'
SELECT *
  FROM jaegers
 WHERE launch_date =
       (SELECT MIN(launch_date)
          FROM jaegers);

\echo 'роботы, которые уничтожили больше всех kaiju'
SELECT *
  FROM jaegers
 WHERE kaiju_kill =
       (SELECT MAX(kaiju_kill)
          FROM jaegers);

\echo 'средний вес роботов'
SELECT AVG(weight)
  FROM jaegers;

\echo 'увеличение на единицу количества уничтоженных kaiju у роботов, которые до сих пор не разрушены'
   UPDATE jaegers
      SET kaiju_kill = kaiju_kill + 1
    WHERE status = 'Destroyed' 
RETURNING *;

\echo 'удаление уничтоженных роботов'
   DELETE
     FROM jaegers 
    WHERE status = 'Destroyed' 
RETURNING *;