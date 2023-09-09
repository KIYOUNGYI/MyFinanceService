## swagger-ui

localhost:8080/swagger-ui.html

## h2-console

localhost:8080/h2-console

## 도커파일(v1) 설명

```DockerFile
FROM openjdk:11-slim-stretch //<- 요런 베이스 이미지를 사용해서
EXPOSE 8080 // <- 이 포트를 오픈시키고
ARG JAR_FILE // <- JAR_FILE 이름은 ARGUMENT 로 받을 것이며
COPY ${JAR_FILE} app.jar // <- JAR_FILE 이름을 내부 컨테이너에 app.jar 로 저장할 것이며
ENTRYPOINT ["java","-jar","/app.jar"] <- 이 이미지가 올라왔을 때 옆에 있는 명령어로 이 이미지를 실행할 것이다.
```

```build.gradle
docker {
    println(tasks.bootJar.outputs.files)

    //image name
    name project.name + ":" + version

    //어떤 Dockerfile
    dockerfile file('./Dockerfile')//상대경로

    //어떤 파일들을 Dockerfile 에 복사할 것인가
    files tasks.bootJar.outputs.files

    //Dockerfile 에 전달할 인자
    buildArgs(['JAR_FILE': tasks.bootJar.outputs.files.singleFile.name])
}
```

- 특정 모듈만 빌드하고 싶을 땐 settings.gradle 가서 관심 없는 프로젝트 주석으로 막으면 됨

```shell
docker image ls | grep member
```

이미지 빌드는 되더라도 로컬이랑 동일한 환경에서 개발하려면

application.properties 에 적힌 값 Docker Desktop 에서 환경변수로 일일이 다 등록해줘야 함

그래서 더 편리하게 개발하려면 DockerCompose 를 이용해야 함

## Docker Compose

- docker 이미지들을 이용해서, 여러 개의 컨테이너를 실행하고, 이 컨테이너들을 관리하기 위한 도구
- 여러 컨테이너로 구성된 복잡한 애플리케이션 환경을 관리해주는 도구
- 주로 docker-compose 야멀 파일에 정의함
- 여러 어플리케이션들을 이미지로 만들고, 이 이미지들을 한 로컬에서 실행할 수 있도록 지원 