package factory_management;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProcessServlet3")
public class ProcessServlet3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트로부터 processCode5 파라미터를 받는다.
        String processCode5 = request.getParameter("processCode5");
        request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8;");
        String jspPath = "/WEB-INF/views/factoryDetail.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPath);
        dispatcher.forward(request, response);        
    }
}