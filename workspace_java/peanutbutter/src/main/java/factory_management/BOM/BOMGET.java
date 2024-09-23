package factory_management.BOM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BOMGET")
public class BOMGET extends HttpServlet {
   
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        StringBuilder htmlResponse = new StringBuilder();

        String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
        String username = "scott2_9";
        String password = "tiger";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, username, password);

            String queryProductNames = "SELECT DISTINCT product_name, product_code FROM TABLE_PM ORDER BY product_name";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryProductNames);

            htmlResponse.append("<option value=\"-----\">-----</option>");
            while (rs.next()) {
                String productName = rs.getString("product_name");
                String productCode = rs.getString("product_code");

                // product_name과 product_code를 결합하여 value에 저장
                String combinedValue = productName + "-" + productCode;

                htmlResponse.append("<option value=\"").append(combinedValue).append("\">")
                            .append(productName).append(" (").append(productCode).append(")</option>");
            }
            htmlResponse.append("|");
      
            response.getWriter().write(htmlResponse.toString());

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
