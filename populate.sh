#/bin/bash.

MYSQL_ARGS="-u new_user"
if [ -n "$1" ]; then
    MYSQL_ARGS="$@"
fi


mysql $MYSQL_ARGS < sql/user.sql