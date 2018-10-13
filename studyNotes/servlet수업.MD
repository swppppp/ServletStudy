# servlet 수업  
- get, post방식에 따른 인코딩  
> - get방식은 tomcat서버에서 인코딩해줌(tomcat\\conf\\server.xml에 인코딩해주는게 있음)  
> - post방식은 직접 해줘야함. request.setCharset("인코딩방식..(utf-8)")  

## 디스패치기술
DispatchServlet에서 실습  
- RequestDispatcher: 요청을 다른 자원으로 포워드 || 실행결과를 현재서블릿으로 포함  
- request의 getRequestDispatcher메소드 사용, 리퀘스트디스패처객체 얻어옴  
- requestDispatcher의 주요 메소드
> ### redirect  
> - url자체가 바뀜  
> - 상태코드 301(SC_MOVED_PERMANANTLY)로(setStatus) 헤더 location값 지정(setHeader)해줌
> ### forward, include    
> - 서버에서 서버로(url안바뀜. url변화 없이 reponse된 내용이 바뀜)  
> - include메소드 호출한 서블릿에 포함됨.  
> - url만보고는 forward인지 include인지 모름  


## 서블릿 초기 설정정보 읽기(ServletConfig)    
------------------------------------
> ### Collection API에서 properties!!!!  
> CollectionStudy의 PropertiesExample
> - 저거 이용할땐(설정) 확장자를 무조건 *.properties 로 해줘야함  
> - properties파일에서 #은 주석  
> - key = value 형태로저장(like header)  
> - 초기실행때(static 초기화 블록에서 주로 실행) 읽어옴  
> - 한글못씀..(인코딩해서 16진수(유니코드)로 쓸수는있긔..)  
--------------------------------------  
- web.xml에 등록된 초기 설정 정보  
- servlet은 설정정보를 web.xml에 저장을 함  
- properties로 저장하기 번거롭기때문에 서블릿은 web.xml에 저장  
- 다음과 같은 형식으로 저장  
```  
<init-param>
  <param-name></param-name>
  <param-value></param-value>
</init-param>
```  
- ex)파일저장같은거 할때도 path값을 지정해주는거..(MIMEExample2.java에서실습한거)  

## ServletContext(IOC. Inversion Of Control. 제어반전)  
- 서블릿 컨테이너안에 트리구조로 하나 생성되어있음  
- 서블릿 컨테이너 환경정보를 제공  
- 컨테이너에 의해 관리되는 서블릿들의 데이터공유-->가장중요!!(OS의 registry와 비슷)    
- 서블릿 컨테이너 정보, 관리되는 특정서블릿정보 등등.. 서블릿에있어서 가장 막강함  
- 데이터 공유 방법 중 가장 공유범위가 넓음  
- getContextPath----> 현재 was등록된 이름 get하는거   
- getInitParameter(String):String---> 모든 서블릿이 공유(servletConfig에서 한거는 해당서블릿에서만 사용됨)  

## 클라이언트 상태정보 유지(HttpSession)  
- 특정 브라우저(접속한 클라이언트) 하나당 정보를 저장하는 객체  
- servletContext랑 구조가 똑같음  
- new tab은 같은 session  
- request.getSession 파라미터로 boolean줄때..세션이 없으면 null 반환(오버로딩되어있음)  

## 쿠키(Cookie)  
- 세션정보가 많아지면 서버가 과부하. 세션정보를 클라이언트쪽에 넘겨버리는 개념  
- 클라이언트의 메모리에 본인상태정보를 일정형식의 텍스트 데이터(쿠키)로 저장  
- 요청,응답 메세지의 헤더에 상태정보값을 저장해놈  
- 클라이언트하나당 쿠키 300개 가능, 각 쿠키는 4kb까지 저장가능  
- 응답쿠키구조    
> Set-Cookie: name=value; expires=date; path=path; domain=domain  
- 요청쿠키구조  
> Cookie: name1=value1; name2=value2  
- 쿠키에는 한글사용 못함  
> 쿠키생성서블릿: URLEncoder.encode(cookieName, "utf-8")  
> 쿠키사용서블릿: URLDecoder.decode(cookieName, "utf-8")  











## DB연결  
DatabaseServlet에서 실습함..   
->구한말시대..ㅠ jdbc연동  
