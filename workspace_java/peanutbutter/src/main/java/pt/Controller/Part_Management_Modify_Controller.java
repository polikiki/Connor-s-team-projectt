package pt.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pt.DTO.Part_ManagementDTO;
import pt.service.Part_ManagementService;

@WebServlet("/modify_pt")
public class Part_Management_Modify_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/modify_pt doGet 실행");
		
		String part_code = request.getParameter("part_code");
		System.out.println("part_code: "+ part_code);
		
		Part_ManagementService ptService = new Part_ManagementService();
		Part_ManagementDTO dto = ptService.get(part_code);
		
		request.setAttribute("dto", dto);
		System.out.println("dto :"+ dto);
		request.getRequestDispatcher("/WEB-INF/views/PTModify.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/modify_pt doPost 실행");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		// 전달인자 받기		
		String pt_code = request.getParameter("pt_code");
		String pt_name = request.getParameter("pt_name");
		String pt_image = request.getParameter("pt_image");
		String pt_unit = request.getParameter("pt_unit");
		String pt_standard = request.getParameter("pt_standard");
		String pt_modelname = request.getParameter("pt_modelname");
		String pt_sort= request.getParameter("pt_sort");
		String vendor1= request.getParameter("vendor1");
		String vendor2= request.getParameter("vendor2");
		String recwarehouse= request.getParameter("recwarehouse");
		String pt_barcode= request.getParameter("pt_barcode");
				
		// 전달인자를 DTO에 담기
		Part_ManagementDTO dto = new Part_ManagementDTO();
		dto.setPart_code(pt_code);
		dto.setPart_name(pt_name);
		dto.setPart_image(pt_image);
		dto.setPart_unit(pt_unit);
		dto.setPart_standard(pt_standard);
		dto.setPart_modelname(pt_modelname);
		dto.setPart_sort(pt_sort);
		dto.setPart_vendor1(vendor1);
		dto.setPart_vendor2(vendor2);
		dto.setReceving_warehouse(recwarehouse);
		dto.setPart_barcode(pt_barcode);
				
				// DTO를 service로 보내서 결과 받기
				Part_ManagementService ptService = new Part_ManagementService();
				int result = ptService.modify(dto);
				System.out.println("modify 결과 :"+ result);
				
				response.sendRedirect("pt");
	}

}
