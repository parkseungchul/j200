. ./000_SET_ENV

docker run -d --name ${APP} \
    --network ${APP_NETWORK} \
    -e SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE} \
    ${IMAGE}
