<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
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
        height: 10vh;
    }

    .title {
        padding-top: 10px;
        margin-left: 50px;
    }

    .title img {
        vertical-align: middle;
    }

    .title span {
        vertical-align: middle;
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
        border-bottom: 1px solid rgb(218, 218, 218);
        height: 80px;
    }
    .tbody img {
        width: 80px;
        height: 80px;
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
        width: 15%;
    }
    .thead th:nth-child(5) {
        width: 10%;
    }
    .thead th:nth-child(6) {
        width: 5%;
    }
    .thead th:nth-child(7) {
        width: 5%;
    }
    .thead th:nth-child(8) {
        width: 20%;
    }


    .table_div{
        margin:0px 20px;
        background-color: white;
    }

    .pagination {
        display: flex;
        justify-content: center;
        list-style-type: none;
        padding: 0;
    }

    .pagination li {
        margin: 0 5px;
    }

    .pagination a {
        display: block;
        padding: 8px 16px;
        text-decoration: none;
        color: #007bff;
    }

    .pagination a:hover {
        background-color: #ddd;
        border-radius: 5px;
    }

    .pagination .active a {
        color: white;
        background-color: #007bff;
        border-radius: 5px;
    }
    #modi1, #save{
        padding: 5px;
        background-color: #3F3B3B;
        color: white;
        border-radius: 5px;
        cursor: pointer;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="top">
            <div class="title">
                <img src="image/BOM.png" style="width: 30px;">
                <%  
                    String productName = request.getParameter("productName");
                    int currentPage = Integer.parseInt(request.getParameter("page") != null ? request.getParameter("page") : "1");
                    int pageSize = 10; // 페이지당 항목 수

                    int totalPages = 0; // totalPages 변수 정의
                %>
                <span><%= productName %></span>
            </div>
        </div>

        <div class="table_div">
            <table class="table">
                <thead class="thead">
                    <tr>
                        <th></th>
                        <th>부품코드</th>
                        <th>부품분류</th>
                        <th>모델</th>
                        <th>이미지</th>
                        <th>개수</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody class="tbody">
                    <%
                        Connection conn = null;
                        PreparedStatement pstmt = null;
                        ResultSet rs = null;
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            conn = DriverManager.getConnection("jdbc:oracle:thin:@125.181.132.133:51521:xe", "scott2_9", "tiger");

                            // 총 레코드 수를 조회
                            String countQuery = "SELECT COUNT(*) FROM BOMREG WHERE product_list LIKE ?";
                            pstmt = conn.prepareStatement(countQuery);
                            pstmt.setString(1, "%" + productName + "%");
                            rs = pstmt.executeQuery();
                            rs.next();
                            int totalRecords = rs.getInt(1);
                            totalPages = (int) Math.ceil(totalRecords / (double) pageSize); // totalPages 계산

                            // 페이지에 맞는 레코드를 조회
                            String query = "SELECT * FROM (SELECT a.*, ROW_NUMBER() OVER (ORDER BY part_code) rnum FROM BOMREG a WHERE product_list LIKE ?) WHERE rnum BETWEEN ? AND ?";
                            pstmt = conn.prepareStatement(query);
                            pstmt.setString(1, "%" + productName + "%");
                            pstmt.setInt(2, (currentPage - 1) * pageSize + 1);
                            pstmt.setInt(3, currentPage * pageSize);
                            rs = pstmt.executeQuery();
                            
                            while (rs.next()) {
                                String partCode = rs.getString("part_code");
                                String partName = rs.getString("part_name");
                                String modelName = rs.getString("model_name");
                                String mount = rs.getString("mount");
                    %>
                    <tr>
                        <td></td>
                        <td><%= partCode %></td>
                        <td><%= partName %></td>
                        <td><%= modelName %></td>
                        <td>이미지 주소</td>
                        <td class="modi"><%= mount %></td>
                        <td class="modi"></td>
                        <td class="modi"></td>
                    </tr>
                    <%
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            if (rs != null) try { rs.close(); } catch (SQLException e) { }
                            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { }
                            if (conn != null) try { conn.close(); } catch (SQLException e) { }
                        }
                    %>
                </tbody>
            </table>
        </div>

        <div class="pagination">
            <%
                for (int i = 1; i <= totalPages; i++) {
                    if (i == currentPage) {
            %>
            <li class="active"><a href="?productName=<%= productName %>&page=<%= i %>"><%= i %></a></li>
            <%
                    } else {
            %>
            <li><a href="?productName=<%= productName %>&page=<%= i %>"><%= i %></a></li>
            <%
                    }
                }
            %>
        </div>
    </div>

    <script>
        let isProcessing = false;
        function mody() {
            if (isProcessing) return;
            isProcessing = true; 

            let modiElements = document.querySelectorAll('.modi');
            modiElements.forEach(element => {
                let currentText = element.textContent;
                element.innerHTML = `<input type="text" value="${currentText}">`;
            });
        }

        function saveChanges() {
            let modiElements = document.querySelectorAll('.modi');

            modiElements.forEach(element => {
                let inputField = element.querySelector('input');
                if (inputField) {
                    let updatedText = inputField.value;
                    element.innerHTML = updatedText; 
                }
            });
            isProcessing = false;
        }
    </script>
</body>
</html>
