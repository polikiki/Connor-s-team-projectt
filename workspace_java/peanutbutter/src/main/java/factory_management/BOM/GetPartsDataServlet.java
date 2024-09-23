package factory_management.BOM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/GetPartsData")
public class GetPartsDataServlet extends HttpServlet {

  
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8;");
        PrintWriter out = response.getWriter();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT PART_NAME FROM TABLE_PT")) {

            ResultSet rs = ps.executeQuery();
            StringBuilder options = new StringBuilder();

            options.append("<option value='-----'>-----</option>");
            while (rs.next()) {
                options.append("<option value='").append(rs.getString("part_name")).append("'>")
                        .append(rs.getString("part_name")).append("</option>");
            }

            out.print(options.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
	 
    private Connection getConnection() throws Exception {
        String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe"; // Oracle DB URL
        String user = "scott2_9"; // DB 사용자명
        String password = "tiger"; // DB 비밀번호
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(url, user, password);
    }
}
