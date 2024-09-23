package pl.Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.DTO.Plan_ManagementDTO;
import pl.service.Plan_ManagementService;

@WebServlet("/modify_pl")
public class Plan_Management_Modify_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/modify_pl doGet 실행");
		
		String plan_number = request.getParameter("plan_number");
		System.out.println("plan_number: "+ plan_number);
		
		String product_code = request.getParameter("product_code");
		System.out.println("product_code: "+ product_code);
		
		Plan_ManagementService plService = new Plan_ManagementService();
		Plan_ManagementDTO dto = plService.get(plan_number);
		List list = plService.getPM_data_one(product_code);
		
		request.setAttribute("list", list);
		request.setAttribute("dto", dto);
		
		System.out.println("list :"+ list);
		System.out.println("dto :"+ dto);
		
		request.getRequestDispatcher("/WEB-INF/views/PLModify.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/modify_pt doPost 실행");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		// 전달인자 받기
		String pl_number = request.getParameter("pl_number");
		String pm_name = request.getParameter("pm_name");
		String pm_code = request.getParameter("pm_code");
		String pl_amount = request.getParameter("pl_amount");
		String date_start = request.getParameter("date_start");
		String date_end= request.getParameter("date_end");
		String remarks= request.getParameter("remarks");
				
		// 전달인자를 DTO에 담기
		Plan_ManagementDTO dto = new Plan_ManagementDTO();
		dto.setPlan_number(pl_number);
		dto.setProduct_name(pm_name);
		dto.setProduct_code(pm_code);
		dto.setPlan_amount(Integer.parseInt(pl_amount));
		dto.setPlan_start_date(Date.valueOf(date_start));
		dto.setPlan_end_date(Date.valueOf(date_end));
		dto.setPlan_remarks(remarks);
				
				// DTO를 service로 보내서 결과 받기
				Plan_ManagementService plService = new Plan_ManagementService();
				int result = plService.modify(dto);
				System.out.println("modify 결과 :"+ result);
				
				response.sendRedirect("pl");
	}

}
