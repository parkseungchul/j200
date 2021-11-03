. ./000_SET_ENV

echo 'stop docker container'
docker stop ${DOCKER_WEB} ${DOCKER_APP} ${DOCKER_DB}

echo 'delete docker container'
docker rm ${DOCKER_WEB} ${DOCKER_APP} ${DOCKER_DB}

echo 'delete docker image'
docker rmi ${APP_IMAGE}
docker rmi ${WEB_IMAGE}

echo 'delete docker network'
docker network rm ${APP_NETWORK}