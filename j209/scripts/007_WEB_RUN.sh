. ./000_SET_ENV

docker run -d --name ${WEB} \
    --network ${APP_NETWORK} \
   -p ${DOCKER_WEB_PORT}:80 \
   -v ${DEFAULT_CONF_DIR}/default.conf:/etc/nginx/conf.d/default.conf \
   nginx
