. ./000_SET_ENV

docker run -d --name ${DOCKER_DB} \
    --network ${APP_NETWORK} \
    -e MYSQL_DATABASE=${MYSQL_DATABASE} \
    -e MYSQL_USER=${MYSQL_USER} \
    -e MYSQL_PASSWORD=${MYSQL_PASSWORD} \
    -e MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD} \
    -v ${LOCAL_DB_PATH}:/var/lib/mysql \
    mysql

echo "===================="
echo "db schema script"
echo "docker exec -it " ${DOCKER_DB} " bash"
echo "grant all privileges on "${MYSQL_DATABASE}.* to" 'user01'@'%';"
echo "===================="

