# docker-java-beatapp

Beat is a simple app which purpose is just to trial the dockerized Java app deployment. It will set the default [JVM options](https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html) through `JAVA_OPTS` variable. At runtime, user can override the default `JAVA_OPTS`. It will also practice to use the `git` commit short hash as a docker image version tag.

```
cd docker-java-beatapp
javac --release 8 Beat.java

VTAG=$(git rev-parse --short HEAD)

docker image build -t beat -t beat:${VTAG} .
docker images|grep beat

docker run -it --rm --name beatapp beat
[ctrl+c]

(let modify JAVA_OPTS env var)
docker run -e JAVA_OPTS='-Xms1g -Xmx1g' -it --rm --name beatapp beat
[ctrl+c]

(let run through with docker compose)
docker-compose -p dev up -d
docker ps
docker logs -f dev_beat_1
[ctrl+c]
docker-compose -p dev down

docker rmi beat beat:${VTAG}
```
