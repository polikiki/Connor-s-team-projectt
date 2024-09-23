package product_stock_Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pm.service.Product_ManagementService;
import product_stock.service.Product_Stock_ManagementService;

@WebServlet("/delete_pm_stock")
public class Product_Stock_Management_Delete_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String product_code = request.getParameter("product_codes");
		
//		List list = Arrays.asList(product_code.split(","));
		String[] product_codes = product_code.split(",");
		
		Product_Stock_ManagementService pmService = new Product_Stock_ManagementService();
		int result = pmService.delete(product_codes);
		System.out.println("삭제 개수 :"+ result);
		
		response.sendRedirect("pm_stock");
	}
}
