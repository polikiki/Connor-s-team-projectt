package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;


@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("삭제");
		
		String str_bno = request.getParameter("bno");
		int bno = Integer.parseInt(str_bno);
		
		BoardService boardService = new BoardService();
		int result = boardService.delete(bno);
		
		response.sendRedirect("/peanutbutter/board");
		
	}

}
