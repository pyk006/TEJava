#!/bin/bash
export PGPASSWORD='XWJ91dyfppBCyMEZEYxg'
BASEDIR=$(dirname $0)
for i in 18 17 16 15 14 13 12 11 10 9
do
    file="c:/program files/postgresql/$i/"
    FILEPATH="c:/program files/postgresql/$i/bin"
    if [ -d "$file" ]
    then
        echo "Postgres version $i found."
        "$FILEPATH/psql.exe" -h containers-us-west-135.railway.app -U postgres -p 7411 -d railway -f "$BASEDIR/dropdb.sql" &&
        "$FILEPATH/psql.exe" -h containers-us-west-135.railway.app -U postgres -p 7411 -d railway -f "$BASEDIR/schema.sql" &&
        "$FILEPATH/psql.exe" -h containers-us-west-135.railway.app -U postgres -p 7411 -d railway -f "$BASEDIR/data.sql" &&
        "$FILEPATH/psql.exe" -h containers-us-west-135.railway.app -U postgres -p 7411 -d railway -f "$BASEDIR/user.sql"
        break
    fi
done