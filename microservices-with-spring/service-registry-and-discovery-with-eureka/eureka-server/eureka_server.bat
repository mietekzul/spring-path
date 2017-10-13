@echo off
start "PEER_1" java -Dspring.profiles.active=peer1 -jar eureka-server-0.0.1-SNAPSHOT.jar
start "PEER_2" java -Dspring.profiles.active=peer2 -jar eureka-server-0.0.1-SNAPSHOT.jar