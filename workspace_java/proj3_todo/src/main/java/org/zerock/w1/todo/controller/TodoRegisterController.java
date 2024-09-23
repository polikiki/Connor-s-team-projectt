package org.zerock.w1.todo.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.w1.todo.dto.TodoDTO;
import org.zerock.w1.todo.service.TodoService;

@WebServlet("/todo/register")
public class TodoRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/todo/register doGet 실행");
		
		request.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/todo/register doPost 실행");
		
		// 요청 내용의 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
								
		// 응답 내용의 한글 깨짐 방지
		response.setContentType("text/html; charset=UTF-8;");
		
		String title = request.getParameter("title");
		String dueDate = request.getParameter("dueDate");
		String finished = request.getParameter("finished");
		
		TodoDTO todoDTO = new TodoDTO();
		todoDTO.setTitle(title);
		todoDTO.setDueDate(LocalDate.parse(dueDate));
		if("N".equals(finished)) {
			todoDTO.setFinished(false);
		}else {
			todoDTO.setFinished(true);
		}
		
		System.out.println(todoDTO);
		
		// db의 insert까지 실행
		TodoService todoService = new TodoService();
		int result = todoService.register(todoDTO);
		System.out.println("insert 결과 : "+ result);
		
		// 목록으로 보내기
//		response.sendRedirect("list");
//		response.sendRedirect("/proj3_todo/todo/list");
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/todo/list");
	}

}
