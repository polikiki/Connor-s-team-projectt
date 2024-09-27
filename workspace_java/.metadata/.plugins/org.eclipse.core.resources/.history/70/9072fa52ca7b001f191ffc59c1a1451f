<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<a href="emp0?cmd=join">회원가입</a>
	<section>
		<article>
			<table border="1">
				<caption style = "display:none;">회원 목록 표시 : display:none으로 감춰놓자</caption>
				<thead>
					<tr>
						<th>empno</th>
						<th>empname</th>
						<th>sal</th>
						<th>hiredate</th>
						<th>delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dto" items="${emplist}">
						<tr>
							<form id= "selectdata" action="emp0" method="post">
								<input type="hidden" name="empno" id="empno" value="${dto.empno}">
							<td>${dto.empno}</td>
							<td><a
								href="http://127.0.0.1:8080/proj6_myBatis/emp0?cmd=edit&empno=${dto.empno}">${dto.ename}</a></td>
							<td>${dto.sal}</td>
							<td>
								<fmt:formatDate value="${dto.hireDate}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/>
							</td>
							<td>
							<input type="submit" value="삭제" style="text-align: center;"></td>
							</form>
						</tr>
					</c:forEach>
				</tbody>
			</table>		
		</article>
	</section>
</main>
<footer>휴먼</footer>
</body>
</html>