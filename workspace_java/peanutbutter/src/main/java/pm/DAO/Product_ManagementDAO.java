package pm.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import pm.DAO.LoggableStatement;
import pm.DTO.Product_ManagementDTO;

public class Product_ManagementDAO {
	
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
	

	public List selectPM(String product_code1) {
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
				
				
				String product_image = rs.getString("product_image");
				pmDTO.setProduct_image(product_image);
				
				String unit = rs.getString("unit");
				pmDTO.setUnit(unit);
				
				String standard = rs.getString("standard");
				pmDTO.setStandard(standard);
				
				int lead_time = rs.getInt("lead_time");
				pmDTO.setLead_time(lead_time);
				
				String barcode = rs.getString("barcode");
				pmDTO.setBarcode(barcode);
				
				int lot_size = rs.getInt("lot_size");
				pmDTO.setLot_size(lot_size);
				
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
	
	public Product_ManagementDTO selectOne(String product_code) {
		Product_ManagementDTO pmDTO = null;
		
		// DB 접속
		Connection con = getConnection();
		
if(con == null) return null;
		
		try {
			
			// sql 준비
			String sql = "SELECT * FROM TABLE_PM where Product_Code = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			// ?를 값으로 채워줌
			// 첫번째 전달인자는 ?의 순서
			// 만약에 글씨라면 setString, 알아서 '로 감싸준다
			ps.setString(1, product_code);
			
			// sql 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			if( rs.next() ) {
				pmDTO = new Product_ManagementDTO();
				pmDTO.setProduct_code(rs.getString("product_code"));
				pmDTO.setProduct_name(rs.getString("product_name"));
				pmDTO.setProduct_image(rs.getString("product_image"));
				pmDTO.setUnit(rs.getString("unit"));
				pmDTO.setStandard(rs.getString("standard"));
				pmDTO.setLead_time(rs.getInt("lead_time"));
				pmDTO.setBarcode(rs.getString("barcode"));
				pmDTO.setLot_size(rs.getInt("lot_size"));
				pmDTO.setShipping_warehouse(rs.getString("shipping_warehouse"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return pmDTO;
	}
		
	
	public int insertPM(Product_ManagementDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String query = " INSERT INTO TABLE_PM (Product_Code, Product_Name, Product_Image, Unit, Standard, Lead_Time, Barcode, Lot_Size, Shipping_Warehouse)";
			       query +=" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			       
			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setString(1, dto.getProduct_code());
			ps.setString(2, dto.getProduct_name());
			ps.setString(3, dto.getProduct_image());
			ps.setString(4, dto.getUnit());
			ps.setString(5, dto.getStandard());
			ps.setInt(6, dto.getLead_time());
			ps.setString(7, dto.getBarcode());
			ps.setInt(8, dto.getLot_size());
			ps.setString(9, dto.getShipping_warehouse());
			
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
	
	public int deletOne(String[] product_codes) {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
			String query = "delete from TABLE_PM where Product_Code in (";
			
			for(int i=0; i< product_codes.length; i++) {
				query += "?";
				if(i < product_codes.length-1) {
					query +=",";
				}
			}
				query += ")";
			
			System.out.println("for문으로 만든 query: "+ query);
			
			PreparedStatement ps = con.prepareStatement(query);
			
			for(int i=0; i< product_codes.length; i++) {
				
				ps.setString(i+1,product_codes[i]);
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
	
	public int modify(Product_ManagementDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String query =  "UPDATE TABLE_PM SET";
     	   query += " Product_Code = ?,";
     	   query += " Product_Name = ?,";
     	   query += " Product_Image = ?,";
     	   query += " Unit = ?,";
     	   query += " Standard = ?,";
     	   query += " Lead_Time = ?,";
     	   query += " Barcode = ?,";
     	   query += " Lot_Size = ?,";
     	   query += " Shipping_Warehouse = ?";
     	   query += " WHERE Product_Code = ?";
			       
			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setString(1, dto.getProduct_code());
			ps.setString(2, dto.getProduct_name());
			ps.setString(3, dto.getProduct_image());
			ps.setString(4, dto.getUnit());
			ps.setString(5, dto.getStandard());
			ps.setInt(6, dto.getLead_time());
			ps.setString(7, dto.getBarcode());
			ps.setInt(8, dto.getLot_size());
			ps.setString(9, dto.getShipping_warehouse());
			ps.setString(10, dto.getProduct_code());
			
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
	
	public long selectSequence() {
		long seq = -1;
		
		// DB 접속
		Connection con = getConnection();
		
if(con == null) return seq;
		
		try {
			
			// sql 준비
			String sql = "SELECT SEQ_PM_SEQUENCE.NEXTVAL FROM dual";
			PreparedStatement ps = con.prepareStatement(sql);
			// ?를 값으로 채워줌
			// 첫번째 전달인자는 ?의 순서
			// 만약에 글씨라면 setString, 알아서 '로 감싸준다
			
			// sql 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			if( rs.next() ) {
				seq=rs.getLong("nextval");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return seq;
	}
	
}
