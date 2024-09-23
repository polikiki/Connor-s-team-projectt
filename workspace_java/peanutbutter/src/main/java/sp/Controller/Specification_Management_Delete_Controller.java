package sp.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sp.service.Specification_ManagementService;

@WebServlet("/delete_sp")
public class Specification_Management_Delete_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String specification_number = request.getParameter("specification_numbers");
		
//		List list = Arrays.asList(product_code.split(","));
		String[] specification_numbers = specification_number.split(",");
		
		System.out.println("specification_numbers :"+specification_numbers[0]);
		
		Specification_ManagementService spService = new Specification_ManagementService();
		int result = spService.delete(specification_numbers);
		System.out.println("삭제 개수 :"+ result);
		
		response.sendRedirect("sp");
	}

}
