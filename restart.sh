git pull
mvn clean
mvn package -DskipTests
nohup java -jar target/*.jar &
jps
netstat -anp | grep 12380
