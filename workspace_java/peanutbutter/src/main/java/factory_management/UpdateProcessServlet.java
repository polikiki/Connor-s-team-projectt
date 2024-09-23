package factory_management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateProcessServlet")
public class UpdateProcessServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // 데이터베이스 연결 정보
    private static final String JDBC_URL = "jdbc:oracle:thin:@125.181.132.133:51521:xe"; // Oracle DB URL (예: XE)
    private static final String JDBC_USER = "scott2_9"; // 사용자명
    private static final String JDBC_PASSWORD = "tiger"; // 비밀번호

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8;");

        // 데이터베이스 연결
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            connection.setAutoCommit(false);
            // 배열을 받아옵니다.
            String[] processcode = request.getParameterValues("processCode");
            // 배열이 null이거나 길이가 0인 경우 처리
            if (processcode != null && processcode.length > 0) {
                // List로 변환하여 null 값 제거
                List<String> filteredList = Arrays.stream(processcode)
                                                  .filter(value -> value != null && !value.trim().isEmpty())
                                                  .collect(Collectors.toList());
                String firstNonNullValue = null;
                if (!filteredList.isEmpty()) {
                    firstNonNullValue = filteredList.get(0);
                }
                //이 데이터는 if문 안에서만 작동합니다.
                if (firstNonNullValue != null) {
                    // 기존 데이터 삭제
                    String deleteSql = "DELETE FROM process2 WHERE process_code = ?";
                   	try (PreparedStatement deleteStmt = connection.prepareStatement(deleteSql)) {
                            deleteStmt.setNString(1, firstNonNullValue);
                            deleteStmt.executeUpdate();
                        }
                   	connection.commit();
                } 
            } 

           
            // 메인 공정 데이터 처리
            String processName = request.getParameter("processName");
            String processCategory = request.getParameter("processCategory");
            String isUsed = request.getParameter("isUsed");
            String cycleTime = request.getParameter("cycleTime");
            String productCode = request.getParameter("productCode");
            String processCodeHidden = request.getParameter("processCodeHidden");
            
            // 공정 정보를 업데이트하는 SQL 쿼리
            String updateProcessSql = "UPDATE process SET process_name = ?, process_category = ?, is_used = ?, cycle_time = ?, product_code = ? WHERE process_code = ?";
            try (PreparedStatement updateProcessStmt = connection.prepareStatement(updateProcessSql)) {
                updateProcessStmt.setString(1, processName);
                updateProcessStmt.setString(2, processCategory);
                updateProcessStmt.setString(3, isUsed);
                updateProcessStmt.setString(4, cycleTime);
                updateProcessStmt.setString(5, productCode);
                updateProcessStmt.setString(6, processCodeHidden);
                updateProcessStmt.executeUpdate();
            }
 
          
          

           	// 요청 파라미터를 배열로 가져오기
            String[] underProcessData = request.getParameterValues("underProcessData");
            String[] processNameData = request.getParameterValues("processNameData");
            String[] productContentData = request.getParameterValues("productContentData");
            String[] imageData = request.getParameterValues("imageData");
            String[] processCodeData = request.getParameterValues("processCodeData");
            
            // 파라미터 검증
            if (underProcessData == null || processNameData == null ||
                productContentData == null || imageData == null || processCodeData == null) {
                throw new IllegalArgumentException("One or more parameters are missing.");
            }

            // 데이터 길이 확인
            if (underProcessData.length != processNameData.length ||
                underProcessData.length != productContentData.length ||
                underProcessData.length != imageData.length ||
                underProcessData.length != processCodeData.length) {
                throw new IllegalArgumentException("Parameter arrays have different lengths.");
            }        
         
             ProcessDAO2 dao2 = new ProcessDAO2();


            // 데이터베이스에 저장
            for (int i = 0; i < underProcessData.length; i++) {
                String[] underProcessItems = underProcessData[i].split(",");
                String[] processNameItems = processNameData[i].split(",");
                String[] productContentItems = productContentData[i].split(",");
                String[] imageItems = imageData[i].split(",");
                String[] processCodeItems = processCodeData[i].split(",");

                // 모든 항목의 길이 확인
                int maxLength = Math.max(Math.max(underProcessItems.length, processNameItems.length),
                                         Math.max(productContentItems.length, Math.max(imageItems.length, processCodeItems.length)));

                // 데이터베이스에 저장
                for (int j = 0; j < maxLength; j++) {
                    String underProcessData2 = j < underProcessItems.length ? underProcessItems[j] : "";
                    String processNameData2 = j < processNameItems.length ? processNameItems[j] : "";
                    String productContentData2 = j < productContentItems.length ? productContentItems[j] : "";
                    String imageData2 = j < imageItems.length ? imageItems[j] : "";
                    String processCodeData2 = j < processCodeItems.length ? processCodeItems[j] : "";

                    Process2 process2 = new Process2(underProcessData2, processNameData2, imageData2, productContentData2, processCodeData2);
                    try {
                        dao2.saveProcess(process2);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
           }

            // 트랜잭션 커밋
            connection.commit();

            response.sendRedirect("factory_Management");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("오류 발생!!!!!");

            // 오류 발생 시 트랜잭션 롤백
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            	// 이미 사용한 Connection 객체를 롤백
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException rollbackEx) {
            	 rollbackEx.printStackTrace();
            }
            // 오류 페이지로 리디렉션
            response.sendRedirect("factory_Management");
        }
    }
}
