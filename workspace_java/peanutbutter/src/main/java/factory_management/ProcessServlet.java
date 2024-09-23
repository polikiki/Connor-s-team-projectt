package factory_management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ProcessServlet")
public class ProcessServlet extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8;");
		String processCode = request.getParameter("processCode");
	    String processName = request.getParameter("processName");
	    String processCategory = request.getParameter("processCategory");
	    String isUsed = request.getParameter("isUsed");
	    String cycleTime = request.getParameter("cycleTime");
	    String productCode = request.getParameter("productCode");
	    // 가져온 데이터를 DAO로 전달하여 데이터베이스에 저장합니다.
	    ProcessDAO dao = new ProcessDAO();
	    Process process = new Process(processCode, processName, processCategory, isUsed, cycleTime, productCode);
	    try {
	        dao.saveProcess(process);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	
	    response.sendRedirect("factory_Management");
	}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/factoryReg.jsp").forward(request, response); 
    }
}