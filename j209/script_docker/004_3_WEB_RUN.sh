. ./000_SET_ENV

docker run -d --name ${DOCKER_WEB} \
    --network ${APP_NETWORK} \
   -p ${DOCKER_WEB_PORT}:80 \
   ${WEB_IMAGE}
