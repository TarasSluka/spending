@echo Off
cd spending
call mvn clean package > run.log
@echo On
call java -jar target\spending-0.0.1.jar