package org.zerock.w1.todo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.w1.todo.dto.TodoDTO;
import org.zerock.w1.todo.service.TodoService;


@WebServlet("/todo/modify")
public class TodoModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("todo/modify doGet실행");
		int tno = Integer.parseInt(request.getParameter("tno"));		
		System.out.println("tno"+ tno);
		
		TodoService todoService = new TodoService();
		TodoDTO dto = todoService.get(tno);
		
		request.setAttribute("todo", dto);
		
		request.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(request, response);
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
