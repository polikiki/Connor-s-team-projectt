package factory_management.BOM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/GetCodeSizeData")
public class GetCodeSizeDataServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String modelName = request.getParameter("model_name");

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT PART_CODE, PART_STANDARD, PART_UNIT FROM TABLE_PT WHERE PART_MODELNAME = ?")) {
            
            ps.setString(1, modelName); // modelName을 기준으로 데이터 조회
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String code = rs.getString("PART_CODE");
                    String size = rs.getString("PART_STANDARD");
                    String unit = rs.getString("PART_UNIT");
                    response.getWriter().write(code + "|" + size + "|" + unit);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
