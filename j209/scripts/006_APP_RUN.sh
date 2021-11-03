. ./000_SET_ENV

docker run -d --name ${DOCKER_APP} \
    --network ${APP_NETWORK} \
    -e SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE} \
    ${APP_IMAGE}
