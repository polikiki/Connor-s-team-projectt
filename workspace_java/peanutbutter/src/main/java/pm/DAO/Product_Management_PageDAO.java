package pm.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import pm.DTO.Product_ManagementDTO;

public class Product_Management_PageDAO {

	public List selectpmPage(int start, int end, String search, String optionvalue ) {
		List list = new ArrayList();
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String 	query =  " select * ";
		            query += " from ( ";
		            query += "    select rownum rnum, Product_Code, Product_Name, Product_Image, Unit, Standard, Lead_Time, Barcode, Lot_Size, Shipping_Warehouse ";
		            query += "    from ( ";
		            query += "		select Product_Code, Product_Name, Product_Image, Unit, Standard, Lead_Time, Barcode, Lot_Size, Shipping_Warehouse ";
		            query += "		from TABLE_PM ";
		            			if("code".equals(optionvalue)) {
		            				query += " where Product_Code like '%' || ? || '%' ";
		            			}else if("name".equals(optionvalue)) {
		            				query += " where Product_Name like '%' || ? || '%' ";
		            			}
		            query += "		order by Product_Code";
		            query += "    ) ";
		            query += " ) ";
		            query += " where rnum >= ? and rnum <= ?";
            
            PreparedStatement ps = new LoggableStatement(con, query);
            
            if( optionvalue == null || search == null) {
                ps.setInt(1, start);
    			ps.setInt(2, end);	
            }
            
            else if(optionvalue != null || search != null) {
            ps.setString(1, search);
            ps.setInt(2, start);
			ps.setInt(3, end);
            }
			
			System.out.println( ( (LoggableStatement)ps ).getQueryString() );
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				Product_ManagementDTO pmDTO = new Product_ManagementDTO();
				
				// 이번 줄에서 empno 컬럼의 값을 int로 형변환해서 가져옴
				String product_code = rs.getString("product_code");
				pmDTO.setProduct_code(product_code);
				
				String product_name = rs.getString("product_name");
				pmDTO.setProduct_name(product_name);
				
				pmDTO.setProduct_image( rs.getString("product_image") );
				pmDTO.setUnit( rs.getString("unit") );
				
				pmDTO.setStandard( rs.getString("standard") );
				pmDTO.setLead_time( rs.getInt("lead_time") );
				
				pmDTO.setBarcode( rs.getString("barcode") );
				pmDTO.setLot_size( rs.getInt("lot_size") );
				
				pmDTO.setShipping_warehouse( rs.getString("shipping_warehouse") );
				pmDTO.setRnum( rs.getInt("rnum") );
				
				
				list.add(pmDTO);
			}
			
			rs.close();
			ps.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int totalpmPage() {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String 	query =  " select count(*) cnt from TABLE_PM ";
            
            
            PreparedStatement ps = new LoggableStatement(con, query);
			
			System.out.println( ( (LoggableStatement)ps ).getQueryString() );
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				result = rs.getInt("cnt");
			}
			
			rs.close();
			ps.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
