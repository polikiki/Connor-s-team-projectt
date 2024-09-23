package sp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import pm.DTO.Product_ManagementDTO;
import sp.DTO.Specification_ManagementDTO;
import pl.DAO.LoggableStatement;
import pl.DTO.Plan_ManagementDTO;


public class Specification_ManagementDAO {

	private Connection getConnection() {
		
		Connection con = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
		String user = "scott2_9";
		String password = "tiger";
		
		try {
			// Class.forName : String을 이용해서 class를 생성한다
			// 드라이버 : 서로 다른 것들(java, oracle)이 소통할 수 있게 해주는 것
			// 오라클 드라이버 로딩
			Class.forName(driver);
			
			// DB 접속
			con = DriverManager.getConnection(url, user, password);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public Specification_ManagementDTO selectOne(String specification_number) {
		Specification_ManagementDTO spDTO = null;
		
		// DB 접속
		Connection con = getConnection();
		
if(con == null) return null;
		
		try {
			
			// sql 준비
			String sql = "SELECT * FROM TABLE_SP where Specification_number = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			// ?를 값으로 채워줌
			// 첫번째 전달인자는 ?의 순서
			// 만약에 글씨라면 setString, 알아서 '로 감싸준다
			ps.setString(1, specification_number);
			
			// sql 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			if( rs.next() ) {
				spDTO = new Specification_ManagementDTO();
				spDTO.setSpecification_number(rs.getString("specification_number"));
				spDTO.setProduct_name(rs.getString("product_name"));
				spDTO.setPlan_start_date(rs.getDate("plan_start_date"));
				spDTO.setPlan_end_date(rs.getDate("plan_end_date"));
				spDTO.setPlan_reg_date(rs.getDate("plan_reg_date"));
				spDTO.setPlan_amount(rs.getInt("plan_amount"));
				spDTO.setSpecification_status(rs.getString("specification_status"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return spDTO;
	}
	
	public int insertSP(Plan_ManagementDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String query = " INSERT INTO TABLE_SP (SPECIFICATION_NUMBER, PRODUCT_CODE, PRODUCT_NAME, PLAN_START_DATE, PLAN_END_DATE, PLAN_REG_DATE, PLAN_AMOUNT)";
			       query +=" VALUES (SEQ_SP_SEQUENCE.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?)";
			       
			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setString(1, dto.getProduct_code());
			ps.setString(2, dto.getProduct_name());
			ps.setDate(3, dto.getPlan_start_date());
			System.out.println("dto.getPlan_start_date() :"+ dto.getPlan_start_date());
			ps.setDate(4, dto.getPlan_end_date());
			ps.setInt(5, dto.getPlan_amount());
			
			// 실제 실행되는 sql을 출력해볼 수 있다
			System.out.println( ( (LoggableStatement)ps ).getQueryString() );
			
			// SQL 실행
			result = ps.executeUpdate();
			
			ps.close();
			con.close();	// 커넥션풀에 접속정보 반환
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int deletOne(String[] specification_numbers) {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
			String query = "delete from TABLE_SP where specification_number in (";
			
			for(int i=0; i< specification_numbers.length; i++) {
				query += "?";
				if(i < specification_numbers.length-1) {
					query +=",";
				}
			}
				query += ")";
			
			System.out.println("for문으로 만든 query: "+ query);
			
			PreparedStatement ps = con.prepareStatement(query);
			
			for(int i=0; i< specification_numbers.length; i++) {
				
				ps.setString(i+1,specification_numbers[i]);
			}
			
			
			// SQL 실행
			result = ps.executeUpdate();
			
			ps.close();
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int modify(Specification_ManagementDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String query =  "UPDATE TABLE_SP SET";
     	   	query += " SPECIFICATION_STATUS = ?";
     	   	query += " WHERE SPECIFICATION_NUMBER = ?";
			       
			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setString(1, dto.getSpecification_status());
			ps.setString(2, dto.getSpecification_number());
			
			// 실제 실행되는 sql을 출력해볼 수 있다
			System.out.println( ( (LoggableStatement)ps ).getQueryString() );
			
			// SQL 실행
			result = ps.executeUpdate();
			
			ps.close();
			con.close();	// 커넥션풀에 접속정보 반환
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Specification_ManagementDTO getUpdate(String specificationNumber) {
		Specification_ManagementDTO dto = null;
		
		try {
			Context ctx = new InitialContext();
	        DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
	        Connection con = dataSource.getConnection();
	        
	        String query = "SLECT SPECIFICATION_NUMBER, PRODUCT_CODE, PLAN_START_DATE, PLAN_AMOUNT, SPECIFICATION_STATUS FROM TABLE_SP WHERE SPECIFICATION_NUMBER = ? ";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, specificationNumber);
	        
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            dto = new Specification_ManagementDTO();
	            dto.setSpecification_number(rs.getString("SPECIFICATION_NUMBER"));
	            dto.setSpecification_number(rs.getString("SPECIFICATION_NUMBER"));
	            dto.setSpecification_number(rs.getString("SPECIFICATION_NUMBER"));
	            dto.setSpecification_number(rs.getString("SPECIFICATION_NUMBER"));
	            dto.setSpecification_status(rs.getString("SPECIFICATION_STATUS"));
	            // 기타 필요한 필드도 추가 설정
	        }

	        rs.close();
	        ps.close();
	        con.close();  
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
}
