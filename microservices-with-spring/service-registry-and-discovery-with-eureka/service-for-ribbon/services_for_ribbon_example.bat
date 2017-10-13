@echo off
start "INSTANCE_1" java -Dserver.port=7777 -jar service-for-ribbon-0.0.1-SNAPSHOT.jar
start "INSTANCE_2" java -Dserver.port=7778 -jar service-for-ribbon-0.0.1-SNAPSHOT.jar
start "INSTANCE_3" java -Dserver.port=7779 -jar service-for-ribbon-0.0.1-SNAPSHOT.jar
