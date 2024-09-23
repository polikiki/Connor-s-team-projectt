<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 100% border-collapse: collapse;
}

table, th, td {
	border: 1px solid black;
}

th, td {
	padding: 8px;
	text-allignL
	left;
}
</style>

</head>
<body>
	<h1>List Page</h1>

	${ list1 }
	<hr>
	${ list1[0] }
	<hr>
	${ list1[0].title }
	<hr>
	${ list1[0]["title"] }
	<hr>
	123${null }456
	<hr>
	<table>
		<thead>
			<tr>
				<th>Select</th>
				<th>Title</th>
				<th>Due Date</th>
			<tr>
		</thead>
		<tobody>
		<c:forEach var="todo" items="${list1 }">
			<tr>
				<td> <input type="checkbox" name="checkbox" value="${todo.finished}" <c:if test = "${todo.finished == true}">checked="checked"</c:if>>
				</td>
				<td><a href= "/proj3_todo/todo/read?tno=${todo.tno}">${todo.title}</a></td>
				<td>${todo.dueDate}</td>
			</tr>
		</c:forEach>
		</tobody>
	</table>
	<input type="submit" name="submit" value="submit">
	<a href = "register">글쓰기</a>
</body>
</html>