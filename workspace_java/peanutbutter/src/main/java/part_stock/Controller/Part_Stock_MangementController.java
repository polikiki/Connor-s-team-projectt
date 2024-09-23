package part_stock.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import part_stock.service.Part_Stock_Management_Page_Service;
import part_stock.service.Part_Stock_Management_Page_Service;


@WebServlet("/pt_stock")
public class Part_Stock_MangementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/pt_stock doget 실행");
		
		// 한 페이지당 개수
		String countPerPage = request.getParameter("countPerPage");
		// 현재 페이지
		String page = request.getParameter("page");
		
		// 검색창의 입력 데이터 받기 
		String search = request.getParameter("search");
		System.out.println("검색창 입력 :" + search);
		
		// select 문의 option 값 받기
		String optionvalue = request.getParameter("optionvalue");
		System.out.println("select 문의 option값 :" + optionvalue);
						
		// 혹시 받은게 없다면 기본값 세팅
		if(countPerPage == null) countPerPage = "5";
		if(page == null) page = "1";
						
		
//		Product_ManagementService pmService = new Product_ManagementService(); // pageService 및 DAO를 만들면서 PMList에서는 쓸일이 없어 졌음
//		List list = pmService.getPM(Product_Code);
		
		Part_Stock_Management_Page_Service pt_stock_PageService = new Part_Stock_Management_Page_Service();
		Map map = pt_stock_PageService.get_pt_stockPage(countPerPage, page, search, optionvalue);
		
		map.put("search", search);
		map.put("optionvalue", optionvalue);
		
//		request.setAttribute("list", list); // pageService 및 DAO를 만들면서 PMList에서는 쓸일이 없어 졌음
		
		request.setAttribute("map", map);
		System.out.println("map :"+ map);
		System.out.println("map.list :"+ map.get("list"));
		request.setAttribute("countPerPage", countPerPage);
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/WEB-INF/views/PT_Stock_List.jsp").forward(request, response);
		
	}
}
