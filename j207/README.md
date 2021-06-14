### k6 홈페이지: https://k6.io/
### K6에 대한 설명: https://ichi.pro/ko/k6-sogae-api-buha-teseuteu-dogu-21071336538749
### spring MVC vs Spring WebFlux: https://medium.com/codeengineer/sprint-boot-application-using-spring-webmvc-and-webflux-d94672b70595

docker run -i loadimpact/k6 run --vus 10 --duration 30s - <web.js
docker run -i loadimpact/k6 run --vus 10 --duration 30s - <webflux.js