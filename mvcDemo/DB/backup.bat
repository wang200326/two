@echo off
@echo Please Wait......
echo.

::define yy-mm-dd
set "year=%date:~0,4%"
set "month=%date:~5,2%"
set "day=%date:~8,2%"

::backup DataBase
mysqldump -uroot -p123 --databases mvcdemo > d:/mvcdemo-%year%-%month%-%day%.sql

echo OK!
@echo on
exit