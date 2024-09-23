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
    .section {
        margin: 0 100px;
        height: 70vh;
        background-color: white;
    }

    .tableTopDiv {
        width: 100%;
        height: 30%;
        padding-top: 3px;
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
        width: 12%;
    }

    .thead th:nth-child(3) {
        width: 18%;
    }

    .thead th:nth-child(4) {
        width: 12%;
    }

    .thead th:nth-child(5) {
        width: 15%;
    }

    .thead th:nth-child(6) {
        width: 10%;
    }

    .thead th:nth-child(7) {
        width: 10%;
    }

    .thead th:nth-child(8) {
        width: 10%;
    }

    .Btn_css {
        display: inline-block;
        padding: 5px;
        background-color: #3F3B3B;
        color: white;
        border-radius: 5px;
        cursor: pointer;
    }

    .regBtn {
        margin: 0 100px;
        text-align: right;
        margin-top: 30px;
    }

    .inputText {
        height: 25px;
        margin-left: 30px;
        height: 100%;
    }

    .span {
        display: inline-block;
        width: 100px;
        font-weight: bold;
        vertical-align: top;
        height: 100%;
        text-align: center;
        line-height: 30px;
        margin-left: 100px;
    }

    .margin {
        margin-left: 100px;
    }

    .temp {
        height: 30px;
        margin: 5px;
    }

    input[type="text"] {
        text-align: center;
    }
</style>

<body>
    <div class="container">
        <div class="top">
            <div class="title">
                <img src="image/BOM.png" style="width: 30px;">
                <span>발주</span>
            </div>
        </div>
        <div class="section">
        <form id="PoForm" action="SubmitBaljuServlet" method="post">
            <div class="tableTopDiv">
                <div class="temp">
                    <span class="span">P/O NO(*)</span> <input type="text" class="inputText" id="PO_No" name="PO_No">
                    <span class="span margin">P/O 일자(*)</span> <input type="date" class="inputText" id="PO_date" name = "PO_date">
                </div>
                <div class="temp">
                    <span class="span">거래처(*)</span> <input type="text" class="inputText" id="account" name="account">
                    <span class="span margin">통화(*)</span> <input type="text" class="inputText" id="KRW" name="KRW">
                </div>
                <div class="temp">
                    <span class="span">비고사항</span> <input style="width: 350px;" type="text" class="inputText"
                        id="remark">
                    <span class="Btn_css" style="margin-left: 50px;" onclick="addRow()">행 추가</span>
                    <span class="Btn_css" style="margin-left: 20px;" onclick="deleteSelectedRow()">행 삭제</span>
                </div>  
            </div>
            <table class="table">
                <thead class="thead">
                    <tr>
                        <th> </th>
                        <th>부품명</th>
                        <th>모델명</th>
                        <th>부품코드</th>
                        <th>납품예정일</th>
                        <th>단가</th>
                        <th>발주 수량</th>
                        <th>합계</th>
                    </tr>
                </thead>
                <tbody class="tbody">
               <tr>
                  <td><input type="checkbox" class="delete-checkbox"></td>
                  <td><select name="partName[]" class="select1"
                     onchange="updateOption(event)">
                        <option value="-----">-----</option>
                  </select></td>
                  <td><select name="modelName[]" class="select2"
                     onchange="updateCodePrice(event)">
                        <option value="-----">-----</option>
                  </select></td>
                  <td class="code"></td>
                  <td><input type="text" name="delidate[]"></td>
                  <td><input type="text" name="price[]"
                     oninput="updateTotal(event)"></td>
                  <td><input type="text" name="bal_mount[]"
                     oninput="updateTotal(event)"></td>
                  <td class="total"></td>
               </tr>
            </tbody>
            </table>
      </form>
        </div>
        <div class="regBtn">
            <span class="Btn_css" style="padding:10px" onclick="commitReg()">완료</span>

        </div>
    </div>
</body>

<script>
    function deleteSelectedRow() {
        let checkboxes = document.querySelectorAll('.delete-checkbox');
        checkboxes.forEach(checkbox => {
            if (checkbox.checked) {
                checkbox.closest('tr').remove(); 
            }
        });
    }

    function commitReg() {
        let PO_No = document.querySelector('#PO_No').value;
        let PO_date = document.querySelector('#PO_date').value;
        let KRW = document.querySelector('#KRW').value;
        let account = document.querySelector('#account').value;

        // 필수 입력값 검증
        if (PO_No === '') {
            alert('P/O No를 입력해주세요');
            return;
        } else if (PO_date === '') {
            alert('P/O 일자를 입력해주세요');
            return;
        } else if (account === '') {
            alert('거래처를 입력해주세요');
            return;
        } else if (KRW === '') {
            alert('통화를 입력해주세요');
            return;
        }
        
        // 비고사항 처리
        let remark = document.querySelector('#remark').value;
        if (remark === '') {
            remark = "없음";
        }

        let date = new Date(PO_date);
        let date2 = date.toLocaleDateString();
        
        // 연도 추가
        let hiddenYearField = document.createElement('input');
        hiddenYearField.type = 'hidden';
        hiddenYearField.name = 'PO_Year';
        hiddenYearField.value = date2;
        document.getElementById('PoForm').appendChild(hiddenYearField);

        // 모든 행의 코드 값을 숨겨진 필드에 추가
        let tbody = document.querySelector('.tbody');
        let rows = tbody.querySelectorAll('tr');

        rows.forEach((row, index) => {
            let code = row.querySelector('.code').textContent.trim();

            let codeInput = document.createElement('input');
            codeInput.type = 'hidden';
            codeInput.name = `code[${index}]`;
            codeInput.value = code;
            document.getElementById('PoForm').appendChild(codeInput);
        });

        // 폼 제출
        document.getElementById('PoForm').submit();
    }


    function updateTotal(event) {
        const row = event.target.closest('tr');
        const price = row.querySelector('input[name="price[]"]').value;
        const bal_mount = row.querySelector('input[name="bal_mount[]"]').value;

        // 단가와 발주 수량이 숫자인지 확인
        const priceValue = parseFloat(price) || 0;
        const balMountValue = parseFloat(bal_mount) || 0;

        // 합계를 계산
        const total = priceValue * balMountValue;

        // 합계 셀에 표시
        const totalCell = row.querySelector('.total');
        totalCell.textContent = total.toFixed(0); 

        // 추가적으로 합계 데이터를 저장할 숨겨진 필드 추가
        let totalInput = row.querySelector('input[name="total[]"]');
        if (!totalInput) {
            totalInput = document.createElement('input');
            totalInput.type = 'hidden';
            totalInput.name = 'total[]';
            row.appendChild(totalInput);
        }
        totalInput.value = total;
    }
        
        function addRow() { 
            let tbody = document.querySelector('.tbody');
            let newRow = document.createElement('tr');
            newRow.innerHTML = `
               <td><input type="checkbox" class="delete-checkbox"></td>
            <td><select name="partName[]" class="select1"
               onchange="updateOption(event)">
                  <option value="-----">-----</option>
            </select></td>
            <td><select name="modelName[]" class="select2"
               onchange="updateCodePrice(event)">
                  <option value="-----">-----</option>
            </select></td>
            <td class="code"></td>
            <td><input type="text" name="delidate[]"></td>
            <td><input type="text" name="price[]"
               oninput="updateTotal(event)"></td>
            <td><input type="text" name="bal_mount[]"
               oninput="updateTotal(event)"></td>
            <td class="total"></td>
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
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok ' + response.statusText);
                    }
                    return response.text();
                })
                .then(data => {
                    console.log('Server response:', data); // 응답 로그 추가
                    const parts = data.split('|');

                    if (parts.length === 3) {
                        const [code, size, unit] = parts;
                        const codeCell = select2.closest('tr').querySelector('.code');
                        const sizeCell = select2.closest('tr').querySelector('.size');
                        const unitCell = select2.closest('tr').querySelector('.unit');

                        if (codeCell) codeCell.textContent = code;
                        if (sizeCell) sizeCell.textContent = size;
                        if (unitCell) unitCell.textContent = unit;
                    } else {
                        console.error('Unexpected response format:', data);
                    }
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
</script>