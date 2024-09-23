package product_stock.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import pl.DTO.Plan_ManagementDTO;
import pm.DAO.LoggableStatement;
import product_stock.DTO.Product_Stock_ManagementDTO;
import sp.DTO.Specification_ManagementDTO;
import pm.DTO.Product_ManagementDTO;


public class Product_Stock_ManagementDAO {
	
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
	

	public List select_PM_stock(String product_code1) {
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
				query = " SELECT * FROM TABLE_PM_STOCK";
			} else if(product_code1 != null) {
				query = " SELECT * FROM TABLE_PM_STOCK where Product_Code = ?";
			}
			ps = con.prepareStatement(query);
			
			if(product_code1 != null) {
			ps.setInt(1, Integer.parseInt(product_code1));
			}
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			while( rs.next()) {
				Product_Stock_ManagementDTO pm_stock_DTO = new Product_Stock_ManagementDTO();
				
				String product_code = rs.getString("product_code");
				pm_stock_DTO.setProduct_code(product_code);
				
				String product_name = rs.getString("product_name");
				pm_stock_DTO.setProduct_name(product_name);
				
				pm_stock_DTO.setProduct_image( rs.getString("product_image") );
				pm_stock_DTO.setUnit( rs.getString("unit") );
				
				pm_stock_DTO.setStandard( rs.getString("standard") );
				pm_stock_DTO.setLot_size( rs.getInt("lot_size") );
				
				pm_stock_DTO.setShipping_warehouse( rs.getString("shipping_warehouse") );
				pm_stock_DTO.setBarcode( rs.getString("barcode") );

				pm_stock_DTO.setStock_amount( rs.getInt("stock_amount") );
				pm_stock_DTO.setLatest_stock_date( rs.getDate("latest_stock_date") );
				
				pm_stock_DTO.setProduct_status( rs.getString("product_status") );
				
							
				pm_stock_DTO.setRnum( rs.getInt("rnum") );
				
				list.add(pm_stock_DTO);
			}	
			
			ps.close();
			con.close();
			
		}catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Product_Stock_ManagementDTO selectOne(String product_code) {
		Product_Stock_ManagementDTO pm_stock_DTO = null;
		
		// DB 접속
		Connection con = getConnection();
		
if(con == null) return null;
		
		try {
			
			// sql 준비
			String sql = "SELECT * FROM TABLE_PM_STOCK where Product_Code = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			// ?를 값으로 채워줌
			// 첫번째 전달인자는 ?의 순서
			// 만약에 글씨라면 setString, 알아서 '로 감싸준다
			ps.setString(1, product_code);
			
			// sql 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			if( rs.next() ) {
				pm_stock_DTO = new Product_Stock_ManagementDTO();
				pm_stock_DTO.setProduct_code(rs.getString("product_code"));
				pm_stock_DTO.setProduct_name(rs.getString("product_name"));
				pm_stock_DTO.setProduct_image(rs.getString("product_image"));
				pm_stock_DTO.setUnit(rs.getString("unit"));
				pm_stock_DTO.setStandard(rs.getString("standard"));
				pm_stock_DTO.setLot_size(rs.getInt("lot_size"));
				pm_stock_DTO.setShipping_warehouse(rs.getString("shipping_warehouse"));
				pm_stock_DTO.setBarcode(rs.getString("barcode"));
				pm_stock_DTO.setStock_amount( rs.getInt("stock_amount") );
				pm_stock_DTO.setLatest_stock_date( rs.getDate("latest_stock_date") );
				pm_stock_DTO.setProduct_status( rs.getString("product_status") );
	
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return pm_stock_DTO;
	}
		
	
	public int insert_PM_stock(Product_ManagementDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String query = " INSERT INTO TABLE_PM_STOCK (Product_Code, Product_Name, Product_Image, Unit, Standard, Lot_Size, Shipping_Warehouse, Barcode)";
			       query +=" VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			       
			PreparedStatement ps = new LoggableStatement(con, query);			
			ps.setString(1, dto.getProduct_code());
			ps.setString(2, dto.getProduct_name());
			ps.setString(3, dto.getProduct_image());
			ps.setString(4, dto.getUnit());
			ps.setString(5, dto.getStandard());
			ps.setInt(6, dto.getLot_size());
			ps.setString(7, dto.getShipping_warehouse());
			ps.setString(8, dto.getBarcode());
			
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
			String query = "delete from TABLE_PM_STOCK where Product_Code in (";
			
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
	
	// 완재품재고관리에서 변경된 상태에 따른 데이터를 불러와 변경하는 매소드 (sql문부터 미완성)
	public int modify(Specification_ManagementDTO spDTO) {
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
	
	public List<Specification_ManagementDTO> selectSP_data() {
		List<Specification_ManagementDTO> list = new ArrayList();
		
		try {
			
			// # DB에서 Table_SP 조회하기
			
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			Connection con = dataSource.getConnection();
			
			// SQL 준비
				String query = "SELECT SPECIFICATION_NUMBER, PRODUCT_CODE, PLAN_AMOUNT FROM TABLE_SP WHERE SPECIFICATION_STATUS = 'complete'";
				PreparedStatement ps = con.prepareStatement(query);
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			while( rs.next()) {
				Specification_ManagementDTO spDTO = new Specification_ManagementDTO();
				
				String specification_number = rs.getString("specification_number");
				spDTO.setSpecification_number(specification_number);
				
				String product_code = rs.getString("product_code");
				spDTO.setProduct_code(product_code);
				
				spDTO.setPlan_amount( rs.getInt("plan_amount") );
				
				list.add(spDTO);
			}	
			
			rs.close();
			ps.close();
			con.close();
			
		}catch (Exception e) {
		
			e.printStackTrace();
		}
		
		System.out.println(">> 0 >> :"+list.size());
		return list;
	}
	
	public List selectPL_data() {
		List list = new ArrayList();
		
		try {
			
			// # DB에서 Table_SP 조회하기
			
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			Connection con = dataSource.getConnection();
			
			// SQL 준비
				String query = "SELECT PLAN_NUMBER, PRODUCT_CODE, PRODUCT_NAME, PLAN_START_DATE, PLAN_AMOUNT FROM TABLE_PL ";
				PreparedStatement ps = con.prepareStatement(query);
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			while( rs.next()) {
				Plan_ManagementDTO plDTO = new Plan_ManagementDTO();
				
				String plan_number = rs.getString("plan_number");
				plDTO.setPlan_number(plan_number);
				
				String product_code = rs.getString("product_code");
				plDTO.setProduct_code(product_code);
				
				plDTO.setProduct_name(rs.getString("product_name"));
				
				plDTO.setPlan_start_date(rs.getDate("plan_start_date"));
				
				plDTO.setPlan_amount( rs.getInt("plan_amount") );
				
				list.add(plDTO);
			}	
			
			rs.close();
			ps.close();
			con.close();
			
		}catch (Exception e) {
		
			e.printStackTrace();
		}
		
		System.out.println(">> 0 >> :"+list.size());
		return list;
	}
	
}
