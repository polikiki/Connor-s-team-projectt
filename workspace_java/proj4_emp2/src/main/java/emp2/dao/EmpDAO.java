package emp2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import emp2.dto.EmpDTO;

public class EmpDAO {

	public List selectEmp(String ename) {
		List list = new ArrayList();
		
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
				
			}
			
			PreparedStatement ps = con.prepareStatement(query);
			if(ename != null) {
			ps.setString(1, ename);
			}
			// SQL 실행 및 결과 확보
			// 	executeQuery : select문 실행
			//	resultSet: select문 조회 결과 전체 : 엑셀처럼 테이블 느낌 
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			// 		한줄 한줄을 DTO에 넣기
			//		그렇게 만들어진 DTO를 List에 넣기
			
			// rs.next() : 다음 줄로 커서를 이동한다
			// 다음줄이 있다면 true를, 없으면 false를 돌려줌
			// 다음줄이 있으면 rs는 다음줄 덩어러 : table의 tr 한줄, 1차원 배열(한줄)
			while(rs.next()) {
				EmpDTO empDTO = new EmpDTO();
				// 이번 줄에서 empno 컬럼의 값을 int로 형변환해서 가져옴
				
				empDTO.setEmpno(rs.getInt("empno"));
				
				empDTO.setEname(rs.getString("ename"));
				
				empDTO.setJob(rs.getString("job"));
				empDTO.setHireDate(rs.getDate("hiredate"));
				
				list.add(empDTO);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int insertEmp(EmpDTO dto) {
		int result = -1; 
		
		// DB 접속
		
		// SQL 준비
		
		// SQL 실행
		
		try {
			
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			// 커넥션 풀에서 접속 정보를 가져온다
			Connection con = dataSource.getConnection();
			// ## DB 접속 끝
			
			// SQL 준비
			String query =  " INSERT INTO";
					query += " emp2 (empno, ename, job, mgr, hireDate, sal, comm, deptno)";
					query += "VALUES (?,?,?,?,?,?,?,?)";
			
//			PreparedStatement ps = con.prepareStatement(query);
					
			//  원래 실행되는걸 LoggableStatement가 가로채서 
			PreparedStatement ps = new LoggableStatement(con,query);
			
			ps.setInt(1, dto.getEmpno());
			
			ps.setString(2, dto.getEname());
			
			ps.setString(3, dto.getJob());
			
			ps.setInt(4, dto.getMgr());
			
			ps.setDate(5, dto.getHireDate());
			
			ps.setInt(6, dto.getSal());
			
			ps.setInt(7, dto.getComm());
			
			ps.setInt(8, dto.getDeptno());
			
			result = ps.executeUpdate();
			
			ps.close();
			con.close();  // 커넥션풀에 접속정보 반환
			
			// 실제 실행되는 sql을 출력해 볼 수 있다
			System.out.println(((LoggableStatement)ps).getQueryString());
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int deleteOne(String ename) {
		int result = -1;
		
		try {
			
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			// 커넥션 풀에서 접속 정보를 가져온다
			Connection con = dataSource.getConnection();
			// ## DB 접속 끝
			
			// SQL 준비
			String query =  " delete from emp2 where ename = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,ename);
			
			System.out.println(ename);
			
			result = ps.executeUpdate();
			
			ps.close();
			con.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
