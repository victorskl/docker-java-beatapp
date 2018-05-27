# docker-java-beatapp

Beat is a simple app which purpose is just to trial the dockerized Java app deployment.

```
cd docker-java-beatapp
javac Beat.java

docker build -t beat .
docker images|grep beat
docker run -it --rm --name beatapp beat

[ctrl+c]

docker rmi beat
```
