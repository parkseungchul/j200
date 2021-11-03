. ./000_SET_ENV
cd ..
docker build -t ${APP_IMAGE} --build-arg SPRINGBOOT_PORT=${SPRINGBOOT_PORT} .