<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    .search_container {
        margin: 0 100px;
        height: 10vh;
        background-color: #E9E4DC;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .search_input {
        height: 40px;
        font-size: 20px;
        border-radius: 5px;
        padding: 5px;
    }

    .select {
        margin-right: 20px;
        height: 40px;
        font-size: 20px;
        border-radius: 5px;
    }

    .search_item {
        margin: 10px 100px;
        height: 60vh;
        background-color: white;
        overflow-y: auto;
    }

    .inputTextHeight {
        height: 30px;
        font-size: 20px;
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

    .thead th {
        border-left: 1px solid white;
    }

    .thead th:nth-child(1) {
        width: 5%;
    }

    .thead th:nth-child(2) {
        width: 15%;
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
        width: 10%;
    }

    .thead th:nth-child(7) {
        width: 10%;
    }

    .thead th:nth-child(8) {
        width: 20%;
    }

    .regBtn_div {
        margin: 0 100px;
        text-align: right;
        margin-top: 30px;
    }

    .Btn_css {
        padding: 15px;
        background-color: #3F3B3B;
        color: white;
        border-radius: 5px;
        cursor: pointer;
    }
</style>

<body>
    <div class="container">
        <div class="top">
            <div class="title">
                <img src="image/BOM.png" style="width: 30px;">
                <span>발주 관리</span>
            </div>
        </div>
        <div class="search_container">
            <div class="search">
                
                <select id="select" name="choice" class="inputTextHeight">
                    <option value="select">-------</option>
                    <option value="생산계획No">생산계획NO</option>
                    <option value="제품명">제품명</option>
                </select>
                <input id="searchText" type="text" placeholder="Search..."
                    class="inputTextHeight">&nbsp;&nbsp;&nbsp;&nbsp;
                <img class="searchBtn" src="image/search.png" onclick="searchTable()">
            </div>
        </div>
        <div class="search_item">
            <table class="table">
                <thead class="thead">
                    <tr>
                        <th> </th>
                        <th>P/O NO</th>
                        <th>P/O 일자</th>
                        <th>거래처</th>
                        <th>통화</th>
                        <th>개수</th>
                        <th>발주서</th>
                        <th>입고</th>
                    </tr>
                </thead>
                <tbody class="tbody">
                    <tr>
                        <td><input type="checkbox" class="delete-checkbox"></td>
                        <td>PO202407310001</td>
                        <td>2024-07-31</td>
                        <td>순양물산</td>
                        <td>KRW</td>
                        <td>2</td>
                        <td><img class="" src="image/download.png" onclick="download()"></td>
                        <td><input type="button" value="입고 작성" onclick="inReg()"></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="regBtn_div">
            <span class="Btn_css" onclick="deleteSelectedRows()">선택된 행 삭제</span>
            <span class="Btn_css" onclick="baljuBuy()">발주</span>
        </div>
    </div>
</body>

<script>

    function searchTable() { 
        let selectValue = document.querySelector('#select').value;
        let searchText = document.querySelector('#searchText').value;
        console.log(selectValue)
        console.log(searchText)
        let table = document.querySelector('.table');
        let rows = table.querySelectorAll('.tbody tr'); // 행
        if (selectValue === '생산계획No') {
            rows.forEach(row => {
                let planNo = row.querySelector('td:nth-child(2)');
                if (planNo) {
                    let codeText = planNo.innerText;
                    if (codeText.includes(searchText)) {
                        row.style.display = '';
                    } else {
                        row.style.display = 'none';
                    }
                }
            });
        } else if (selectValue === '제품명') {
            rows.forEach(row => {
                let name = row.querySelector('td:nth-child(4)');
                if (name) {
                    let nameText = name.innerText;
                    if (nameText.includes(searchText)) {
                        row.style.display = '';
                    } else {
                        row.style.display = 'none';
                    }
                }
            });
        } else if (selectValue === '-----') {
            rows.forEach(row => {
                row.style.display = '';
            })
        }

    }

    function deleteSelectedRows() {
        let checkboxes = document.querySelectorAll('.delete-checkbox');
        checkboxes.forEach(checkbox => {
            if (checkbox.checked) {
                checkbox.closest('tr').remove(); 
            }
        });
    }

    function download() {
        alert("발주서 다운로드 완료!")
    }

    window.onload = function () {
        let tbody = document.querySelector('.tbody');
        let balju_item = JSON.parse(sessionStorage.getItem('balju_item')) || [];
        let newRow = document.createElement('tr');
        
        balju_item.forEach(item => {
            if (item.PO_No && item.PO_date && item.account && item.KRW) {
                let newRow = document.createElement('tr');
                newRow.innerHTML = `
                                <td><input type="checkbox" class="delete-checkbox"></td>
                                <td>${item.PO_No}</td>
                                <td>${item.PO_date}</td>
                                <td>${item.account}</td>
                                <td>${item.KRW}</td>
                                <td>${item.rowCount}</td>
                                <td><img class=""src="image/download.png" onclick="download()"></td>
                                <td>${item.remark}</td>
                                    `;

                tbody.appendChild(newRow);
            }
        });
    }

    function baljuBuy(){
    	window.location.href="BaljuReg";
    }
    function inReg(){
    	 window.location.href="BaljuDetail";
    }
</script>