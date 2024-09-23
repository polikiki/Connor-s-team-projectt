package factory_management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ProcessServlet2")
public class ProcessServlet2 extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8;");
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

        // 데이터 개별적으로 처리
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

        // 리디렉션
        response.sendRedirect("factory_Management");
        
    }
}