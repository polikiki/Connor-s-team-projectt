package pl.Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.DTO.Plan_ManagementDTO;
import pl.service.Plan_ManagementService;


@WebServlet("/insert_pl")
public class plan_Management_Insert_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Plan_ManagementService plService = new Plan_ManagementService(); // pageService 및 DAO를 만들면서 PMList에서는 쓸일이 없어 졌음
		List list = plService.getPM_data();
		
		request.setAttribute("list", list);
		
		System.out.println("list :"+ list);
		
		request.getRequestDispatcher("/WEB-INF/views/PLinsert.jsp").forward(request, response);
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/insert_pt doPost 실행");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		// 전달인자 받기
		String pm_name = request.getParameter("pm_name");
		String pm_code = request.getParameter("pm_code");
		String pl_amount = request.getParameter("pl_amount");
		String date_start = request.getParameter("date_start");
		String date_end= request.getParameter("date_end");
		String remarks= request.getParameter("remarks");
		
		// 전달인자를 DTO에 담기
		Plan_ManagementDTO dto = new Plan_ManagementDTO();
		dto.setProduct_name(pm_name);
		dto.setProduct_code(pm_code);
		dto.setPlan_amount(Integer.parseInt(pl_amount));
		dto.setPlan_start_date(Date.valueOf(date_start));
		dto.setPlan_end_date(Date.valueOf(date_end));
		dto.setPlan_remarks(remarks);
		// DTO를 service로 보내서 결과 받기
		Plan_ManagementService plService = new Plan_ManagementService();
		int result = plService.insertPL(dto);
		
		System.out.println("insert 결과 :"+ result);
		
		response.sendRedirect("pl");
		
	}

}
