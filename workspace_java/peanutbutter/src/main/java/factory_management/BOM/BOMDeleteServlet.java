package factory_management.BOM;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BOMDeleteServlet
 */
@WebServlet("/BOMDeleteServlet")
public class BOMDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8;");
        String[] productCodes = request.getParameterValues("productcode");

        if (productCodes != null && productCodes.length > 0) {
            String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
            String username = "scott2_9";
            String password = "tiger";
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection(url, username, password);
                conn.setAutoCommit(false);
                String sql = "DELETE FROM TABLE_PM WHERE product_code = ?";
                pstmt = conn.prepareStatement(sql);
                for (String productCode : productCodes) {
                    pstmt.setString(1, productCode); 
                    pstmt.executeUpdate();
                }
                conn.commit(); 
            } catch (Exception e) {
                e.printStackTrace();
                if (conn != null) {
                    try {
                        conn.rollback(); 
                    } catch (SQLException rollbackEx) {
                        rollbackEx.printStackTrace();
                    }
                }
            } finally {
                try {
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        response.sendRedirect("BOM");
    }

}
