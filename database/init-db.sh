#!/usr/bin/env bash
echo "Creating cogupdb database . . ."

psql -v ON_ERROR_STOP=1 --username postgres --dbname postgres <<-EOSQL
  CREATE USER cogupdb;
  CREATE DATABASE cogupdb,
  GRANT ALL PRIVILEGES ON DATABASE cogupdb TO cogupdb;
EOSQL

echo "Done creating database cogupdb."