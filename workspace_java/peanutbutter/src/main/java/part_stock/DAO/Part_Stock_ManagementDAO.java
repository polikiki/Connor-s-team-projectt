package part_stock.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import pt.DAO.LoggableStatement;
import pt.DTO.Part_ManagementDTO;
import part_stock.DTO.Part_Stock_ManagementDTO;

public class Part_Stock_ManagementDAO {
	
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
	

	public List select_PT_Stock(String part_code1) {
		List list = new ArrayList();
		
		try {
			
			// # DB에서 Table_PM 조회하기
			
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			Connection con = dataSource.getConnection();
			
			// SQL 준비
			String query = null;
			PreparedStatement ps = null;
			
			if(part_code1 == null) {
				query = " SELECT * FROM TABLE_PT_STOCK";
			} else if(part_code1 != null) {
				query = " SELECT * FROM TABLE_PT_STOCK where Part_Code = ?";
			}
			ps = con.prepareStatement(query);
			
			if(part_code1 != null) {
			ps.setInt(1, Integer.parseInt(part_code1));
			}
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			while( rs.next()) {
				Part_Stock_ManagementDTO pt_stockDTO = new Part_Stock_ManagementDTO();
				
				String part_code = rs.getString("part_code");
				
				pt_stockDTO.setPart_code(rs.getString("part_code"));
				pt_stockDTO.setPart_name(rs.getString("part_name"));
				pt_stockDTO.setPart_image(rs.getString("part_image"));
				pt_stockDTO.setPart_unit(rs.getString("part_unit"));
				pt_stockDTO.setPart_standard(rs.getString("part_standard"));
				pt_stockDTO.setPart_modelname(rs.getString("part_modelname"));
				pt_stockDTO.setPart_vendor1(rs.getString("part_vendor1"));
				pt_stockDTO.setPart_vendor2(rs.getString("part_vendor2"));
				pt_stockDTO.setReceving_warehouse(rs.getString("receving_warehouse"));
				pt_stockDTO.setPart_barcode(rs.getString("part_barcode"));
				pt_stockDTO.setStock_amount(rs.getInt("stock_amount"));
				pt_stockDTO.setLatest_stock_date(rs.getDate("latest_stock_date"));
				
				list.add(pt_stockDTO);
			}
			
			ps.close();
			con.close();
			
		}catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Part_Stock_ManagementDTO selectOne(String part_code) {
		Part_Stock_ManagementDTO pt_stockDTO = null;
		
		// DB 접속
		Connection con = getConnection();
		
if(con == null) return null;
		
		try {
			
			// sql 준비
			String sql = "SELECT * FROM TABLE_PT_STOCK where Part_Code = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			// ?를 값으로 채워줌
			// 첫번째 전달인자는 ?의 순서
			// 만약에 글씨라면 setString, 알아서 '로 감싸준다
			ps.setString(1, part_code);
			
			// sql 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			if( rs.next() ) {
				pt_stockDTO = new Part_Stock_ManagementDTO();
				pt_stockDTO.setPart_code(rs.getString("part_code"));
				pt_stockDTO.setPart_name(rs.getString("part_name"));
				pt_stockDTO.setPart_image(rs.getString("part_image"));
				pt_stockDTO.setPart_unit(rs.getString("part_unit"));
				pt_stockDTO.setPart_standard(rs.getString("part_standard"));
				pt_stockDTO.setPart_modelname(rs.getString("part_modelname"));
				pt_stockDTO.setPart_vendor1(rs.getString("part_vendor1"));
				pt_stockDTO.setPart_vendor2(rs.getString("part_vendor2"));
				pt_stockDTO.setReceving_warehouse(rs.getString("receving_warehouse"));
				pt_stockDTO.setPart_barcode(rs.getString("part_barcode"));
				pt_stockDTO.setStock_amount(rs.getInt("stock_amount"));
				pt_stockDTO.setLatest_stock_date(rs.getDate("latest_stock_date"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return pt_stockDTO;
	}
		
	
	public int insert_PT_Stock(Part_ManagementDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String query = " INSERT INTO TABLE_PT_STOCK (Part_Code, Part_Name, Part_Image, Part_Unit, Part_Standard, Part_Modelname, Part_Vendor1, Part_Vendor2, Receving_Warehouse, Part_Barcode)";
			       query +=" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			       
			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setString(1, dto.getPart_code());
			ps.setString(2, dto.getPart_name());
			ps.setString(3, dto.getPart_image());
			ps.setString(4, dto.getPart_unit());
			ps.setString(5, dto.getPart_standard());
			ps.setString(6, dto.getPart_modelname());
			ps.setString(7, dto.getPart_vendor1());
			ps.setString(8, dto.getPart_vendor2());
			ps.setString(9, dto.getReceving_warehouse());
			ps.setString(10, dto.getPart_barcode());
			
			
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
	
	public int deletOne(String[] part_codes) {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
			String query = "delete from TABLE_PT_STOCK where Part_Code in (";
			
			for(int i=0; i< part_codes.length; i++) {
				query += "?";
				if(i < part_codes.length-1) {
					query +=",";
				}
			}
				query += ")";
			
			System.out.println("for문으로 만든 query: "+ query);
			
			PreparedStatement ps = con.prepareStatement(query);
			
			for(int i=0; i< part_codes.length; i++) {
				
				ps.setString(i+1,part_codes[i]);
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
	
	public int modify(Part_Stock_ManagementDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String query =  "UPDATE TABLE_PT_STOCK SET";
			query += " Part_Code = ?,";
			query += " Part_Name = ?,";
     	   	query += " Part_Image = ?,";
     	   	query += " Part_Unit = ?,";
     	   	query += " Part_Standard = ?,";
     	   	query += " Part_Modelname = ?,";
     	   	query += " Part_vendor1 = ?,";
     	   	query += " Part_vendor2 = ?,";
     	   	query += " Receving_Warehouse = ?,";
     	   	query += " Stock_Amount = ?,";
     	   	query += " Latest_Stock_Date = ?,";
     	   	query += " Part_Barcode = ?";
     	   	query += " WHERE Part_Code = ?";
			       
			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setString(1, dto.getPart_code());
			ps.setString(2, dto.getPart_name());
			ps.setString(3, dto.getPart_image());
			ps.setString(4, dto.getPart_unit());
			ps.setString(5, dto.getPart_standard());
			ps.setString(6, dto.getPart_modelname());
			ps.setString(7, dto.getPart_vendor1());
			ps.setString(8, dto.getPart_vendor2());
			ps.setString(9, dto.getReceving_warehouse());
			ps.setInt(10, dto.getStock_amount());
			ps.setDate(11, dto.getLatest_stock_date());
			ps.setString(12, dto.getPart_barcode());
			ps.setString(13, dto.getPart_code());
			
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
