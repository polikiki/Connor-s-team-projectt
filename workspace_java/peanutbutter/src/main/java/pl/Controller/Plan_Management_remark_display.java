package pl.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.DTO.Plan_ManagementDTO;
import pl.service.Plan_ManagementService;
import pl.service.Plan_Management_Page_Service;


@WebServlet("/remarks")
public class Plan_Management_remark_display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String plan_number = request.getParameter("plan_number");
		System.out.println("plan_number: "+ plan_number);
		
		Plan_ManagementService plService = new Plan_ManagementService();
		Plan_ManagementDTO dto = plService.get(plan_number);
		
		request.setAttribute("dto", dto);
		
		System.out.println("dto"+ dto);
		
		
		request.getRequestDispatcher("/WEB-INF/views/memo.jsp").forward(request, response);
		
	}

	
}
