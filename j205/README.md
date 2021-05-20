### 테스트 방법
- http://localhost:8060/login
- my_client1 선택 admin 로그인
- authorization code 71b3047d-9c62-4d0f-9eea-6f8e3f4d8def
- 테스트 코드 (client_a 로 호출하였기 때문, 윈도우와 리눅스 차이 " '칟)
  - 성공 curl http://localhost:8060/api/client_a -H 'Cookie: SESSION=18d601ff-3ed0-479f-a14c-eedcedabe343'
  - 성공 curl http://localhost:8060/api/client_a -H "Cookie: SESSION=5710e40f-a263-4f62-b96a-83b8b106f3b1"
  - 권한 없음 curl http://localhost:8060/api/client_b -H 'Cookie: SESSION=71b3047d-9c62-4d0f-9eea-6f8e3f4d8def'