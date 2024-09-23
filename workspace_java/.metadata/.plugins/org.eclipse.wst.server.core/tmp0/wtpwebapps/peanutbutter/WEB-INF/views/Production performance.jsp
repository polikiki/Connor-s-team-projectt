<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
            background-color: #F0F0E8
        }

        .top {
            color: #676767;
            font-size: 24px;
            font-weight: bold;
            height: 8vh;

        }

        .title {
            margin-top: 30px;
            margin-left: 100px;
        }

        .title img {
            vertical-align: middle;
            /* 이미지와 텍스트의 높낮이를 맞추기 위해 추가 */
        }

        .title span {
            vertical-align: middle;
            /* 이미지와 텍스트의 높낮이를 맞추기 위해 추가 */
        }

        .search_container {
            margin: 0 100px;
            height: 17vh;
            background-color: #E9E4DC;
            display: flex;
            align-items: left;
            flex-direction: column;
            padding-left: 30px;
        }

        .span1 {
            display: flex;

        }

        .search_item {
            margin: 10px 100px;
            height: 43vh;
            background-color: white;
            overflow-y: auto;
        }

        table {
            width: 100%;
            table-layout: fixed;
            border-collapse: collapse;
        }

        th,
        td {
            text-align: center;
            vertical-align: middle;
            padding: 5px;
        }

        .tableTop {
            background-color: #848484;
            font-weight: bold;
            color: white;
        }


        .tableBody {
            box-sizing: border-box;
            vertical-align: middle;
            margin-bottom: 0px;
            margin-top: 0px;

        }

        .title {
            vertical-align: bottom;
        }


        .calendar {
            height: 30px;
        }


        td>input {
            text-align: center;
            width: 80px;
        }

        .commit {
            margin: 50px 100px;
            text-align: right;
        }

        .save,
        .inquire {
            border: #676767;
            height: 40px;
            padding: 15px;
            background-color: #848484;
            color: white;
            border-radius: 5px;
            cursor: pointer;
            width: 40px;
        }

        .item {
            vertical-align: text-bottom;
        }

        .record {
            padding-top: 8px;
            padding-bottom: 1px;
        }

        .part {
            padding-bottom: 5px;
        }

        div.inquiry input {
            display: inline-block;
            background-color: black;
            color: white;
            font-weight: bold;
            border-radius: 5px;
        }

        .inquiry {
            margin: 0 100px;
            margin-top: 10px;
            text-align: right;
        }

        div.inquiry span {
            float: left;
            text-align: left;
        }

        .tableBody tr {
            border-bottom: 1px solid rgb(188, 184, 184);
        }

        .search_container {
            margin: 0 100px;
            height: 10vh;
            background-color: #E9E4DC;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .select {
            margin-right: 20px;
            height: 40px;
            font-size: 20px;
            border-radius: 5px;
        }

        .inputTextHeight {
            height: 30px;
            font-size: 20px;
        }

        .btn2 {
            margin-left: 10px;
            ;
        }

        thead th:nth-child(1) {
            width: 5%;
        }

        thead th:nth-child(2) {
            width: 10%;
        }

        thead th:nth-child(3) {
            width: 10%;
        }

        thead th:nth-child(4) {
            width: 10%;
        }

        thead th:nth-child(5) {
            width: 10%;
        }

        thead th:nth-child(6) {
            width: 10%;
        }

        thead th:nth-child(7) {
            width: 7%;
        }

        thead th:nth-child(8) {
            width: 5%;
        }

        thead th:nth-child(9) {
            width: 5%;
        }

        thead th:nth-child(10) {
            width: 7%;
        }

        thead th:nth-child(11) {
            width: 5%;
        }

        .select_all {
            margin-left: 10px;
        }

        .deselect_all {
            margin-left: 10px;
        }

        .tableTop {
            position: sticky;
            top: 0;
        }
    </style>
    <script>
        window.onload = function () {
            let btn = document.querySelector(".btn")

            // let chk = document.querySelectorAll("input[type='checkbox']")

            btn.addEventListener("click", function () {
                let tbody = document.querySelector(".tableBody");
                let newRow = document.createElement("tr");
                newRow.classList.add("row");


                let cells = `
                         <td><input type="checkbox" class="chk" style="width : 90%;"></td>
                         <td><input type="text" style="width : 90%;"></td>
                         <td><input type="text" style="width : 90%;"></td>
                         <td><input type="text" style="width : 90%;"></td>
                         <td><input type="text" style="width : 90%;"></td>
                         <td><input type="text" style="width : 90%;"></td>
                         <td><input type="text" style="width : 90%;"></td>
                        <td><input type="text" style="width : 90%;"></td>
                         <td><input type="text" style="width : 90%;"></td>
                         <td><input type="text" style="width : 90%;"></td>
                         <td><input type="text" style="width : 90%;"></td>
                         `
                    ;

                newRow.innerHTML = cells
                tbody.appendChild(newRow);

            });


            let select_all = document.querySelector(".select_all")
            select_all.addEventListener("click", function () {
                //hasClass
                if (select_all.classList.contains("select_all")) {
                    select_all.classList.remove("select_all");
                    select_all.classList.add("deselect_all");
                    select_all.value = "전체해제";
                    let chkbox = document.querySelectorAll(".chk")
                    for (let i = 0; i < chkbox.length; i++) {
                        chkbox[i].checked = true;
                        // if (chk_all.checked == false) {
                        //     chkbox[i].checked = false;
                        // } 
                    }
                } else {
                    select_all.classList.remove("deselect_all");
                    select_all.classList.add("select_all");
                    select_all.value = "전체선택";

                    let chkbox = document.querySelectorAll(".chk")
                    for (let i = 0; i < chkbox.length; i++) {
                        chkbox[i].checked = false;
                    }
                }
            })


            let del = document.querySelector(".btn2")
            del.addEventListener("click", function () {
                let chkbox = document.querySelectorAll(".chk");
                chkbox.forEach(function (chkbox) {
                    if (chkbox.checked) {
                        // 체크박스가 포함된 td의 부모 tr 요소를 선택하여 삭제
                        let td = chkbox.parentElement;
                        let row = td.parentElement;
                        row.remove();
                    }
                });
            });

        }

    </script>
</head>

<body>
    <div class="container">
        <div class="top">
            <div class="title"><img src="image/directory.png">생산실적</div>
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
                <img class="searchBtn" src="image/search.png">
            </div>
        </div>
        <!-- <div class="inquiry">
            <span> <input type="button" value="추가" class="btn"></span><span><input type="button" value="삭제"
                    class="btn2"></span>
            <span><input type="button" value="전체선택" class="select_all"></span>

            <input type="button" value="공정별 자재투입 현황 조회">
            <input type="button" value="공정별 생산 실적 조회">
        </div> -->
        <div class="search_item">
            <table>
                <thead class="tableTop">
                    <tr>
                        <th></th>
                        <th style="font-size: 13px;">생산계획서NO</th>
                        <th>제품명</th>
                        <th>지시일자</th>
                        <th>계획수량</th>
                        <th>생산</th>
                        <th>양품</th>
                        <th>불량품</th>
                        <th>잔량</th>
                    </tr>
                </thead>
                <tbody class="tableBody">
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>${list[0].plan_number}</td>
                        <td style="font-size: 15px;">${list[0].product_name}</td>
                        <td>${list[0].plan_start_date}</td>
                        <td>${list[0].plan_amount}</td>
                        <td>14</td>
                        <td>13</td>
                        <td>1</td>
                        <td>${list[0].plan_amount-14}</td>
                    </tr>
                </tbody>
            </table>

        </div>
        <div class="commit"><span class="save">저장</span></div>
</body>

</body>
</html>