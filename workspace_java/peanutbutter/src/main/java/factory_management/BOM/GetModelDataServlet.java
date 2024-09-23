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
import java.sql.SQLException;

@WebServlet("/GetModelData")
public class GetModelDataServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = response.getWriter();
             Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT PART_MODELNAME FROM TABLE_PT WHERE PART_NAME = ?")) {
            
            String partName = request.getParameter("part_name");

            ps.setString(1, partName);
            try (ResultSet rs = ps.executeQuery()) {
                StringBuilder options = new StringBuilder();
                options.append("<option value='-----'>-----</option>");
                while (rs.next()) {
                    options.append("<option value='").append(rs.getString("PART_MODELNAME")).append("'>")
                            .append(rs.getString("PART_MODELNAME")).append("</option>");
                }
                out.print(options.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe"; // Oracle DB URL
        String user = "scott2_9"; // DB 사용자명
        String password = "tiger"; // DB 비밀번호
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(url, user, password);
    }
}
