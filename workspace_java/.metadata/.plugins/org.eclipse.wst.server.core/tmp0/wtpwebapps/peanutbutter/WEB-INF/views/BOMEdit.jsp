<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BOM 수정(부품)</title>
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
        color: #676767;
        font-size: 24px;
        font-weight: bold;
        height: 15vh;
    }

    .title {
        padding-top: 30px;
        margin-left: 100px;
    }

    .title img {
        vertical-align: middle;
    }

    .title span {
        vertical-align: middle;
    }

    .section {
        margin: 0 100px;
        height: 70vh;
        display: flex;
    }

    .sideBarDiv {
        background-color: #D7D7D7;
        width: 200px;
        padding: 10px;
    }

    .tableDiv {
        flex: 1;
        background-color: white;
    }

    .table {
        border-collapse: collapse;
        width: 100%;
    }

    th {
        background-color: #b6b6b6;
        border-right: 1px solid white;
    }

    td {
        text-align: center;
    }

    .tbody tr {
        border-bottom: 1px solid lightgray;
    }

    tr th,
    tr td {
        padding: 5px 0px;
    }
    .thead th:nth-child(1) {
        width: 5%;
    }
    .thead th:nth-child(2) {
        width: 10%;
    }
    .thead th:nth-child(3) {
        width: 15%;
    }
    .thead th:nth-child(4) {
        width: 10%;
    }
    .thead th:nth-child(5) {
        width: 10%;
    }
    .thead th:nth-child(6) {
        width: 5%;
    }
    .thead th:nth-child(7) {
        width: 10%;
    }
    .thead th:nth-child(8) {
        width: 10%;
    }

    .Btn_css {
        display: inline-block;
        padding: 10px;
        background-color: #3F3B3B;
        color: white;
        border-radius: 5px;
        cursor: pointer;
        margin-top: 5px;
    }

    input[type="text"] {
        text-align: center;
    }

    .mainMenu {
        font-weight: bold;
        color: gray;
    }

    .tableTopDiv {
        height: 50px;
        padding: 0px 10px;
        background-color: white;
    }

    .regBtn {
        margin: 0 100px;
        text-align: right;
        margin-top: 30px;
    }

    .inputText {
        height: 25px;
    }
</style>
</head>
<body>
 <div class="container">
    <div class="top">
        <div class="title">
            <img src="image/BOM.png" style="width: 30px;">
            <span>BOM 수정(부품)</span>
        </div>
    </div>
    <div class="section">
        <div class="tableDiv">
            <div class="tableTopDiv">
                <span style="font-weight: bold;">제품목록</span>
                <select class="제품select">
                    <option value="-----">-----</option>
                </select>
                <span style="margin-left: 20px; font-weight: bold;"></span>
                <span id="제품코드" style="display:inline-block; width: 10px;"></span>
                <span class="Btn_css" style="margin-left: 50px;" onclick="addRow()">행 추가</span>
                <span class="Btn_css" style="margin-left: 20px;" onclick="deleteSelectedRow()">행 삭제</span>
            </div>
            <form id="bomForm" action="EditBOMServlet" method="post">
                <input type="hidden" name="productList" id="productList">
                <table class="table">
                    <thead>
                        <tr>
                            <th></th>
                            <th>부품명</th>
                            <th>모델명</th>
                            <th>부품코드</th>
                            <th>규격</th>
                            <th>단위</th>
                            <th>수량</th>
                            <th>거래처</th>
                        </tr>
                    </thead>

                    <tbody class="tbody">
                        <tr>
                            <td><input type="checkbox" class="delete-checkbox"></td>
                            <td>
                                <select name="partName[]" class="select1" onchange="updateOption(event)">
                                </select>
                            </td>
                            <td>
                                <select name="modelName[]" class="select2" onchange="updateCodePrice(event)">
                                    <option value="-----">-----</option>
                                </select>
                            </td>
                            <td class="code"></td>
                            <td class="size"></td>
                            <td class="unit"></td>
                            <td><input type="text" name="quantity[]" style="width: 30%;"></td>
                            <td><input type="text" name="company[]"></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>   
    </div>
    	<div class="regBtn">
     		<span class="Btn_css" onclick="submitForm()">BOM 공정 수정</span>
    	</div>   	
</div>
</body>
<script>
function addRow() { 
    let tbody = document.querySelector('.tbody');
    let newRow = document.createElement('tr');
    newRow.innerHTML = `
        <td><input type="checkbox" class="delete-checkbox"></td>
        <td>
            <select name="partName[]" class="select1" onchange="updateOption(event)">
                <option value="-----">-----</option>
            </select>
        </td>
        <td>
            <select name="modelName[]" class="select2" onchange="updateCodePrice(event)">
                <option value="-----">-----</option>
            </select>
        </td>
        <td class="code"></td>
        <td class="size"></td>
        <td class="unit"></td>
        <td><input type="text" name="quantity[]" style="width: 30%;"></td>
        <td><input type="text" name="company[]"></td>
    `;
    tbody.appendChild(newRow);
    populatePartDropdowns(newRow);
}

function deleteSelectedRow() { 
    let checkboxes = document.querySelectorAll('.delete-checkbox');
    checkboxes.forEach(checkbox => {
        if (checkbox.checked) {
            checkbox.closest('tr').remove(); 
        }
    });
}

function populatePartDropdowns(row) {
    const select1 = row.querySelector('.select1');
    fetch('GetPartsData')
        .then(response => response.text())
        .then(data => {
            select1.innerHTML = data;
        })
        .catch(error => console.error('Error fetching part data:', error));

    const select2 = row.querySelector('.select2');
    select1.addEventListener('change', function(event) {
        updateOption(event);
    });
    select2.addEventListener('change', function(event) {
        updateCodePrice(event);
    });
}

function updateOption(event) {
    let select1 = event.target;
    let select2 = select1.closest('tr').querySelector('.select2');
    let selectedComponent = select1.value;

    fetch('GetModelData?part_name=' + encodeURIComponent(selectedComponent))
        .then(response => response.text())
        .then(data => {
            select2.innerHTML = data;
        })
        .catch(error => console.error('Error fetching model data:', error));
}

function updateCodePrice(event) {
    let select2 = event.target;
    let selectedOption = select2.value;

    fetch('GetCodeSizeData?model_name=' + encodeURIComponent(selectedOption))
        .then(response => response.text())
        .then(data => {
            console.log('Server response:', data); // 응답 로그 추가
            const [code, size, unit] = data.split('|'); // 서버 응답을 코드, 사이즈, 단위로 분리
            const codeCell = select2.closest('tr').querySelector('.code');
            const sizeCell = select2.closest('tr').querySelector('.size');
            const unitCell = select2.closest('tr').querySelector('.unit');

            codeCell.textContent = code;
            sizeCell.textContent = size;
            unitCell.textContent = unit; // 단위 필드 업데이트
        })
        .catch(error => console.error('Error fetching code, size, and unit data:', error));
}
document.addEventListener("DOMContentLoaded", function() {
    fetch('BOMGET')
        .then(response => response.text())
        .then(data => {
            populateProductList(data);
        })
        .catch(error => console.error('Error fetching product data:', error));
    
    document.querySelectorAll('.select1').forEach(select => {
        fetch('GetPartsData')
            .then(response => response.text())
            .then(data => {
                select.innerHTML = data;
            })
            .catch(error => console.error('Error fetching part data:', error));
    });
});

function populateProductList(productNamesHTML) {
    const productNameSelect = document.querySelector('.제품select');
    productNameSelect.innerHTML = productNamesHTML;
}

function submitForm() {
    let form = document.getElementById('bomForm');
    let productListSelect = document.querySelector('.제품select');
    let productListValue = productListSelect.value;
    
    // 제품 목록을 숨겨진 필드에 저장
    document.getElementById('productList').value = productListValue;
    
    // 모든 행의 코드, 사이즈, 단위 값을 숨겨진 필드에 추가
    let tbody = document.querySelector('.tbody');
    let rows = tbody.querySelectorAll('tr');

    rows.forEach((row, index) => {
        let code = row.querySelector('.code').textContent.trim();
        let size = row.querySelector('.size').textContent.trim();
        let unit = row.querySelector('.unit').textContent.trim();

        // 코드 값 숨겨진 필드 추가
        let codeInput = document.createElement('input');
        codeInput.type = 'hidden';
        codeInput.name = `code[${index}]`;
        codeInput.value = code;
        form.appendChild(codeInput);

        // 사이즈 값 숨겨진 필드 추가
        let sizeInput = document.createElement('input');
        sizeInput.type = 'hidden';
        sizeInput.name = `size[${index}]`;
        sizeInput.value = size;
        form.appendChild(sizeInput);

        // 단위 값 숨겨진 필드 추가
        let unitInput = document.createElement('input');
        unitInput.type = 'hidden';
        unitInput.name = `unit[${index}]`;
        unitInput.value = unit;
        form.appendChild(unitInput);
    });

    // 폼을 제출하기 전에 모든 선택된 값들을 확인할 수 있습니다.
    let selects = document.querySelectorAll('.select1, .select2');
    selects.forEach(select => {
        console.log(select.name, select.value);  // 선택된 값 확인용
    });

    form.submit();  // 폼 제출
}
document.querySelector('.제품select').addEventListener('change', function() {
    let selectedProduct = this.value;

    // 서버로 제품 목록에 대한 데이터 요청
    fetch('GetBOMData?product_list=' + encodeURIComponent(selectedProduct))
        .then(response => response.json())
        .then(data => {
            populateBOMTable(data); // 받아온 데이터를 테이블에 표시
        })
        .catch(error => console.error('Error fetching BOM data:', error));
});


function populateBOMTable(data) {
    let tbody = document.querySelector('.tbody');
    tbody.innerHTML = ''; 

    data.forEach((item, index) => {

        if (!item || Object.keys(item).length === 0) {
            console.warn('Empty object found, skipping:', item);
            return;
        }

        let partName = item.part_name || 'N/A';
        let modelName = item.model_name || 'N/A';
        let partCode = item.part_code || 'N/A';
        let standard = item.standard || 'N/A';
        let unit = item.unit || 'N/A';
        let mount = item.mount || '';
        let company = item.company || '';

        let newRow = document.createElement('tr');
        newRow.innerHTML = '<td><input type="checkbox" class="delete-checkbox"></td>' +
            '<td><select name="partName[]" class="select1">' +
            '<option value="' + partName + '">' + partName + '</option>' +
            '</select></td>' +
            '<td><select name="modelName[]" class="select2">' +
            '<option value="' + modelName + '">' + modelName + '</option>' +
            '</select></td>' +
            '<td class="code">' + partCode + '</td>' +
            '<td class="size">' + standard + '</td>' +
            '<td class="unit">' + unit + '</td>' +
            '<td><input type="text" name="quantity[]" value="' + mount + '" style="width: 30%;"></td>' +
            '<td><input type="text" name="company[]" value="' + company + '"></td>';
        tbody.appendChild(newRow);
        
        console.log('New row HTML:', newRow.innerHTML);  // 새로 생성된 행의 HTML 확인

    });
}

function escapeHtml(unsafe) {
    return unsafe
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;")
        .replace(/'/g, "&#039;");
}


</script>


