package factory_management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ProcessServlet3")
public class ProcessServlet3 extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8;");
		String processCode5 = request.getParameter("processCode5");
		System.out.println(processCode5);
	}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/factoryReg.jsp").forward(request, response); 
    }
}
