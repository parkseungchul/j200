. ./000_SET_ENV

cd ..
docker build -t ${IMAGE} --build-arg SPRINGBOOT_PORT=${SPRINGBOOT_PORT} .