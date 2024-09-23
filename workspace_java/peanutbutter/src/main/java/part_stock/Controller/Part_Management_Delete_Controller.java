package part_stock.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import part_stock.service.Part_Stock_ManagementService;
import pt.service.Part_ManagementService;

@WebServlet("/delete_pt_stock")
public class Part_Management_Delete_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String part_code = request.getParameter("part_codes");
		
//		List list = Arrays.asList(product_code.split(","));
		String[] part_codes = part_code.split(",");
		
		System.out.println("part_codes :"+part_codes[0]);
		
		Part_Stock_ManagementService pt_stock_Service = new Part_Stock_ManagementService();
		int result = pt_stock_Service.delete(part_codes);
		System.out.println("삭제 개수 :"+ result);
		
		response.sendRedirect("pt_stock");
	}

}
