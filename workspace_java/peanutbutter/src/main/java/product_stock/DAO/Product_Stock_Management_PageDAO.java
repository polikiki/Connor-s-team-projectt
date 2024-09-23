package product_stock.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import pm.DAO.LoggableStatement;
import product_stock.DTO.Product_Stock_ManagementDTO;

public class Product_Stock_Management_PageDAO {

	public List select_pm_stock_Page(int start, int end, String search, String optionvalue ) {
		List list = new ArrayList();
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String 	query =  " select * ";
		            query += " from ( ";
		            query += "    select rownum rnum, Product_Code, Product_Name, Product_Image, Unit, Standard, Lot_Size, Shipping_Warehouse, Barcode, Stock_Amount, Latest_Stock_Date, Product_Status ";
		            query += "    from ( ";
		            query += "		select Product_Code, Product_Name, Product_Image, Unit, Standard, Lot_Size, Shipping_Warehouse, Barcode, Stock_Amount, Latest_Stock_Date, Product_Status ";
		            query += "		from TABLE_PM_STOCK ";
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
				Product_Stock_ManagementDTO pm_stock_DTO = new Product_Stock_ManagementDTO();
				
				// 이번 줄에서 empno 컬럼의 값을 int로 형변환해서 가져옴
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
			
			rs.close();
			ps.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int total_pm_stock_Page() {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String 	query =  " select count(*) cnt from TABLE_PM_STOCK ";
            
            
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
