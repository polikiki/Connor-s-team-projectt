package emp2.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import emp2.dto.EmpDTO;

@WebServlet("/emp2")
public class Emp2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/emp2 doGet 실행");
		String Stno = request.getParameter("ename");
		String ename = (Stno != null) ? Stno : null;
		
		try {
			// # DB에서 emp2 조회하기
			
			// ## DB 접속시작
			// JNDI 방식으로 
			// Servers 폴더의 context.xml 중 Resource 태그(노드)를 가져온다
			// 거기에는 DB 정보가 있다
			// 그걸로 DataSource만든다
			// DataSource가 커넥션 풀이라고 생각하면 된다
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			// 커넥션 풀에서 접속 정보를 가져온다
			Connection con = dataSource.getConnection();
			// ## DB 접속 끝
			
			// SQL 준비
			String query =  " SELECT * FROM emp2";
			
			if(ename != null) {
				query = "SELECT * FROM emp2 where ename=?";
				
			}else {
				query = " SELECT * FROM emp2";
			}
			
			PreparedStatement ps = con.prepareStatement(query);
			if(ename != null) {
			ps.setString(1, ename);
			}else {
				
			}
			// SQL 실행 및 결과 확보
			// 	executeQuery : select문 실행
			//	resultSet: select문 조회 결과 전체 : 엑셀처럼 테이블 느낌 
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			// 		한줄 한줄을 DTO에 넣기]
			//		그렇게 만들어진 DTO를 List에 넣기
			
			List list = new ArrayList();
			// rs.next() : 다음 줄로 커서를 이동한다
			// 다음줄이 있다면 true를, 없으면 false를 돌려줌
			// 다음줄이 있으면 rs는 다음줄 덩어러 : table의 tr 한줄, 1차원 배열(한줄)
			while(rs.next()) {
				EmpDTO empDTO = new EmpDTO();
				// 이번 줄에서 empno 컬럼의 값을 int로 형변환해서 가져옴
				
				empDTO.setEmpno(rs.getInt("empno"));
				
				empDTO.setEname(ename);
				
				empDTO.setJob(rs.getString("job"));
				empDTO.setHireDate(rs.getDate("hiredate"));
				
				list.add(empDTO);
			}
			
			// request 자체는 브라우저에서 서버로 요청한 모든 정보가 있는 곳 
			// 거기에다 우리 List도 담아 두자
			request.setAttribute("list", list);
			System.out.println("list.size:"+list);
			// # JSP로 forward로 보내주기
			// forward 방식은 request도 전달해줌
			// 그래서 list를 request에 넣었던 것임!!
			request
				.getRequestDispatcher("/WEB-INF/views/empList.jsp")
				.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// DB에서 emp2 조회하기
		
		// JSP로 보여주기
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
