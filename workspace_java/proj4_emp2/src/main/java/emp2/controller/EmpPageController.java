package emp2.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp2.service.EmpPageService;
import emp2.service.EmpService;

@WebServlet("/emp/page")
public class EmpPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/emp doGet 실행");
		
		// 한 페이지당 개수
		String countPerPage = request.getParameter("countPerPage");
		// 현재 페이지
		String page = request.getParameter("page");
		
		// 혹시 받은게 없다면 기본값 세팅
		if(countPerPage == null) countPerPage = "10";
		if(page == null) page ="1";
		
		EmpPageService empPageService = new EmpPageService();
		Map map = empPageService.getEmpPage(countPerPage, page);
		
		request.setAttribute("map",map);
		request.setAttribute("countPerPage",countPerPage);
		request.setAttribute("page",page);
		
//		EmpService empService = new EmpService();
//		List list = empService.getEmp(empno2, countPerPage, page);
//		
//		// request 자체는 브라우저에서 서버로 요청한 모든 정보가 있는 곳 
//					// 거기에다 우리 List도 담아 두자
//					request.setAttribute("list", list);
//					System.out.println("list.size:"+list);
//					// # JSP로 forward로 보내주기
//					// forward 방식은 request도 전달해줌
//					// 그래서 list를 request에 넣었던 것임!!
					request
						.getRequestDispatcher("/WEB-INF/views/empPageList.jsp")
						.forward(request, response);
					
		
	}

}
