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
                <span>PO202407310001</span>
            </div>
        </div>
        <div class="section">
            <div class="tableTopDiv">
                <div class="temp">
                    <span class="span">P/O NO(*)</span> <input type="text" class="inputText" id="PO_No" value="PO202407310001">
                    <span class="span margin">P/O 일자(*)</span> <input type="text" class="inputText" id="PO_date" value="2024-08-05">
                </div>
                <div class="temp">
                    <span class="span">거래처(*)</span> <input type="text" class="inputText" id="account" value="순양물산">
                    <span class="span margin">통화(*)</span> <input type="text" class="inputText" id="KRW" value="KRW">
                </div>
                <div class="temp">
                    <span class="span">비고사항</span> <input style="width: 350px;" type="text" class="inputText" id="remark">

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
                        <td></td>
                        <td>CPU</td>
                        <td>Intel Core i9-9900K</td>
                        <td>A01-01</td>
                        <td>2024-08-01</td>
                        <td>500,000</td>
                        <td>10</td>
                        <td>5,000,000</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>RAM</td>
                        <td>DDR4-3200</td>
                        <td>A02-01</td>
                        <td>2024-08-01</td>
                        <td>200,000</td>
                        <td>10</td>
                        <td>2,000,000</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>메인보드</td>
                        <td>ASUS ROG</td>
                        <td>A03-01</td>
                        <td>2024-08-01</td>
                        <td>300,000</td>
                        <td>10</td>
                        <td>3,000,000</td>
                    </tr>
         
                </tbody>
            </table>

        </div>
        <div class="regBtn">
            <span class="Btn_css" style="padding:10px" onclick="commitReg()">완료</span>

        </div>
    </div>
</body>

<script>
    function commitReg(){
        window.location.href="In";
    }
</script>