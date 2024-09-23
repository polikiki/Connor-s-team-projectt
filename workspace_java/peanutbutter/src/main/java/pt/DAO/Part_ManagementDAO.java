package pt.DAO;

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

public class Part_ManagementDAO {
	
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
	

	public List selectPT(String part_code1) {
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
				query = " SELECT * FROM TABLE_PT";
			} else if(part_code1 != null) {
				query = " SELECT * FROM TABLE_PT where Part_Code = ?";
			}
			ps = con.prepareStatement(query);
			
			if(part_code1 != null) {
			ps.setInt(1, Integer.parseInt(part_code1));
			}
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			while( rs.next()) {
				Part_ManagementDTO ptDTO = new Part_ManagementDTO();
				
				String part_code = rs.getString("part_code");
				ptDTO.setPart_code(part_code);
				
				
				String part_name = rs.getString("part_name");
				ptDTO.setPart_name(part_name);
				
				ptDTO.setPart_image( rs.getString("part_image") );
				ptDTO.setPart_unit( rs.getString("part_unit") );
				
				ptDTO.setPart_standard( rs.getString("part_standard") );
				ptDTO.setPart_modelname( rs.getString("part_modelname") );
				
				ptDTO.setPart_sort( rs.getString("part_sort") );
				ptDTO.setPart_vendor1( rs.getString("part_vendor1") );
				ptDTO.setPart_vendor2( rs.getString("part_vendor2") );
				
				ptDTO.setReceving_warehouse( rs.getString("receving_warehouse") );
				ptDTO.setPart_barcode(rs.getString("part_barcode"));
				
				ptDTO.setRnum( rs.getInt("rnum") );
				
				
				list.add(ptDTO);
			}
			
			ps.close();
			con.close();
			
		}catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Part_ManagementDTO selectOne(String part_code) {
		Part_ManagementDTO ptDTO = null;
		
		// DB 접속
		Connection con = getConnection();
		
if(con == null) return null;
		
		try {
			
			// sql 준비
			String sql = "SELECT * FROM TABLE_PT where Part_Code = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			// ?를 값으로 채워줌
			// 첫번째 전달인자는 ?의 순서
			// 만약에 글씨라면 setString, 알아서 '로 감싸준다
			ps.setString(1, part_code);
			
			// sql 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			if( rs.next() ) {
				ptDTO = new Part_ManagementDTO();
				ptDTO.setPart_code(rs.getString("part_code"));
				ptDTO.setPart_name(rs.getString("part_name"));
				ptDTO.setPart_image(rs.getString("part_image"));
				ptDTO.setPart_unit(rs.getString("part_unit"));
				ptDTO.setPart_standard(rs.getString("part_standard"));
				ptDTO.setPart_modelname(rs.getString("part_modelname"));
				ptDTO.setPart_sort(rs.getString("part_sort"));
				ptDTO.setPart_vendor1(rs.getString("part_vendor1"));
				ptDTO.setPart_vendor2(rs.getString("part_vendor2"));
				ptDTO.setReceving_warehouse(rs.getString("receving_warehouse"));
				ptDTO.setPart_barcode(rs.getString("part_barcode"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ptDTO;
	}
		
	
	public int insertPT(Part_ManagementDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String query = " INSERT INTO TABLE_PT (Part_Code, Part_Name, Part_Image, Part_Unit, Part_Standard, Part_Modelname, Part_Sort, Part_Vendor1, Part_Vendor2, Receving_Warehouse, Part_Barcode)";
			       query +=" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			       
			PreparedStatement ps = new LoggableStatement(con, query);			
			ps.setString(1, dto.getPart_code());
			ps.setString(2, dto.getPart_name());
			ps.setString(3, dto.getPart_image());
			ps.setString(4, dto.getPart_unit());
			ps.setString(5, dto.getPart_standard());
			ps.setString(6, dto.getPart_modelname());
			ps.setString(7, dto.getPart_sort());
			ps.setString(8, dto.getPart_vendor1());
			ps.setString(9, dto.getPart_vendor2());
			ps.setString(10, dto.getReceving_warehouse());
			ps.setString(11, dto.getPart_barcode());
			
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
			String query = "delete from TABLE_PT where Part_Code in (";
			
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
	
	public int modify(Part_ManagementDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String query =  "UPDATE TABLE_PT SET";
			query += " Part_Code = ?,";
			query += " Part_Name = ?,";
     	   	query += " Part_Image = ?,";
     	   	query += " Part_Unit = ?,";
     	   	query += " Part_Standard = ?,";
     	   	query += " Part_Modelname = ?,";
     	   	query += " Part_Sort = ?,";
     	   	query += " Part_vendor1 = ?,";
     	   	query += " Part_vendor2 = ?,";
     	   	query += " Receving_Warehouse = ?,";
     	   	query += " Part_Barcode = ?";
     	   	query += " WHERE Part_Code = ?";
			       
			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setString(1, dto.getPart_code());
			ps.setString(2, dto.getPart_name());
			ps.setString(3, dto.getPart_image());
			ps.setString(4, dto.getPart_unit());
			ps.setString(5, dto.getPart_standard());
			ps.setString(6, dto.getPart_modelname());
			ps.setString(7, dto.getPart_sort());
			ps.setString(8, dto.getPart_vendor1());
			ps.setString(9, dto.getPart_vendor2());
			ps.setString(10, dto.getReceving_warehouse());
			ps.setString(11, dto.getPart_barcode());
			ps.setString(12, dto.getPart_code());
			
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
			String sql = "SELECT SEQ_PT_SEQUENCE.NEXTVAL FROM dual";
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
