<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${dto}<br>
dto.tno : ${dto.tno }<br>
dto.title ${dto.title }<br>
dto.dueDate : ${dto.dueDate }<br>
dto.finished : ${dto.finished }<br>

<a href="/proj3_todo/todo/list">목록으로</a>
<a href= "/proj3_todo/todo/modify?tno=${dto.tno}">수정</a> 

<form method ="post" action = "remove">
	<input type = "hidden" name = "tno" value ="${dto.tno}">
	<input type = "submit" value ="삭제">
</form>
</body>
</html>