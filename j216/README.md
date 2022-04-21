### actuator ###

curl -d "{\"configuredLevel\":\"ERROR\",\"effectiveLevel\":\"ERROR\"}" -H "Content-Type: application/json" -X POST "http://localhost:8080/actuator/loggers/com.example"
curl -d "{\"configuredLevel\":\"TRACE\",\"effectiveLevel\":\"TRACE\"}" -H "Content-Type: application/json" -X POST "http://localhost:8080/actuator/loggers/com.example"


### Custom ###
 - http://localhost:8080/logger?packageName=com.example&level=ERROR
 - http://localhost:8080/logger?packageName=com.example&level=TRACE