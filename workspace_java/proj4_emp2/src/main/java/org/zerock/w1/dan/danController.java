package org.zerock.w1.dan;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dan")
public class danController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet dan실행");
		int dan = Integer.parseInt(request.getParameter("number"));
		System.out.println("dan : "+ dan);
		List<String> list = new ArrayList<>();
		
		for( int i=1; i<10; i++) {
			StringBuilder result = new StringBuilder();
			result.append(dan).append("x").append(i).append(" = ").append(dan * i).append("\n");
			list.add(result.toString());
		}
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/print_dan.jsp").forward(request, response);
		
	}

}
