<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <c:if test="${cmd == "detail"}"> --%>
<!-- <h1>회원상세</h1> -->
<%-- </c:if> --%>

<c:choose>
	<c:when test='${cmd == "detail"}'>
		<h1>회원상세</h1>
	</c:when>
	<c:otherwise>
		<h1>회원가입</h1>
	</c:otherwise>
</c:choose>

<h1>회원가입</h1>

	empno : 
		<c:choose>
		<c:when test='${cmd == "detail"}'>
			${empDTO.empno}
		</c:when>
		<c:when test='${cmd == "edit"}'>
			<input type="text" name="empno" class="empno" value="${empDTO.empno}">
		</c:when>
		<c:otherwise>
			<input type="text" name="empno" class="empno"><br>
		</c:otherwise>
	</c:choose>
	<br>
	ename :
		<c:choose>
		<c:when test='${cmd == "detail"}'>
			${empDTO.ename}
		</c:when>
		<c:when test='${cmd == "edit"}'>
			<input type="text" name="ename" class="ename" value="${empDTO.ename}">
		</c:when>
		<c:otherwise>
			<input type="text" name="ename" class="ename"><br>
		</c:otherwise>
</c:choose>
	<br>
	hireDate :
		<c:choose>
		<c:when test='${cmd == "detail"}'>
			${empDTO.hireDate}
		</c:when>
		<c:when test='${cmd == "edit"}'>
			<input type="date" name="hiredate" class="hiredate" value="${empDTO.hireDate}" >
		</c:when>
		<c:otherwise>
			<input type="date" name="hiredate" class="hiredate"><br>
		</c:otherwise> 
</c:choose>
	<br>
	<c:choose>
		<c:when test='${cmd == "detail"}'>
			<a href="emp0?cmd=edit&empno=${empDTO.empno}">수정하기</a>
		</c:when>
		<c:when test='${cmd == "edit"}'>
			<a href="emp0?cmd=detail&empno=${empDTO.empno}">취소</a>
			
			<input type="hidden" name="cmd" value="edit">
			<input type="hidden" name="empno" value="${empDTO.empno}">
			<input type="submit" value="수정하기">
		</c:when>
		<c:otherwise>
			<button type="button" class="btnInsert">가입하기</button><br>
		</c:otherwise> 
</c:choose>

<script>

function ajax(url, param, cb, method){
	// javascript에서 false의 의미는 null, undefined, 0 
	// true는 false가 아닌것
	if(!method) method = "get";
		
	const xhr = new XMLHttpRequest();
	xhr.open(method,url);
	xhr.setRequestHeader("Content-Type","application/json");
	xhr.send(JSON.stringify(param));
	
	if(typeof cb == "function"){
		xhr.onload = function(){
			cb(xhr.responseText)
		}	
	}
}

function insert(){
	console.log(1234)
	const insertBtnList = document.querySelector(".btnInsert")
		insertBtnList.addEventListener("click", function(){

		const empno = document.querySelector(".empno").value;
		const ename = document.querySelector(".ename").value;
		const hiredate = document.querySelector(".hiredate").value;
		console.log("empno",empno)
		console.log("ename",ename)
		console.log("hiredate",hiredate)
	
		const url2 = "join"
		const data = {
				"empno": empno,
				"ename": ename,
				"hiredate": hiredate
		}
		ajax("join", data, function(result){
			if(result != 0){
				alert("인서트에 성공했습니다.")
			} else {
				alert("인서트에 실패했습니다.")
			}
		}, "post")
		
	})
		
}
	document.addEventListener("DOMContentLoaded", function() {
	    insert();
	});
</script>
</body>

</html>