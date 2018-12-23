# OldPortal ManufacturingExecutionSystem

Activiti BPMN2-based discrete manufacturing processes scheduler.

Spring/JSF/database example application. 


Entry points:

http://localhost:8080/

http://localhost:8080/swagger-ui.html

http://localhost:8080/actuator


Build & Run

mvn package

java -jar target/manufacturing-execution-system.jar


Docker image Build & Run

mvn dockerfile:build

docker run -p 8080:8080 -t com.oldportal/manufacturing-execution-system:0.1-SNAPSHOT


Full deploy cycle

mvn package

mvn dockerfile:build

mvn verify

mvn dockerfile:push


Short deploy cycle

mvn deploy
