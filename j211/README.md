### Springboot + docker + mysql 개발/운영 환경 
1. Intellij 에서의 테스트와 jar 파일 상태에서의 테스트의 다른 점 확인
  - thymeleaf prefix 설정을 추가해야 함 
<pre><code>spring:
  thymeleaf:
    prefix: classpath:/templates</code></pre>

2. 운영에 배포 되는 도커 이미지 생성 전략 
  - 소스 빌드는 로컬에서 실행, 운영은 docker 에서 실행
  - docker container 에서 최대한 작업은 단순하게 구성 (절대로 빌드 하지 마세요.)
  - 시간대도 한국으로 추가
<pre><code>
FROM openjdk:11

EXPOSE 8080

ADD ./build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "-Duser.timezone=Asia/Seoul", "/app.jar"]
</code></pre>
  - gradle.build 에 빌드 후에 예전 빌드 파일이 남지 않도록 세팅함
<pre><code>
jar {
    enabled = false
}
</code></pre>
3. 운영 되는 곳 마다 적용되는 프로파일을 다른게 만들자
  - 기본은 application.yml 이며 내부에서 --- 태그 보다는 환경 별로 파일을 만드는 것이 더 직관적
  - jar 직접 실행 시
<pre><code>
java -jar -Dspring.profiles.active=XXX,YYY application.jar
</code></pre>
  - docker cmd 실행되는 경우 
<pre><code>
docker run -d --name ${name} \
    --network j209_net \
    -e SPRING_PROFILES_ACTIVE=docker \
    -p 80:8080 \
    j209
</code></pre>

4. mysql 사용 할 경우 Junit 는 h2 DB를 활용하여 테스트 코드를 구성
  - jpa 통해 dao 개발 시 Mysql 과 h2 유사하게 동작하여 대처할 수 있음
  - junit db 테스트를 위한 별도의 구성을 고려할 필요가 없음 
  - build 시 DB 테스트 시간을 줄일 수 있음 (Junit 전반적인 고려 요소)
  
5. 운영 docker 를 운영할 경우 되도록 포트를 열지 마세요.
  - docker network create j209_net 를 구성하여 사용

6. build.gradle 에 백업 jar 옵션을 변경
  - 기본 설정으로 빌드할 경우 이전 jar 파일이 남아 Dockerfile 에서 jar 파일을 선택해야 가져와야 되는 불필요한 코딩 방지 

7. docker-compose 에서는 링크를 걸어줘야 함
  - docker 이름으로 호출할 수 있지만 docker-compose 는 이름이 정의 되지 않음으로 link 걸어줘야 함

<pre><code>
개발 
docker run -d  --name mysqlDB \
    -e MYSQL_DATABASE=j211_schema \
    -e MYSQL_USER=user01 \
    -e MYSQL_PASSWORD=user01 \
    -e MYSQL_ROOT_PASSWORD=password \
    -p 3306:3306 \
    mysql

운영 DOCKER DB Script 폴더 참고
create schema j209_db;
grant all privileges on j209_db.* to 'user01'@'%';
</code></pre>