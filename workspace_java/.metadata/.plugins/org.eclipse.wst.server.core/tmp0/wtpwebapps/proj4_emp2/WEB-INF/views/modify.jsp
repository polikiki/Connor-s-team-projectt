<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a herf="list">목록으로</a><br>

<form method = "post" action="modify">
	
	<form method = "post" action="join">
	empno : <input type = "text" name ="empno" value= "${list.empno}"><br>
	ename : <input type = "text" name ="ename" value= "${list.ename}"><br>
	job : <input type = "text" name ="job" value= "${list.job}"><br>
	mgr : <input type = "text" name ="mgr" value= "${list.mgr}"><br>
	hireDate : <input type = "text" name ="hireDate" value= "${list.hireDate}"><br>
	sal : <input type = "text" name ="sal" value= "${list.sal}"><br>
	comm : <input type = "text" name ="comm" value= "${list.comm}"><br>
	deptno : <input type = "text" name ="deptno" value= "${list.deptno}"><br>
	<input type ="submit" value ="수정">
	
</form>

</body>
</html>