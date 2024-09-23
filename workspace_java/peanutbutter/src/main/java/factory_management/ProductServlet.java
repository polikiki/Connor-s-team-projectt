package factory_management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Oracle DB 연결 정보
    	
    	try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ServletException("JDBC 드라이버 로드 실패", e);
        }

        String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
        String user = "scott2_9";
        String password = "tiger";
        
        List<String> productCodes = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT product_code FROM TABLE_PM ORDER BY product_code ASC");
             ResultSet rs = stmt.executeQuery()) {
        	
            while (rs.next()) {
                String code = rs.getString("product_code");
                productCodes.add(code);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("productCodes", productCodes);
        request.getRequestDispatcher("/WEB-INF/views/factoryReg.jsp").forward(request, response);
    }
}
