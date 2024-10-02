<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

	// window.onload = function() {}
	window.addEventListener("load", function(){
	
		const btn = document.querySelector("#btn")
		btn.addEventListener("click", function(){
		
			console.log("click!!!!")
			
			const xhr = new XMLHttpRequest();
			
// 			const url = "/rest/ajax/list";
			const url = "/human/test1";
			
			const data = {
				"ename" : "이름",
				sal : 3200,
			}
			xhr.open("post", url)
			xhr.setRequestHeader("Content-Type","application/json");
			
			const strData = JSON.stringify(data);
			console.log(data)		// 객체 그자체
			console.log(''+data)	// 네트워크는 객체를 전달할 수 없다
			console.log(strData)	// 그래서 String으로 변형
			
			xhr.send(strData)
			
			xhr.onload = function(){
				console.log( xhr.responseText )
				
				try{
					let result = JSON.parse(xhr.responseText)
					console.log(result)
				}catch(e){
					console.log("json아님",e)
				}     
			} 
		})
	})
</script>

</head>
<body>

<button id="btn">ajax 실행</button>

</body>
</html>