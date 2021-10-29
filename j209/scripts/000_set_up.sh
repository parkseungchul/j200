docker network create j209_net

docker run -d --name mysqlDB \
    --network j209_net \
    -e MYSQL_DATABASE=j209_db \
    -e MYSQL_USER=user01 \
    -e MYSQL_PASSWORD=user01 \
    -e MYSQL_ROOT_PASSWORD=password \
    -v /build/DB/mysql:/var/lib/mysql \
    mysql