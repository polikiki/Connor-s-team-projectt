package product_stock_Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sp.DTO.Specification_ManagementDTO;

@WebServlet("/insert_pm_stock")
public class Product_Stock_Management_Insert_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		String specification_status = request.getParameter("specification_status");
		System.out.println("specification_status2 :"+ specification_status);
		
		
		
	}

		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
