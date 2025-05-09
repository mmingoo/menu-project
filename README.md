# 프로젝트 소개
가천대학교 식단 크롤링 서비스를 MVC 패턴으로 구현한 경험이 있다. (github.com/mmingoo/Gmenu) MVC 패턴에서 Client-Server 구조로 변경하고, 이를 배포하여 가천대학교 학생들이 실제로 겪는 불편함을 해소하고자 개발을 진행하였다. 또한 1년 동안 공부했던 개발 지식으로 통하여 아키텍쳐를 개선하고 RESTful API를 준수하여 개발을 진행해보았다.
주소 : g-menu.com


# 주요기능
- 대학교 식당 메뉴 웹 크롤링 및 DB 저장
- 대학교 및 식당 추가 기능
- 오늘의 메뉴 조회(비전타워, 교육대학원(아름관), 제3학생생활관 식당, 메디컬 캠퍼스 식당)
- 식당별 주간 메뉴 조회
  

# 기술스택
- Java 17
- Spring Boot 3.2.3
- Spring Data JPA
- QueryDSL
- MySQL
- Lombok
- Jsoup (웹 크롤링)
- Gradle
- CI/CD


# 아키텍쳐
![image](https://github.com/user-attachments/assets/cb8ecf61-17ce-4cbc-a772-a3b590678cf7)


# 프로젝트 구조
![image](https://github.com/user-attachments/assets/f4e16148-9ad6-4d71-a5b4-67f504c592f7)


# 크롤링 후 데이터 저장 과정
1. API 요청 또는 스케줄러에 의한 크롤링 시작
2. Jsoup 라이브러리를 사용하여 대학교 웹사이트에서 HTML 문서 가져오기
3. CSS 선택자를 통해 메뉴 테이블의 행 추출
4. 각 행에서 날짜, 요일, 식사 시간대, 메뉴 내용 파싱
5. 파싱된 데이터를 Menu 객체로 변환
6. JPA Repository를 통해 데이터베이스에 저장


# 버전1로 부터 변경된 사항
- 메디컬 캠퍼스 식당 추가
- 확장 가능하도록 코드를 전반적으로 수정
- MVC 패턴에서 Client-Server 구조로 변경
- 정적 웹사이트 형식으로 배포하여 서비스 이용 가능

