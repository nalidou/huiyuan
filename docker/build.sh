IMAGE_NAME="huiyuan"
TAG="1.0"

cd ..
git pull
mvn clean
mvn package -DskipTests
cp target/*.jar docker/app.jar

cd docker
docker images
docker login -u 13552967920 --password 123456

docker build -t docker.io/13552967920/$IMAGE_NAME:$TAG .
docker images
##docker push harbor-registry.inner.youdao.com/fanyi-test/$IMAGE_NAME:$TAG


docker logout