<%@ page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"
	import="java.util.Map, java.util.Set, java.util.Map.Entry"%>
<%@ page import="java.util.List"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.net.URLEncoder" %>
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
	width: 25%;
}

.thead th:nth-child(3) {
	width: 25%;
}

.thead th:nth-child(4) {
	width: 25%;
}

.thead th:nth-child(5) {
	width: 10%;
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
				<img src="image/BOM.png" style="width: 30px;"> <span>BOM</span>
			</div>
		</div>
		<div class="search_container">
			<select class="select">
				<option>-----</option>
				<option>제품코드</option>
				<option>제품명</option>
			</select> <input class="search_input" type="text" placeholder="검색어를 입력해주세요">
			<img style="margin-left: 30px; margin-right: 30px;"
				src="image/search.png" onclick="searchTable()">
		</div>
		<div class="search_item">
			<table class="table">
				<thead class="thead">
					<tr>
						<th></th>
						<th>제품코드</th>
						<th>제품명</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody class="tbody">
					<%
					String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
					String username = "scott2_9";
					String password = "tiger";
					Connection conn = null;
					Statement stmt = null;
					ResultSet rs = null;

					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						conn = DriverManager.getConnection(url, username, password);
						String query = "SELECT product_name, product_code FROM TABLE_PM ORDER BY product_code ASC";

						stmt = conn.createStatement();
						rs = stmt.executeQuery(query);

						while (rs.next()) {
							String productname = rs.getString("product_name");
							String productcode = rs.getString("product_code");
					%>
					<tr>
						<td><input type="checkbox" class="delete-checkbox"></td>
						<td data-product-code="<%=productcode%>"><%=productcode%></td>
						<td><a href="BOMDetail?productName=<%= URLEncoder.encode(productname, "UTF-8") %>"><%= productname %></a></td>
						<td></td>
						<td></td>
					</tr>
					<%
					}
				} catch (Exception e) {
						e.printStackTrace();
				} finally {
				try {
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
						} catch (SQLException e) {
						e.printStackTrace();
					}
				}
					%>
				</tbody>
			</table>
		</div>
		<div class="regBtn_div">
			<span class="Btn_css" onclick="deleteSelectedRows()">선택된 행 삭제</span>
			<span class="Btn_css" id="regBtn" onclick="regBOM()">BOM 등록</span>
		</div>
	</div>
</body>

<script>
    function searchTable() {
        let selectValue = document.querySelector('.select').value;
        let input = document.querySelector('.search_input').value;
        let table = document.querySelector('.table');
        let rows = table.querySelectorAll('.tbody tr');
        if (selectValue === '제품코드') {
            rows.forEach(row => {
                let code = row.querySelector('td:nth-child(2)');
                if (code) {
                    let codeText = code.innerText;
                    if (codeText.includes(input)) {
                        row.style.display = '';
                    } else {
                        row.style.display = 'none';
                    }
                }
            });
        } else if (selectValue === '제품명') {
            rows.forEach(row => {
                let name = row.querySelector('td:nth-child(3)');
                if (name) {
                    let nameText = name.innerText;
                    if (nameText.includes(input)) {
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
        let checkedBoxes = document.querySelectorAll('.delete-checkbox:checked');

        if (checkedBoxes.length > 0) {
            let form = document.createElement('form');
            form.method = 'POST';
            form.action = 'BOMDeleteServlet';

            checkedBoxes.forEach(box => {
                let row = box.closest('tr');
                let productCodeElement = row.querySelector('td[data-product-code]');
                let productCode = productCodeElement ? productCodeElement.dataset.productCode : null;
				
                let input = document.createElement('input');
                input.type = 'hidden';
                input.name = 'productcode'; 
                input.value = productCode;
                form.appendChild(input);

            });
            document.body.appendChild(form);
            form.submit();

            checkedBoxes.forEach(box => {
                let row = box.closest('tr');
                row.remove(); 
            });

        } else {
            alert('삭제할 항목을 선택하세요.');
        }
    }
    function regBOM() {
        window.location.href = "BOMReg";
    }

    window.onload = function () {
        let tbody = document.querySelector('.tbody');
        let BOM_items = JSON.parse(sessionStorage.getItem('BOM_items')) || [];
        let newRow = document.createElement('tr');

        BOM_items.forEach(item => {
            if (item.code && item.name) {
                let newRow = document.createElement('tr');
                newRow.innerHTML = `
                                    <td><input type="checkbox" class="delete-checkbox"></td> 
                                    <td>${item.code}</td>
                                    <td><a href="asd.html">${item.name}<a></td>
                                    <td>비고사항 없음</td>
                                    <td>
                                        <select>
                                            <option>Y</option>
                                            <option>N</option>
                                        </select>
                                    </td>
                                    `;

                tbody.appendChild(newRow);
            }
        });
    }
</script>