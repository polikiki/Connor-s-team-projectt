<%@ page contentType="text/html; charset=UTF-8" language="java" %>
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
    <div class="container">
        <div class="top">
            <img src="image/BOM.png" style="width: 30px;">
            <span>하판 조립</span>
        </div>
        <div class="section">
            <div style="margin-left: 150px;">
                <div>
                    <span class="span">공정코드</span><input class="inputText" type="text" value="PROCESS-001">
                    <span class="spanMargin">공정명</span><input class="inputText" type="text" value="하판 조립">
                </div>
                <div class="div">
                    <span class="span">공정분류</span><input class="inputText" type="text" value="조립">
                    <span class="spanMargin">사용여부</span>
                    <select class="select">
                        <option>Y</option>
                        <option>N</option>
                    </select>
                </div>
                <div class="div">
                    <span class="span">사이클타임</span><input class="inputText" type="text" value="8">
                    <span class="spanMargin">제품코드</span>
                    <select class="select2">
                        <option>-----</option>
                        <option selected>GRAM14-001</option>
                        <option>GRAM15-001</option>
                        <option>SAMSUNG-001</option>
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
                            <th>순서</th>
                            <th>하위공정코드</th>
                            <th>공정명</th>
                            <th>이미지</th>
                            <th>공정내용</th>
                        </tr>
                    </thead>
                    <tbody class="tbody">
                        <tr>
                            <td><input type="checkbox" class="delete-checkbox"></td>
                            <td>1</td>
                            <td><input type="text" style="width: 90%;" value="PA01-001"></td>
                            <td><input type="text" style="width: 90%;" value="CPU결합"></td>
                            <td><input type="file"></td>
                            <td><input type="text" style="width: 90%;text-align: center;" value="메인보드와 CPU를 결합합니다." ></td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" class="delete-checkbox"></td>
                            <td>2</td>
                            <td><input type="text" style="width: 90%;" value="PA01-002"></td>
                            <td><input type="text" style="width: 90%;" value="RAM결합"></td>
                            <td><input type="file"></td>
                            <td><input type="text" style="width: 90%;text-align: center;" value="메인보드의 RAM 슬롯에 RAM 모듈을 장착합니다." ></td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" class="delete-checkbox"></td>
                            <td>3</td>
                            <td><input type="text" style="width: 90%;" value="PA01-003"></td>
                            <td><input type="text" style="width: 90%;" value="저장 장치 결합"></td>
                            <td><input type="file"></td>
                            <td><input type="text" style="width: 90%;text-align: center;" value="SSD 또는 HDD를 메인보드나 전용 브래킷에 장착합니다." ></td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" class="delete-checkbox"></td>
                            <td>4</td>
                            <td><input type="text" style="width: 90%;" value="PA01-004"></td>
                            <td><input type="text" style="width: 90%;" value="배터리 장착"></td>
                            <td><input type="file"></td>
                            <td><input type="text" style="width: 90%;text-align: center;" value="배터리를 메인보드에 연결하고, 하판에 고정합니다." ></td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" class="delete-checkbox"></td>
                            <td>5</td>
                            <td><input type="text" style="width: 90%;" value="PA01-005"></td>
                            <td><input type="text" style="width: 90%;" value="쿨러 장착"></td>
                            <td><input type="file"></td>
                            <td><input type="text" style="width: 90%;text-align: center;" value="냉각 팬과 히트파이프를 CPU와 GPU에 연결합니다." ></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="btnDiv">
            <span class="Btn_css">등록</span>
        </div>
    </div>
</body>
<script>
	//db의 데이터를 읽어서 표시해주는 것을 만든다.
    function commitReg() {
        window.location.href = "factory.jsp";
    }

    let count = 2;
    function addRow() {
        let tbody = document.querySelector('.tbody');

        let newRow = document.createElement('tr');
        newRow.innerHTML = `
                            <td><input type="checkbox" class="delete-checkbox"></td>
                            <td>${count}</td>
                            <td><input type="text" style="width: 90%;"></td>
                            <td><input type="text" style="width: 90%;"></td>
                            <td><input type="file"></td>
                            <td><input type="text" style="width: 90%;text-align: center;" ></td>
    `;

        count++;
        tbody.appendChild(newRow);
    }

    function deleteSelectedRows() { 
        let checkboxes = document.querySelectorAll('.delete-checkbox');
        checkboxes.forEach(checkbox => {
            if (checkbox.checked) {
                checkbox.closest('tr').remove(); 
            }
        });

        resetRowNumbers();
    }

    function resetRowNumbers() {
    let rows = document.querySelectorAll('.tbody tr');
    count = 1; // 초기화
    rows.forEach(row => {
        let cells = row.querySelectorAll('td');
        cells[1].textContent = count++; // 두 번째 셀에 순서 번호 재설정
    });
}
</script>