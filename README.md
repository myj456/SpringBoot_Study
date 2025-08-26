# 1시간만에 끝내는 spring boot rest api 서비스 개발

<br>
<br>

## 한줄 소개
spring, spring boot 를 하나도 모르는 개발자를 위한 spring boot로 rest api를 한시간만에 만드는 방법을 라이브코딩으로 보여드립니다. <br>
<a href="https://www.inflearn.com/course/1%EC%8B%9C%EA%B0%84%EB%A7%8C%EC%97%90-%EB%81%9D%EB%82%B4%EB%8A%94-springboot-restapi/dashboard">
  인강사이트
</a>

<br>
<br>

## 기술 스택
- spring boot 3.5.5
- IntelliJ IDE Community
- maven gradle
- Java 21

<br>
<br>

## 배운 내용
- Swagger 사용법
- lombok 사용법
- RestController 클라이언트 데이터 요청 방식 (Dto, @RequestBody, @RequestParam, @PathVariable)
- Layer 나누기 (Controller, Service, Entity)
- H2 DB 사용법
- MyBatis 사용법
- JPA 사용법

<br>
<br>

## 발생한 문제
#### MyBatis 버전 호환성 문제: Invalid value type for attribute 'factoryBeanObjectType': java.lang.String <br>
  - **발생 원인**: myBatis와 Spring Boot Starter의 버전이 맞지 않아서 발생했음. <br>
  - **해결** -> Mybatis를 3.0.2에서 3.0.3으로 업그레이드를 시킴.




