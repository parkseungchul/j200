docker run -d --name j209_app \
    --network j209_net \
    -e SPRING_PROFILES_ACTIVE=docker \
    -p 80:8080 \
    j209_image