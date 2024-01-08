#!/bin/bash
export PGPASSWORD='2c16FG6E4fGfC4E6AcGcaD6CAfb2FFCD'
BASEDIR=$(dirname $0)
for i in 18 17 16 15 14 13 12 11 10 9
do
    file="c:/program files/postgresql/$i/"
    FILEPATH="c:/program files/postgresql/$i/bin"
    if [ -d "$file" ]
    then
        echo "Postgres version $i found."
        "$FILEPATH/psql.exe" -h roundhouse.proxy.rlwy.net -U postgres -p 55996 -d railway -f "$BASEDIR/dropdb.sql" &&
        "$FILEPATH/psql.exe" -h roundhouse.proxy.rlwy.net -U postgres -p 55996 -d railway -f "$BASEDIR/schema.sql" &&
        "$FILEPATH/psql.exe" -h roundhouse.proxy.rlwy.net -U postgres -p 55996 -d railway -f "$BASEDIR/data.sql" &&
        "$FILEPATH/psql.exe" -h roundhouse.proxy.rlwy.net -U postgres -p 55996 -d railway -f "$BASEDIR/user.sql"
        break
    fi
done
