# 베이스 이미지 정보
FROM adoptopenjdk/openjdk11:alpine

# 작성자
LABEL maintainer="narae456@gmail.com"

# Volume 설정
VOLUME /tmp

# 포트 포워딩
EXPOSE 5000

# 환경변수 설정
ARG JAR_FILE=build/libs/todo-0.0.1-SNAPSHOT.jar

# 디렉토리 생성 및 권한 부여
RUN mkdir -p /webapp
RUN chmod 777 /webapp

# 어플리케이션 jar 파일을 컨테이너로 복사
COPY ${JAR_FILE} /webapp/to-do-springboot.jar

# jar 파일 실행
ENTRYPOINT ["java", "-jar","/webapp/to-do-springboot.jar"]