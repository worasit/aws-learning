#!/bin/sh
docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=admin -d -p 3306:3306 mysql

