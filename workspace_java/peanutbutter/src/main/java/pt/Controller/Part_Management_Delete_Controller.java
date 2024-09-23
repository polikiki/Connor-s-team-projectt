package pt.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pt.service.Part_ManagementService;

@WebServlet("/delete_pt")
public class Part_Management_Delete_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String part_code = request.getParameter("part_codes");
		
//		List list = Arrays.asList(product_code.split(","));
		String[] part_codes = part_code.split(",");
		
		Part_ManagementService ptService = new Part_ManagementService();
		int result = ptService.delete(part_codes);
		System.out.println("삭제 개수 :"+ result);
		
		response.sendRedirect("pt");
	}

}
