package sp.Controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.service.Plan_ManagementService;
import product_stock.service.Product_Stock_ManagementService;
import sp.DTO.Specification_ManagementDTO;
import sp.service.Specification_ManagementService;

@WebServlet("/update_sp")
public class Specification_Management_Update_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/update_sp doPutt 실행");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		String specification_status = request.getParameter("specification_status");
		String specification_number = request.getParameter("specification_number");
		
		System.out.println("specification_status :"+specification_status);
		System.out.println("specification_number :"+specification_number);
		
		
		
		Specification_ManagementDTO dto = new Specification_ManagementDTO();
		
		dto.setSpecification_status(specification_status);
		dto.setSpecification_number(specification_number);
		
		// DTO를 service로 보내서 결과 받기
		Specification_ManagementService spService = new Specification_ManagementService();
		int result = spService.modify(dto);
		System.out.println("modify 결과2 :"+ result);
		
		Product_Stock_ManagementService pm_stockService = new Product_Stock_ManagementService();
		
		List<Specification_ManagementDTO> list = pm_stockService.getSP_data();
		
		// 해당 DAO의SQL문을 사용하면 이전데이터가 중첩되는 현상이 일어나기 때문에
		// SELECT 문을 변경된 대상하나를 지정해서 불러오고 그 값을 UPDATE에 이용하여
		// 더하는 방식으로 사용하는 것이 좋다
		System.out.println("list :"+ list);
		
		for (Specification_ManagementDTO dto1 : list) {
		    
			String specification = dto1.getSpecification_number();
			String product_code = dto1.getProduct_code();
			Integer plan_amount = dto1.getPlan_amount();
			
			System.out.println("specification :"+ specification);
			System.out.println("product_code :"+ product_code);
			System.out.println("plan_amount :"+ plan_amount);
			
			
			
//			int result1 = spService.update(specification);
			
		}
		
		request.getRequestDispatcher("/insert_pm_stock").forward(request, response);
	}
}
