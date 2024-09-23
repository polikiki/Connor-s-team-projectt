<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.Map, java.util.Set, java.util.Map.Entry" %>
<%@ page import="java.util.List" %>
<style>
    * {
        box-sizing: border-box;
    }

    .container {
        background-color: #F0F0E8;
        width: 100%;
        height: 100%;
        box-sizing: border-box;
    }

    body {
        margin: 0;
        padding: 0;
    }

    .top {
        margin: 0px 50px;
        color: #676767;
        font-size: 24px;
        font-weight: bold;
        height: 50px;
        display: flex;
        align-items: center;
    }

    .section {
        margin: 0 20px;
        height: 78vh;
        background-color: #E9E4DC;
        overflow: auto;
        padding: 30px;
    }

    .span,
    .spanMargin {
        font-size: 20px;
        display: inline-block;
        width: 100px;
    }

    .inputText {
        height: 30px;
        margin-left: 10px;
        border-radius: 5px;
    }

    .spanMargin {
        margin-left: 50px;
    }

    .select {
        height: 30px;
        border-radius: 5px;
        margin-left: 70px;
    }

    .select2 {
        height: 30px;
        border-radius: 5px;
        margin-left: 35px;
    }

    .div {
        margin-top: 10px;
    }

    .tableDiv {
        margin-top: 10px;
    }

    table {
        border-collapse: collapse;
        width: 100%;
    }

    th {
        height: 30px;
        text-align: center;
        background-color: #848484;
        color: white;
    }

    .tbody td {
        text-align: center;
        padding: 5px;
        border-bottom: 1px solid rgb(218, 218, 218);
        padding: 10px 0px;
    }

    .thead th:nth-child(1) {
        width: 5%;
    }

    .thead th:nth-child(2) {
        width: 5%;
    }

    .thead th:nth-child(3) {
        width: 15%;
    }

    .thead th:nth-child(4) {
        width: 15%;
    }

    .thead th:nth-child(5) {
        width: 10%;
    }

    .thead th:nth-child(6) {
        width: 50%;
    }

    .rowSpan {
        padding: 5px;
        background-color: #3F3B3B;
        border-radius: 5px;
        color: white;
        margin-left: 20px;
    }
    .btnDiv{
        margin:5px 20px;
        display: flex;
        justify-content: end;
    }
    .Btn_css {
        padding: 15px;
        background-color: #3F3B3B;
        color: white;
        border-radius: 5px;
        cursor: pointer;
        margin-right: 20px;
    }
</style>
<body>
<form action="ProcessServlet" method="post" >
    <div class="container">
        <div class="top">
            <img src="image/BOM.png" style="width: 30px;">
            <span>공정 등록</span>
        </div>
        <div class="section">
            <div style="margin-left: 150px;">
                <div>
                    <span class="span">공정코드</span><input id="processCode" name="processCode" class="inputText" type="text">
                    <span class="spanMargin">공정명</span><input id="processName" name="processName" class="inputText" type="text">
                </div>
                <div class="div">
                    <span class="span">공정분류</span><input id="processCategory" name="processCategory"class="inputText" type="text">
                    <span class="spanMargin">사용여부</span>
                    <select id="isUsed" name="isUsed" class="select">
                        <option>Y</option>
                        <option>N</option>
                    </select>
                </div>
                <div class="div">
                    <span class="span">사이클타임</span><input id="cycleTime" name="cycleTime" class="inputText" type="text">
                    <span class="spanMargin">제품코드</span>
   		 <select id="productCode" name="productCode" class="select2" onchange="updateProductDescription()">
                <option value="">-----</option>
                <% 
                    List<String> productCodes = (List<String>) request.getAttribute("productCodes");
                    if (productCodes != null) {
                        for (String code : productCodes) {
                %>
                    <option value="<%= code %>"><%= code %></option>
                <% 
                        }
                    }
                %>
            </select>               
                </div>
            </div>
            <div style="margin-top: 10px; display: flex; justify-content: end;">
                <span class="rowSpan" onclick="addRow()">행추가</span>
                <span class="rowSpan" onclick="deleteSelectedRows()">행삭제</span>
            </div>
            <div class="tableDiv">
                <table class="table">
                    <thead class="thead">
                        <tr>
                            <th></th>
                            <th></th>
                            <th>하위공정코드</th>
                            <th>공정명</th>
                            <th>이미지</th>
                            <th>공정내용</th>
                        </tr>
                    </thead>
                    <tbody class="tbody">
                        <tr>
                     		<td><input type="checkbox" class="delete-checkbox"></td>
                            <td></td>
                            <td><input id="underprocess" name="underprocess" type="text" style="width: 90%;"></td>
                            <td><input id="processname2" name="processname2" type="text" style="width: 90%;"></td>
                            <td><input id="image" name="image" type="file"></td>
                            <td><input id="productcontent" name="productcontent" type="text" style="width: 90%;text-align: center;" ></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="btnDiv">
            <span class="Btn_css" onclick="commitReg()">등록</span>
        </div>
    </div>
    </form>
</body>
<script>
let tbody = document.querySelector('.tbody');
let rowCount = tbody.querySelectorAll('tr').length + 1;
function commitReg() {
	let processCode2 = document.getElementById('processCode').value.trim();
	let processName2 = document.getElementById('processName').value.trim();
	let processCategory2 = document.getElementById('processCategory').value.trim();
	let isUsed2 = document.getElementById('isUsed').value.trim();
	let cycleTime2 = document.getElementById('cycleTime').value.trim();
	let productCode2 = document.getElementById('productCode').value.trim();

	if (!processCode2) {
	    alert("공정코드를 입력해 주세요.");
	    return; 
	}
	if (!processName2) {
	    alert("공정명을 입력해 주세요.");
	    return;
	}
	if (!processCategory2) {
	    alert("공정분류를 입력해 주세요.");
	    return; 
	}
	if (!isUsed2) {
	    alert("사용여부를 선택해 주세요.");
	    return; 
	}
	if (!cycleTime2) {
	    alert("사이클타임을 입력해 주세요.");
	    return; 
	}
	if (!productCode2) {
	    alert("제품코드를 선택해 주세요.");
	    return; 
	}
	
	let underprocess2 = document.getElementById('underprocess').value.trim();
	let processname3 = document.getElementById('processname2').value.trim();
	let productcontent2 = document.getElementById('productcontent').value.trim();
	if (!underprocess2) {
	    alert("하위공정코드를 입력해 주세요.");
	    return; 
	}
	if (!processname3) {
	    alert("공정명을 입력해 주세요.");
	    return; 
	}
	if (!productcontent2) {
	    alert("공정내용을 입력해 주세요.");
	    return; 
	}
	
    let processCode = document.getElementById('processCode').value;
    let processName = document.getElementById('processName').value;
    let processCategory = document.getElementById('processCategory').value;
    let isUsed = document.getElementById('isUsed').value;
    let cycleTime = document.getElementById('cycleTime').value;
    let productCode = document.getElementById('productCode').value;

    
    let form = document.createElement('form');
    form.method = 'POST';
    form.action = 'ProcessServlet';
    let fields = {
        processCode, processName, processCategory, isUsed, cycleTime, productCode
    };

    for (let key in fields) {
        let input = document.createElement('input');
        input.type = 'hidden';
        input.name = key;
        input.value = fields[key];
        form.appendChild(input);
    }

    let underProcessData = [];
    let processNameData = [];
    let productContentData = [];
    let imageData = [];
    let processCodeData = [];
	
  
    for (let i = 0; i < rowCount; i++) {
        processCodeData.push(processCode);
        imageData.push('이미지가없습니다');
    }

    document.querySelectorAll('input[name="underprocess"]').forEach(input => {
        underProcessData.push(input.value);
    });

    document.querySelectorAll('input[name="processname2"]').forEach(input => {
        processNameData.push(input.value);
    });

    document.querySelectorAll('input[name="productcontent"]').forEach(input => {
        productContentData.push(input.value);
    });

    
    console.log(underProcessData);
    let form2 = document.createElement('form');
    form2.method = 'POST';
    form2.action = 'ProcessServlet2';
    let fields2 = {
    	underProcessData, processNameData, imageData, productContentData, processCodeData
    };
	console.log(fields2);
    for (let key2 in fields2) {
        let input2 = document.createElement('input');
        input2.type = 'hidden';
        input2.name = key2;
        input2.value = fields2[key2];
        form2.appendChild(input2);
    }

    document.body.appendChild(form);
    form.submit();

    setTimeout(function() {
        document.body.appendChild(form2);
        form2.submit();
    }, 500);

    alert("등록완료");
}
    function addRow() {
    
		 let tbody = document.querySelector('.tbody');

	     let newRow = document.createElement('tr');
         newRow.innerHTML = `
            <td><input type="checkbox" class="delete-checkbox"></td>
            <td></td>
            <td><input name="underprocess" type="text" style="width: 90%;"></td>
            <td><input name="processname2" type="text" style="width: 90%;"></td>
            <td><input name="image" type="file"></td>
            <td><input name="productcontent" type="text" style="width: 90%; text-align: center;"></td>`;
            rowCount++;
        tbody.appendChild(newRow);
  
	}
    
    function deleteSelectedRows() { 
        let checkboxes = document.querySelectorAll('.delete-checkbox');
        checkboxes.forEach(checkbox => {
            if (checkbox.checked) {
                checkbox.closest('tr').remove(); 
                rowCount--;
            }
        });
        resetRowNumbers();
    }

    function resetRowNumbers() {
    	let rows = document.querySelectorAll('.tbody tr'); 
    	rows.forEach(row => {
        let cells = row.querySelectorAll('td');
     	cells[1].textContent = rowCount++; 
    	});
	}
    function updateProductDescription() {
        const selectElement = document.getElementById("productCode");
        const selectedCode = selectElement.value;
    }

    

</script>