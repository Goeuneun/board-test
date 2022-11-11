## Spring Board  기본 CRUD
페이지가 못생긴 이유는 따로 스타일 지정을 안했음 데헷~

<img width="541" alt="image" src="https://user-images.githubusercontent.com/101301507/200513670-ae98a454-db78-43c3-aba1-33342a9332aa.png">


스프링 환경설정하면서 발생한 주요 이슈

1. java.lang.java.lang.ExceptionInInitializerError
- 원인 : 이클립스 2021-12 버전의 패키지 다운로드로 설치하면 OpenJDK 17 버전이 내장됨 스프링은 11까지 지원
- 해결: 이클립스에서 사용하는 자바 버전 낮추기
처음에 이클립스를 구동하면 이 Open JDK 17 버전을 기반으로 작동하기 때문에 이클립스 설치경로\eclipse.ini 에서 -vm  부분을 수정
plugins/org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_17.0.1.v20211116-1657/jre/bin
해당 부분을 이렇게
C:/Program Files/Java/jdk-11.0.9/bin\javaw.exe

2. an error has occurred. see error log for more details. could not initialize class com.thoughtworks.xstream.converters.collections.propertiesconverter
이것도 jdk 버전 호환 문제였음 
spring version 과 java version 호환 문제


3. 톰캣 서버 구동시 나타난 에러
org.apache.catalina.core.StandardContext backgroundProcess 경고: 로더 [WebappLoader[StandardEngine[Catalina].StandardHost[localhost].StandardContext[/board]]]을(를) 백그라운드 프로세스로 처리 중 예외 발생 java.lang.IllegalStateException: java.io.IOException: java.lang.reflect.InvocationTargetException
- 원인:  JDK의 lib 폴더에 위치한 servlet-api.jar 파일이 6.0 버전에 맞는 구 버전이기 때문 
- 해결 : tomcat lib 폴더에 있는 servlet-api.jar 파일을 사용하고 있는 jdk 설치 폴더(C:\Program Files\Java\jdk1.7.0_65\lib) 에 붙여넣기

-------
#### 각 xml 파일 등 환경설정, 라이브러리 추가 해준 후 테스트 파일도 설계하여 테스팅 해봄

#### MySQL 설치 후 테이블 설계하고 생성 - connector j jar파일 jdk, jre 디렉터리에 복붙하고 버전 잘봐서 pom.xml 파일에 버전 맞춰서 dependency 태그 추가함  VO 클래스도 생성함
컨트롤러 - 매퍼 - jsp 순으로 만들어줬음..


----
### 회원가입, 중복체크 등 수정 및 삭제는 관리자나 글쓴이만 가능하게(id로 판별함)

<img width="398" alt="image" src="https://user-images.githubusercontent.com/101301507/200514027-9c1d1c62-fb8b-44cf-b75b-e7e2edd3feed.png">

------
파일업로드도 진행해볼 예정이다.

