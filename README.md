# [스프링부트] 게시판 무작정 따라하기 - 한코
프로그래밍 입문이 어려워서 고민하시는 분들이 웹 개발을 체험하실 수 있게 영상을 제작했습니다! <br>
<a href="https://www.youtube.com/watch?v=frI5CoZe-vE&list=PLZzruF3-_clsWF2aULPsUPomgolJ-idGJ&index=1">
  인강사이트
</a>

<br>
<br>

## 기술 스택
- spring boot 3.5.5
- IntelliJ IDE Community
- Gradle
- Java 21
- Maria DB 10.6
- MySQL Workbench 8.0.40
- Thymeleaf

<br>
<br>

## 배운 내용
- Thymeleaf를 활용한 게시글 CRUD
- 파일 업로드 및 확인
- 페이징 처리
- 검색

<br>
<br>

## 발생한 문제
#### MySQL Workbench와 Maria DB 연동 문제 <br>
  - **발생 원인**: MySQL과 Maria DB 버전 호환성이 안돼서 MySQL Workbench와 연동이 안됐음. <br>
  - **해결** -> Maria DB를 12.0.2 에서 10.6 으로 다운그레이드를 시킴.
  => 근데 MySQL 8.0.40은 MariaDB 10.3 이하를 기준이라 완전히 해결된건 아님.



