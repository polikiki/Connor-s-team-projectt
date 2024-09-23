<!-- 디렉티브 태그 -->
<!-- import는 여러개 할 수 있다 -->
<!-- @ page 안에 넣어도 되고@ page를 하나더 만들어서 import 할 수 있다 -->
<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
    %>
<%@ page import ="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 스크립틀릿 -->
<%
// 여기는 java 땅입니다.
System.out.println("test");
%>
<table border="1">


	<% for(int i =0; i<5; i++){  %> 
<!-- 	위 아래는 자바 영역 가운데는 html 영역이므로 이렇게 쓸 수 밖에 없다 (html영역을 지키기 위해서) -->
	<tr>
		<td>제목</td>
		<td>내용</td>
	</tr>
<% } %>	

</table>

<%
	out.println("<h1>hello</h1>");
%>

<%
for(int i =0; i<5; i++){
		out.println ( i + "번째<br>");
}
%>

<%
	int a = 10;
	request.setAttribute("b", 123);
%>
el은 scope영역과 파라메터를 가져올 수 있다<br>
el은 java 변수만 가져올 수는 없다<br>
a의 값은 : \${a } : ${a }<br>
<!-- 표현식 -->
<%= a %><br>
<!-- 위의 줄의 코드와 동일 -->
<%
out.print(a);
%>
<hr>
<%
	out.print(request.getAttribute("b"));
%><br>
<%= request.getAttribute("b") %><br>
${b }<br>
<%
	java.util.List list = new ArrayList();
%>
<hr>
<%@ include file = "header.jsp" %>

<!-- 자바로 바뀐 파일을 살펴보면 !가 붙으면 먼저 처리가 되어서 위로 올라가게 된다 -->
<%!	
	// 선언문
	// 필드
	String str = "글씨";
	// 메소드 선언
	String gerStr(){
		return this.str;	
	}
%>

<jsp:include page = "header.jsp">
	<jsp:param name ="id" value="idid"></jsp:param> 
</jsp:include>

<hr>
<a href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=검색" target="_blank">네이버 검색</a>
<br>
<a href="http://localhost:8080/_proj3_todo/jstl.jsp">jstl페이지로 이동</a>
<br>
<a href="/proj3_todo/jstl.jsp">jstl페이지로 이동</a>
<br>

<h1>
	c:url 사용하는 이유
</h1>
1. 영어나 숫자 외 한글이나 특수무자를 encode 해줌<br>
2. context path 자동 추가(/_proj3_todo)<br>
3. 쿠키 금지일때 ;JSESSIONID= 를 자동으로 붙여줌 <br>

<c:url var="url1" value="/jstl.jsp">
	<c:param name="a" value="한글" />
</c:url>
<a href="${url1 }">jstl로 이동</a>
<hr>
param.name : ${param.name }<br>
c:out : <c:out value="${param.name }"/><br>
c:out : 특수문자를 치환해서 문자 그 자체로 출력되게 해줌
<!--  
< : &lt;
> : &gt;
& : &amp;
""공백 : &nbsp;
-->
</body>
</html>