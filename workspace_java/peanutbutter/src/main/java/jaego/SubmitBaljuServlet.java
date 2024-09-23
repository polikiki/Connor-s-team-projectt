package jaego;

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

@WebServlet("/SubmitBaljuServlet")
public class SubmitBaljuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8;"); 
        String jdbcURL = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
        String dbUser = "scott2_9";
        String dbPassword = "tiger";

        String poNo = request.getParameter("PO_No");
        String poDate = request.getParameter("PO_date");
        String company = request.getParameter("account");
        String currency = request.getParameter("KRW");
        String memo = request.getParameter("remark");
        
        System.out.println(poNo);
        String insertBaljuSQL = "INSERT INTO BALJU (ponum, podate, company, currency, memo) VALUES (?, ?, ?, ?, ?)";
        String insertBalju2SQL = "INSERT INTO BALJU2 (ponum, part_name, model_name, part_code, delidate, price, bal_mount, total_mount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            try (PreparedStatement baljuStatement = connection.prepareStatement(insertBaljuSQL)) {
                baljuStatement.setString(1, poNo);
                baljuStatement.setString(2, poDate);
                baljuStatement.setString(3, company);
                baljuStatement.setString(4, currency);
                baljuStatement.setString(5, memo);
                baljuStatement.executeUpdate();
            }
           
            // BALJU2 데이터 저장
            String[] partNames = request.getParameterValues("partName[]");
            String[] modelNames = request.getParameterValues("modelName[]");
            String[] partCodes = request.getParameterValues("code[]");
            String[] delidates = request.getParameterValues("delidate[]");
            String[] prices = request.getParameterValues("price[]");
            String[] balMounts = request.getParameterValues("bal_mount[]");
            String[] totals = request.getParameterValues("total[]");

            try (PreparedStatement balju2Statement = connection.prepareStatement(insertBalju2SQL)) {
                for (int i = 0; i < partNames.length; i++) {
                    balju2Statement.setString(1, poNo);
                    balju2Statement.setString(2, partNames[i]);
                    balju2Statement.setString(3, modelNames[i]);
                    balju2Statement.setString(4, partCodes[i]);
                    balju2Statement.setString(5, delidates[i]);
                    balju2Statement.setString(6, prices[i]);
                    balju2Statement.setString(7, balMounts[i]);
                    balju2Statement.setString(8, totals[i]);
                    balju2Statement.addBatch();
                }
                balju2Statement.executeBatch();
            }
            
            response.sendRedirect("Balju"); // 성공 후 리다이렉션

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("Balju"); // 오류 시 리다이렉션
        }
    }
}

