<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>    

<%@ page import="java.util.List" %>
<%@ page import="emp2.dto.EmpDTO" %>

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
	
<table border=1>
	<tr>
		<th>rnum</th>
		<th>empno</th>
		<th>ename</th>
		<th>job</th>	
		<th>hireDate</th>	
	</tr>
	
	<c:if test="${not empty map.list }">
		<c:forEach var="emp" items="${map.list }">
			<tr>
				<td>${emp.rnum}</td>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>
				<td>${emp.job}</td>
				<td>${emp.hireDate}</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty map.list }">
		<tr>
			<td colspan="5">자료가 없습니다</td>
		</tr>	
	</c:if>
	<%
	
	Map map = (Map)request.getAttribute("map");
	List<EmpDTO> list = (List)map.get("list"); 
	
// 	for(int i=0; i<list.size(); i++){
// 		EmpDTO dto = (EmpDTO)list.get(i);
		
// 		int empno = dto.getEmpno();
// 		out.print(empno + ",");
// 	}
	
	for( EmpDTO dto : list ){
		int empno = dto.getEmpno();
		out.print(empno + ",");
	}
	%>
		
</table>
<%
	System.out.println("1"); 
	int totalCount = (int)map.get("totalCount");
	System.out.println("2"); 
	String str_countPerPage = (String)request.getAttribute("countPerPage");
	int countPerPage = Integer.parseInt(str_countPerPage);
	System.out.println("3");
	String str_pageNo = (String)request.getAttribute("page");
	int pageNo = Integer.parseInt(str_pageNo);
	System.out.println("4");
	int lastPage =(int)Math.ceil((double)totalCount / countPerPage); // 전체개수 / 한페이당 개수를 하고 올림이 되도록 형변환을 해줌 (마지막 페이지가 나오게)
	
	// 한번에 보여줄 페이지의 개수
	int countPerSection = 3;
	// 페이지 섹션 위치
	int position = (int)Math.ceil((double)pageNo/ countPerSection);
	int sec_first = ((position-1) * countPerSection) + 1 ;
	int sec_last = position * countPerSection;
	if(sec_last>lastPage){
		sec_last = lastPage;
	}
%>
<c:set var = "lastPage2" value = "<%= lastPage %>" scope="page"/>
<c:if test ="<%=sec_first == 1 %>">
	[이전]
</c:if>
 
<c:if test ="<%=sec_first != 1 %>">
	[<a href ="page?page=<%=sec_first-1 %>">이전</a>]
</c:if>

<%-- <c:forEach var = "i" begin="1" end="${lastPage2}"> --%>
<c:forEach var="i" begin="<%=sec_first %>" end="<%= sec_last %>">
	<c:choose>
		<c:when test="${page != i }">
			[<a href ="page?page=${i}">${i}</a> ]
		</c:when>
		<c:otherwise>
			[<a href ="page?page=${i}"><strong>${i}</strong></a> ]
		</c:otherwise>
	</c:choose>
</c:forEach>

<c:if test ="<%=sec_last == lastPage %>">
	[다음]
</c:if>

<c:if test ="<%=sec_last != lastPage %>">
	[<a href ="page?page=<%=sec_last+1 %>">다음</a>]
</c:if>


</body>
</html>