package pt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import pt.DTO.Part_ManagementDTO;

public class Part_Management_PageDAO {

	public List selectptPage(int start, int end, String search, String optionvalue ) {
		List list = new ArrayList();
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String 	query =  " select * ";
		            query += " from ( ";
		            query += "    select rownum rnum, Part_Code, Part_Name, Part_Image, Part_Unit, Part_Standard, Part_Modelname, Part_Sort, Part_Vendor1, Part_Vendor2, Receving_Warehouse, Part_Barcode ";
		            query += "    from ( ";
		            query += "		select Part_Code, Part_Name, Part_Image, Part_Unit, Part_Standard, Part_Modelname, Part_Sort, Part_Vendor1, Part_Vendor2, Receving_Warehouse, Part_Barcode ";
		            query += "		from TABLE_PT ";
		            			if("code".equals(optionvalue)) {
		            				query += " where Part_Code like '%' || ? || '%' ";
		            			}else if("group".equals(optionvalue)) {
		            				query += " where Part_Name like '%' || ? || '%' ";
		            			}else if("group".equals(optionvalue)) {
		            				query += " where Part_Modelname like '%' || ? || '%' ";
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
			
			rs.close();
			ps.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int totalptPage() {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String 	query =  " select count(*) cnt from TABLE_PT ";
            
            
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
