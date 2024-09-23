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
        width: 10%;
    }

    .thead th:nth-child(3) {
        width: 10%;
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
        width: 6%;
    }

    .thead th:nth-child(8) {
        width: 10%;
    }
    .thead th:nth-child(9) {
        width: 5%;
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
                <span>IR20240805001</span>
            </div>
        </div>

        <div class="search_item">
            <table class="table">
                <thead class="thead">
                    <tr>
                        <th> </th>
                        <th>부품명</th>
                        <th>모델명</th>
                        <th>부품코드</th>
                        <th>납품예정일</th>
                        <th>단가</th>
                        <th>발주수량</th>
                        <th>합계</th>
                        <th>상태</th>
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
                        <td>
                            <select>
                                <option>입고완료</option>
                                <option selected>입고대기</option>
                            </select>
                        </td>
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
                        <td>
                            <select>
                                <option>입고완료</option>
                                <option selected>입고대기</option>
                            </select>
                        </td>
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
                        <td>
                            <select>
                                <option>입고완료</option>
                                <option selected>입고대기</option>
                            </select>
                        </td>
                    </tr>
                    
                </tbody>
            </table>
        </div>
        <div class="regBtn_div">
            <span class="Btn_css" onclick="commit()">저장</span>
        </div>
    </div>
</body>

<script>
    function commit(){
        window.location.href="In";
    }
</script>