package jaego;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.service.Plan_ManagementService;
import product_stock.service.Product_Stock_ManagementService;
import sp.DTO.Specification_ManagementDTO;

@WebServlet("/pf")
public class Product_Performance extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
Product_Stock_ManagementService pm_stockService = new Product_Stock_ManagementService();
		
		List list = pm_stockService.getPL_data();
		
		request.setAttribute("list", list);
		
		System.out.println("list :"+ list);
	
		request.getRequestDispatcher("/WEB-INF/views/Production performance.jsp").forward(request, response);
	
	
	}
}
