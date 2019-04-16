# docker-java-beatapp

- Beat is a simple Java console app which purpose is just to trial the dockerized Java app deployment. 
- It will set the default [JVM options](https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html) through `JAVA_OPTS` variable. At runtime, user can override the default `JAVA_OPTS`. 
- We will also practice to use the `git` commit short hash as a docker image version tag.

```
cd docker-java-beatapp

(with JDK8)
javac Beat.java

(with JDK11)
javac --release 8 Beat.java

java Beat
(ctrl+c to quit)

VTAG=$(git rev-parse --short HEAD)

docker image build -t beat -t beat:${VTAG} .
docker images|grep beat

docker run -it --rm --name beatapp beat
(ctrl+c to quit)

(let modify JAVA_OPTS environment variable)
docker run -e JAVA_OPTS='-Xms1g -Xmx1g' -it --rm --name beatapp beat
(ctrl+c to quit)

(let run through with docker compose)
docker-compose -p dev up -d
docker ps

docker logs -f dev_beat_1
(ctrl+c to quit)

docker-compose -p dev down

docker rmi beat beat:${VTAG}
```
