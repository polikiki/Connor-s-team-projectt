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
<header>
	Logo
	<nav>emp > 회원 목록</nav>
</header>
<main>
	<a href="member?cmd=join">회원가입</a>
	<section>
		<article>
			<form id="frm" method="get" action="member">
			<table border="1">
				<caption style = "display:none;">회원 목록 표시 : display:none으로 감춰놓자</caption>
				<thead>
					<tr>					
						<th>select</th>
						<th id="empno">empno </th>
						<th>ename</th>
						<th>job</th>
						<th>sal</th>
						<th>hiredate</th>
						<th>delete</th>
					</tr>
				</thead>
				<tbody id="list">
					
				</tbody>
			</table>
			</form>		
		</article>
	</section>
</main>
<footer>휴먼</footer>

<script>
	window.addEventListener("load",function(){
		
		
		const url = "listEmp"
		const xhr = new XMLHttpRequest();
		xhr.open("get",url);
		xhr.send();
		
		xhr.onload = function(){
// 			console.log(xhr.responseText)  
			
			
// 			try{
// 					const empList = JSON.parse(xhr.responseText);
// 					let html = "";
// 			for(let i=0; i<empList.length; i++){
// 					console.log(empList[i].ename)


// 					html += '<tr>';
// 					html += '	<td>';
// 					html += '		<input type="checkbox" name="check" value="${dto.empno }">';
// 					html += '	</td>';
// 					html += '	<td>'+ empList[i].empno +'</td>';
// 					html += '	<td><a href="emp0?cmd=detail&empno=${dto.empno }">'+ empList[i].ename +'</a></td>';
// 					html += '	<td>'+ empList[i].job +'</td>';
// 					html += '	<td>'+ empList[i].sal +'</td>';
// 					html += '	<td>'+ empList[i].hireDate+'</td>';
// 					html += '</tr>';
			
				html += `
					<tr>
						<td>
							<input type="checkbox" name="check" value="${dto.empno }">
						</td>
						<td>\${empList[i].empno}</td>
						<td><a href="emp0?cmd=detail&empno=${dto.empno }">\${empList[i].ename }</a></td>
						<td>${dto.job }</td>
						<td>${dto.sal }</td>
						<td>
							<fmt:formatDate value="${dto.hireDate }" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초" />
						</td>
					</tr>
				`;
				
				}
				
				document.querySelector("#list").innerHTML = html;
				
			}catch(e){
				console.log("ERROR : url :", url, e);
			}
		}
		
	})
</script>

</body>
</html>