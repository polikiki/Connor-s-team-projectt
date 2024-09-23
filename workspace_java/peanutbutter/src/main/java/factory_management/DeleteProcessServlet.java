package factory_management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/DeleteProcessServlet")
public class DeleteProcessServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8;");
        String[] processCodes = request.getParameterValues("processCode");
        if (processCodes != null && processCodes.length > 0) {
            String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
            String username = "scott2_9";
            String password = "tiger";
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection(url, username, password);
                conn.setAutoCommit(false);
                String sql = "DELETE FROM PROCESS WHERE process_code = ?";
                pstmt = conn.prepareStatement(sql);
                for (String processCode : processCodes) {
                	pstmt.setString(1, processCode); 
                    pstmt.executeUpdate();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        response.sendRedirect("factory_Management");
    }
}