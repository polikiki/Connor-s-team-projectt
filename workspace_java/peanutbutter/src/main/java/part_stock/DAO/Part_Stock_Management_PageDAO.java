package part_stock.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import part_stock.DTO.Part_Stock_ManagementDTO;

public class Part_Stock_Management_PageDAO {

	public List select_pt_stockPage(int start, int end, String search, String optionvalue ) {
		List list = new ArrayList();
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String 	query =  " select * ";
		            query += " from ( ";
		            query += "    select rownum rnum, Part_Code, Part_Name, Part_Image, Part_Unit, Part_Standard, Part_Modelname, Part_Vendor1, Part_Vendor2, Receving_Warehouse, Stock_Amount, Latest_Stock_Date, Part_Barcode ";
		            query += "    from ( ";
		            query += "		select Part_Code, Part_Name, Part_Image, Part_Unit, Part_Standard, Part_Modelname, Part_Vendor1, Part_Vendor2, Receving_Warehouse, Stock_Amount, Latest_Stock_Date, Part_Barcode ";
		            query += "		from TABLE_PT_STOCK ";
		            			if("part_name".equals(optionvalue)) {
		            				query += " where like Part_Name '%' || ? || '%' ";
		            			}else if("warehouse".equals(optionvalue)) {
		            				query += " where  like Receving_Warehouse '%' || ? || '%' ";
		            			}else if("stock_date".equals(optionvalue)) {
		            				query += " where like Latest_Stock_Date '%' || ? || '%' ";
		            			}
		            query += "		order by Part_Code";
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
				Part_Stock_ManagementDTO pt_stockDTO = new Part_Stock_ManagementDTO();
				
				String part_code = rs.getString("part_code");
				pt_stockDTO.setPart_code(part_code);
				
				String part_name = rs.getString("part_name");
				pt_stockDTO.setPart_name(part_name);
				
				pt_stockDTO.setPart_image( rs.getString("part_image") );
				pt_stockDTO.setPart_unit( rs.getString("part_unit") );
				
				pt_stockDTO.setPart_standard( rs.getString("part_standard") );
				pt_stockDTO.setPart_modelname( rs.getString("part_modelname") );
			
				pt_stockDTO.setPart_vendor1( rs.getString("part_vendor1") );
				pt_stockDTO.setPart_vendor2( rs.getString("part_vendor2") );
		
				pt_stockDTO.setReceving_warehouse( rs.getString("receving_warehouse") );
				pt_stockDTO.setPart_barcode(rs.getString("part_barcode"));
				
				pt_stockDTO.setStock_amount(rs.getInt("stock_amount"));
				pt_stockDTO.setLatest_stock_date(rs.getDate("latest_stock_date"));
				
				pt_stockDTO.setRnum( rs.getInt("rnum") );
				
				
				list.add(pt_stockDTO);
			}
			
			rs.close();
			ps.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int total_pt_stockPage() {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String 	query =  " select count(*) cnt from TABLE_PT_STOCK ";
            
            
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
