#!bin/bash
#default user 'postgres'
docker run --name some-postgres -e POSTGRES_PASSWORD=admin -p 5432:5432 -d postgres

