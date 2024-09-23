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
@WebServlet("/SubmitBOMServlet")
public class SubmitBOMServlet extends HttpServlet {
   
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

            // SQL 쿼리
            String sql = "INSERT INTO BOMREG (product_list, part_name, model_name, part_code, standard, unit, mount, company) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            // PreparedStatement 객체 생성
            pstmt = conn.prepareStatement(sql);
            
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

            response.sendRedirect("BOMReg"); // 성공 페이지로 리다이렉션

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("BOMReg"); // 에러 페이지로 리다이렉션
        } finally {
            // 자원 해제
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}