package pl.DAO;

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
import pt.DTO.Part_ManagementDTO;
import pl.DAO.LoggableStatement;
import pl.DTO.Plan_ManagementDTO;

public class Plan_ManagementDAO {

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
	
	public List selectPM_data() {
		List list = new ArrayList();
		
		try {
			
			// # DB에서 Table_PM 조회하기
			
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			Connection con = dataSource.getConnection();
			
			// SQL 준비
			String query = null;
			PreparedStatement ps = null;
			
			
				query = " SELECT PRODUCT_CODE, PRODUCT_NAME, UNIT, SHIPPING_WAREHOUSE FROM TABLE_PM";
			
				ps = con.prepareStatement(query);
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			while( rs.next()) {
				Product_ManagementDTO pmDTO = new Product_ManagementDTO();
				
				String product_code = rs.getString("product_code");
				pmDTO.setProduct_code(product_code);
				
				
				String product_name = rs.getString("product_name");
				pmDTO.setProduct_name(product_name);
				
				String unit = rs.getString("unit");
				pmDTO.setUnit(unit);
				
				String shipping_warehouse = rs.getString("shipping_warehouse");
				pmDTO.setShipping_warehouse(shipping_warehouse);
				
				list.add(pmDTO);
			}	
			
			ps.close();
			con.close();
			
		}catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List selectPM_data_one(String product_code1) {
		List list = new ArrayList();
		
		try {
			
			// # DB에서 Table_PM 조회하기
			
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			Connection con = dataSource.getConnection();
			
			// SQL 준비
			String query = null;
			PreparedStatement ps = null;
			
			if(product_code1 == null) {
				query = " SELECT * FROM TABLE_PM";
			} else if(product_code1 != null) {
				query = " SELECT * FROM TABLE_PM where Product_Code = ?";
			}
			ps = con.prepareStatement(query);
			
			if(product_code1 != null) {
			ps.setInt(1, Integer.parseInt(product_code1));
			}
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			while( rs.next()) {
				Product_ManagementDTO pmDTO = new Product_ManagementDTO();
				
				String product_code = rs.getString("product_code");
				pmDTO.setProduct_code(product_code);
				
				
				String product_name = rs.getString("product_name");
				pmDTO.setProduct_name(product_name);
				
				String unit = rs.getString("unit");
				pmDTO.setUnit(unit);
				
				String shipping_warehouse = rs.getString("shipping_warehouse");
				pmDTO.setShipping_warehouse(shipping_warehouse);
				
				list.add(pmDTO);
			}	
			
			ps.close();
			con.close();
			
		}catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Plan_ManagementDTO selectOne(String plan_number) {
		Plan_ManagementDTO plDTO = null;
		
		// DB 접속
		Connection con = getConnection();
		
if(con == null) return null;
		
		try {
			
			// sql 준비
			String sql = "SELECT * FROM TABLE_PL where Plan_number = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			// ?를 값으로 채워줌
			// 첫번째 전달인자는 ?의 순서
			// 만약에 글씨라면 setString, 알아서 '로 감싸준다
			ps.setString(1, plan_number);
			
			// sql 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			if( rs.next() ) {
				plDTO = new Plan_ManagementDTO();
				plDTO.setPlan_number(rs.getString("plan_number"));
				plDTO.setProduct_code(rs.getString("product_code"));
				plDTO.setProduct_name(rs.getString("product_name"));
				plDTO.setPlan_start_date(rs.getDate("plan_start_date"));
				plDTO.setPlan_end_date(rs.getDate("plan_end_date"));
				plDTO.setPlan_amount(rs.getInt("plan_amount"));
				plDTO.setPlan_remarks(rs.getString("plan_remarks"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return plDTO;
	}
	
	public int insertPL(Plan_ManagementDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String query = " INSERT INTO TABLE_PL (PLAN_NUMBER, PRODUCT_CODE, PRODUCT_NAME, PLAN_START_DATE, PLAN_END_DATE, PLAN_AMOUNT, PLAN_REMARKS)";
			       query +=" VALUES (SEQ_PM_SEQUENCE.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			       
			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setString(1, dto.getProduct_code());
			ps.setString(2, dto.getProduct_name());
			ps.setDate(3, dto.getPlan_start_date());
			ps.setDate(4, dto.getPlan_end_date());
			ps.setInt(5, dto.getPlan_amount());
			ps.setString(6, dto.getPlan_remarks());
			
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
	
	public int deletOne(String[] plan_numbers) {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
			String query = "delete from TABLE_PL where PLAN_NUMBER in (";
			
			for(int i=0; i< plan_numbers.length; i++) {
				query += "?";
				if(i < plan_numbers.length-1) {
					query +=",";
				}
			}
				query += ")";
			
			System.out.println("for문으로 만든 query: "+ query);
			
			PreparedStatement ps = con.prepareStatement(query);
			
			for(int i=0; i< plan_numbers.length; i++) {
				
				ps.setString(i+1,plan_numbers[i]);
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
	
	public int modify(Plan_ManagementDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String query =  "UPDATE TABLE_PL SET";
			query += " PLAN_NUMBER = ?,";
			query += " PRODUCT_CODE = ?,";
     	   	query += " PRODUCT_NAME = ?,";
     	   	query += " PLAN_START_DATE = ?,";
     	   	query += " PLAN_END_DATE = ?,";
     	   	query += " PLAN_AMOUNT = ?,";
     	   	query += " PLAN_REMARKS = ?";
     	   	query += " WHERE PLAN_NUMBER = ?";
			       
			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setString(1, dto.getPlan_number());
			ps.setString(2, dto.getProduct_code());
			ps.setString(3, dto.getProduct_name());
			ps.setDate(4, dto.getPlan_start_date());
			ps.setDate(5, dto.getPlan_end_date());
			ps.setInt(6, dto.getPlan_amount());
			ps.setString(7, dto.getPlan_remarks());
			ps.setString(8, dto.getPlan_number());
			
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
	
}
