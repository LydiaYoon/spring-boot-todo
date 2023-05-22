# spring-boot-todo
**TO DO LIST**  
✅ 2020년 10월 18일 10시부터 13시까지 진행된 쿠버네티스 스터디를 위해 서버 어플리케이션 개발  
<br/>
<br/>

**개발 스택**
| <center></center> | <center>name</center> | <center>version</center> |
| :--: | -- | :--: |
| server | SpringBoot | 2.3.4 | 
|  | Java (OpenJDK) | 11 | 
| client | Vue | 2.9.6 |
|  | Bootstrap | 4.5.2 |
| storage | mongoDB | 4.4.1 |
| infra | Docker, k8s | - |
| IDE | IntelliJ (ULTIMATE) | 2020.1.4 |
| OS | macOS Catalina | 10.15.6 |
<br/>
<br/>
<br/>  

**미리보기**
<img src=".\img\screenshot.png" alt="screenshot" />
<br/>
<br/>
<br/>  

**실행방법**
1. 어플리케이션 빌드
```
$ pwd
/Users/narae/Documents/workspace/spring-boot-todo

$ ls
Dockerfile		data			img
HELP.md			docker-compose.yml	node_modules
README.md		gradle			package-lock.json
build			gradlew			settings.gradle
build.gradle		gradlew.bat		src

$ gradle clean build
BUILD SUCCESSFUL in 6s
6 actionable tasks: 6 executed
```

2. 도커 이미지 빌드

```
$ docker build -t to-do-springboot .

Successfully built f8bbe16fe2b5
Successfully tagged to-do-springboot:latest
```

3. 도커 이미지 확인
```
$ docker images
REPOSITORY               TAG                 IMAGE ID            CREATED             SIZE
to-do-springboot         latest              f8bbe16fe2b5        37 seconds ago      365MB
```

4. 도커 컨테이너 실행 (compose)
```
$ docker-compose up
Starting spring-boot-todo_mongodb_1 ... done
Recreating spring-boot-todo_app_1   ... done
Attaching to spring-boot-todo_mongodb_1, spring-boot-todo_app_1
app_1      | 
app_1      |   .   ____          _            __ _ _
app_1      |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
app_1      | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
app_1      |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
app_1      |   '  |____| .__|_| |_|_| |_\__, | / / / /
app_1      |  =========|_|==============|___/=/_/_/_/
app_1      |  :: Spring Boot ::        (v2.3.4.RELEASE)
app_1      | 
app_1      | 2020-10-17 08:13:43.105  INFO 1 --- [           main] com.example.todo.TodoApplication         : Starting TodoApplication on 29e9f5aebf9e with PID 1 (/webapp/to-do-springboot.jar started by root in /)
...
app_1      | 2020-10-17 08:13:45.334  INFO 1 --- [           main] com.example.todo.TodoApplication         : Started TodoApplication in 3.761 seconds (JVM running for 4.874)
```

5. 도커 컨테이너 확인
```
$ docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED              STATUS              PORTS                    NAMES
29e9f5aebf9e        to-do-springboot    "java -jar /webapp/t…"   About a minute ago   Up About a minute   0.0.0.0:5000->5000/tcp   spring-boot-todo_app_1
```

6. 프론트엔드 서버(Node.js) 실행
```
$ cd src/main/frontend

$ pwd
/Users/narae/Documents/workspace/spring-boot-todo/src/main/frontend

$ ls
README.md		config			node_modules		package.json		static
build			index.html		package-lock.json	src

$ npm run dev

> frontend@1.0.0 dev /Users/narae/Documents/workspace/spring-boot-todo/src/main/frontend
> node build/dev-server.js

> Starting dev server...


 DONE  Compiled successfully in 5327ms                                                                                                                                                            5:27:12 PM

> Listening at http://localhost:8080
```
<br/>
<br/>
<br/>  

**참고**  
➡ [Docker](https://parkgaebung.tistory.com/category/%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C/Docker)  
➡ [Kubernetes](https://parkgaebung.tistory.com/category/%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C/Kubernetes)
