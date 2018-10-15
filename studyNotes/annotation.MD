servlet3.1버전부터 servlet등록 어노테이션으로 가능!  

# 사용자정의 annotation  
```  
// 타겟과 리텐션 필수!  
@Target : 애노테이션을 적용할 대상

값은 enum타입 ElementType의 상수값 사용
ElementType.CONSTRUCTOR : 생성자에 적용
ElementType.FIELD : 필드에 적용 
ElementType.LOCAL_VARIABLE : 지역변수에 적용 
ElementType.METHOD : 메서드에 적용
ElementType.PACKAGE : 패키지에 적용
ElementType.PARAMETER : 매개변수에 적용
ElementType.TYPE : class, interface, enum 에 적용

@Retention : 해당 애노테이션의 적용scope 지정

값은 enum타입 RetentionType의 상수값 사용
RetentionType.SOURCE : 소스파일에만 적용됨. 컴파일부터는 적용되지않음
RetentionType.CLASS : 클래스 파일에 적용됨. 실행시에는 사용하지 못함 
RetentionType.RUNTIME : 소스파일과 클래스파일, 실행시 적용   
```  
- annotation 예제는 oopstudy플젝에 있긔  

