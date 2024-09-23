package factory_management.BOM;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/GetBOMData")
public class GetBOMDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8;");
        String productList = request.getParameter("product_list");
        
        // 데이터베이스 연결 설정
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        // JSON 형식으로 데이터를 전달하기 위한 설정
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
    
  
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@125.181.132.133:51521:xe", "scott2_9", "tiger");
            String sql = "SELECT part_name, model_name, part_code, standard, unit, mount, company FROM BOMREG WHERE product_list = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, productList);
            rs = stmt.executeQuery();

            // 결과 데이터를 JSON으로 변환
            JSONArray jsonArray = new JSONArray();
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("part_name", rs.getString("part_name"));
                jsonObject.put("model_name", rs.getString("model_name"));
                jsonObject.put("part_code", rs.getString("part_code"));
                jsonObject.put("standard", rs.getString("standard"));
                jsonObject.put("unit", rs.getString("unit"));
                jsonObject.put("mount", rs.getString("mount"));
                jsonObject.put("company", rs.getString("company"));
                jsonArray.put(jsonObject);
            }
            out.print(jsonArray.toString());
            out.flush();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 자원 정리
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}