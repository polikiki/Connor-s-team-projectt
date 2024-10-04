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
	<a href="join">회원가입</a>
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

	window.addEventListener("load", function(){
		getList()
	})

	// cb : callback 
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
	
	function getList(){
		ajax("listEmp", null, drawList) //"get" 어차피 아니면 get으로 가도록 설계했으니까 생략가능 get이 아닐때는 delete등을 써서 활용가능
	}
	
	function drawList(text) {
		try{
			const empList = JSON.parse(text);
			
			let html = "";
			
			if(empList.length == 0){
				html = "<tr><td colspan='7'>자료가 없습니다</td></tr>"
			} else {
				for(let i=0; i<empList.length; i++){
					console.log(empList[i])
					const hiredate = new Date(empList[i].hireDate)
					const y = hiredate.getFullYear()
					let m = hiredate.getMonth() + 1
					if(m < 10){
						m = "0" + m
					}
					const d = hiredate.getDate()
					
					html += `
							<tr>
								<td>
									<input type="checkbox" name="check" value="\${empList[i].empno }">
								</td>
								<td>\${empList[i].empno}</td>
								<td><a href="emp0?cmd=detail&empno=\${empList[i].empno }">\${empList[i].ename }</a></td>
								<td>\${empList[i].job}</td>
								<td>\${empList[i].sal}</td>
								<td>
									\${y}년 \${m}월 \${d}일
								</td>
								<td>
									<button type="button" data-empno="\${empList[i].empno }" class="btnDel" id="btn_\${empList[i].empno }">삭제</button>
								</td>
							</tr>
						`;
					
				}
					
			}
			document.querySelector("#list").innerHTML = html;
			
			bind()
		
			
			
		}catch(e){
			console.log("ERROR : drawList", e);
		}
	}
	
	function bind(){
			const delBtnList = document.querySelectorAll(".btnDel")
			for(let btn of delBtnList){
				btn.addEventListener("click", function(event){
// 					console.log(this)
// 					console.log(event.target)
				
				/* const id =	event.target.getAttribute("id")
				// btn_7788 : substring, split... */
				const empno = event.target.getAttribute("data-empno")
				console.log("empno",empno)
			
				const url2 = "deleteEmp"
				const data = {
						"empno": empno
				}
				ajax("deleteEmp", data, function(result){
					if(result != 0){
						getList()
					} else {
						alert("삭제에 실패했습니다.")
					}
				}, "delete")
				
			})
		}
			
			
	}

/*
	window.addEventListener("load",function(){
		
		
		let url = "listEmp"
		const xhr = new XMLHttpRequest();
		xhr.open("get",url);
		xhr.send();
		
		xhr.onload = function(){

			console.log(xhr.responseText)  
		
			try{
					const empList = JSON.parse(xhr.responseText);
					let html = "";
			for(let i=0; i<empList.length; i++){
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
				
				const hiredate = new Date(empList[i].hireDate)
				const y = hiredate.getFullYear()
				let m = hiredate.getMonth() + 1
				if(m <10){
					m= "0"+ m;
				}
				const d = hiredate.getDate()
				
				html += `
					<tr>
						<td>
							<input type="checkbox" name="check" value="\${empList[i].empno}">
						</td>
						<td>\${empList[i].empno}</td>
						<td><a href="emp0?cmd=detail&empno=\${empList[i].empno }">\${empList[i].ename }</a></td>
						<td>\${empList[i].job }</td>
						<td>\${empList[i].sal }</td>
						<td>
							\${y}년 \${m}월 \${d}일
						</td>
						<td>
							<button type="button" data-empno="\${empList[i].empno}" class="btnDel" id="btn_\${empList[i].empno}" >삭제</button>
						</td>
					</tr>
				`;
				
				}
				
				document.querySelector("#list").innerHTML = html;
				
// 				const delBtnList = document.querySelectorAll("[id^=btn]")
				const delBtnList = document.querySelectorAll(".btnDel")
				for(let btn of delBtnList){
					btn.addEventListener("click", function(event){
						console.log(this)
						console.log(event.target)
						
					const id =	event.target.getAttribute("id")
					// btn_7788 : substring, split...
					const empno = event.target.getAttribute("data-empno")
					console.log("empno",empno)
					
					const url2 = "deleteEmp"
					const data = {
							"empno": empno
					}
					
					const xhr2 = new XMLHttpRequest();
					xhr.open("delete",url2);
					xhr.setRequestHeader("Content-Type","application/json");
// 					const strData = JSON.stringify(data);
					xhr.send(JSON.stringify(data));
					
					xhr2.onload = function(){
						console.log( xhr2.responseText )
						
						try{
							let result = JSON.parse(xhr2.responseText)
							console.log(result)
						}catch(e){
							console.log("json아님",e)
						}     
					} 
						
					})
				}
								
			}catch(e){
				console.log("ERROR : url :", url, e);
			}
		}
		
	})
*/
</script>

</body>
</html>