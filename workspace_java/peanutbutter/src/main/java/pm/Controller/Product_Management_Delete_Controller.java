package pm.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pm.service.Product_ManagementService;

@WebServlet("/delete")
public class Product_Management_Delete_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String product_code = request.getParameter("product_codes");
		
//		List list = Arrays.asList(product_code.split(","));
		String[] product_codes = product_code.split(",");
		
		Product_ManagementService pmService = new Product_ManagementService();
		int result = pmService.delete(product_codes);
		System.out.println("삭제 개수 :"+ result);
		
		response.sendRedirect("pm");
	}

}
