package pl.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.service.Plan_ManagementService;

@WebServlet("/delete_pl")
public class Plan_Management_Delete_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String plan_number = request.getParameter("plan_numbers");
		
//		List list = Arrays.asList(product_code.split(","));
		String[] plan_numbers = plan_number.split(",");
		
		Plan_ManagementService plService = new Plan_ManagementService();
		int result = plService.delete(plan_numbers);
		System.out.println("삭제 개수 :"+ result);
		
		response.sendRedirect("pl");
	}

}
