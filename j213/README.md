### Action List
- JPA DB
- Command 
- File upload/download
- Mapper 사용
- Thymeleaf layout
- 외부 변수 적용 script 폴더
- jar 파일 한개만 남기기 build.gradle

### Test URL
- http://localhost/
- http://localhost/fileView <== 폴더에 대한 예외처리가 되어 있지 않음 


### TODO LIST
- dockerfile 만들기

### Action Command
### DB 초기 세팅
<pre><code>
docker run -d --name mysqlDB \
    --platform linux/x86_64 \
    -e MYSQL_DATABASE=shop_schema \
    -e MYSQL_USER=user01 \
    -e MYSQL_PASSWORD=user01 \
    -e MYSQL_ROOT_PASSWORD=password \
    -p 3306:3306 \
    -v /Users/seungchulpark/DB/mysql:/var/lib/mysql \
    mysql

권한 주기
 create schema shop_schema;
 grant all privileges on shop_schema.* to 'user01'@'%';

스키마 목록 보기
 show databases
</code></pre>

## Active Profile
- -Dspring.profiles.active=ssh