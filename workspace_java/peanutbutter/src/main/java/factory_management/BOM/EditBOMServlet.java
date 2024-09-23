package factory_management.BOM;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditBOMServlet")
public class EditBOMServlet extends HttpServlet {
   
    private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:oracle:thin:@125.181.132.133:51521:xe"; // DB URL
    private static final String DB_USER = "scott2_9"; // DB 사용자 이름
    private static final String DB_PASSWORD = "tiger"; // DB 비밀번호

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8;"); 

        String productList = request.getParameter("productList");
        String[] sizes = request.getParameterValues("size[]");
        String[] units = request.getParameterValues("unit[]"); 
        String[] codes = request.getParameterValues("code[]");
        String[] partNames = request.getParameterValues("partName[]");
        String[] modelNames = request.getParameterValues("modelName[]");
        String[] quantities = request.getParameterValues("quantity[]");
        String[] companies = request.getParameterValues("company[]");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 데이터베이스 연결
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            conn.setAutoCommit(false); // 트랜잭션 시작

            // DELETE 쿼리
            if (productList != null && !productList.isEmpty()) {
                String deleteSql = "DELETE FROM BOMREG WHERE product_list = ?";
                pstmt = conn.prepareStatement(deleteSql);
                pstmt.setString(1, productList);
                pstmt.executeUpdate(); // DELETE 쿼리 실행
            }

            // INSERT 쿼리
            String insertSql = "INSERT INTO BOMREG (product_list, part_name, model_name, part_code, standard, unit, mount, company) "
                             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSql);

            if (partNames != null && partNames.length > 0) {
                for (int i = 0; i < partNames.length; i++) {
                    String partName = partNames[i];
                    String modelName = modelNames[i];
                    String quantity = quantities[i];
                    String company = companies[i];
                    String code = codes[i]; 
                    String size = sizes[i];
                    String unit = units[i];

                    // 쿼리에 데이터 설정
                    pstmt.setString(1, productList);
                    pstmt.setString(2, partName);
                    pstmt.setString(3, modelName);
                    pstmt.setString(4, code);
                    pstmt.setString(5, size);
                    pstmt.setString(6, unit);
                    pstmt.setString(7, quantity);
                    pstmt.setString(8, company);

                    // SQL 쿼리 실행
                    pstmt.executeUpdate();
                }
            }

            conn.commit(); // 트랜잭션 커밋
            response.sendRedirect("BOMReg"); // 성공 페이지로 리다이렉션

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rollbackAndRedirect(conn, response, "Error loading database driver");
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackAndRedirect(conn, response, "Database error");
        } finally {
            // 자원 해제
            closeResources(pstmt, conn);
        }
    }

    private void rollbackAndRedirect(Connection conn, HttpServletResponse response, String errorMessage) throws IOException {
        try {
            if (conn != null) conn.rollback(); // 오류 발생 시 롤백
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        response.sendRedirect("BOMReg"); // 에러 페이지로 리다이렉션
    }

    private void closeResources(PreparedStatement pstmt, Connection conn) {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
