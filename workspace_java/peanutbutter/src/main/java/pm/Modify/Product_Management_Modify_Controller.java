package pm.Modify;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pm.DTO.Product_ManagementDTO;
import pm.service.Product_ManagementService;

@WebServlet("/modify")
public class Product_Management_Modify_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/modify doGet 실행");
		
		String product_code = request.getParameter("product_code");
		System.out.println("product_code: "+ product_code);
		
		Product_ManagementService pmService = new Product_ManagementService();
		Product_ManagementDTO dto = pmService.get(product_code);
		
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("/WEB-INF/views/PMModify.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/modify doPost 실행");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		// 전달인자 받기
				String pmcode = request.getParameter("pmcode");
				String pmname = request.getParameter("pmname");
				String pmimage = request.getParameter("pmimage");
				String unit = request.getParameter("unit");
				String standard = request.getParameter("standard");
				String leadtime = request.getParameter("leadtime");
				String barcode= request.getParameter("barcode");
				String lotsize= request.getParameter("lotsize");
				String spwarehouse= request.getParameter("spwarehouse");
				
				// 전달인자를 DTO에 담기
				Product_ManagementDTO dto = new Product_ManagementDTO();
				dto.setProduct_code(pmcode);
				System.out.println("pmcode :"+ pmcode);
				dto.setProduct_name(pmname);
				dto.setProduct_image(pmimage);
				dto.setUnit(unit);
				dto.setStandard(standard);
				dto.setLead_time(Integer.parseInt(leadtime));
				dto.setBarcode(barcode);
				dto.setLot_size(Integer.parseInt(lotsize));
				dto.setShipping_warehouse(spwarehouse);
				
				// DTO를 service로 보내서 결과 받기
				Product_ManagementService pmService = new Product_ManagementService();
				int result = pmService.modify(dto);
				System.out.println("modify 결과 :"+ result);
				
				response.sendRedirect("pm");
	}

}
