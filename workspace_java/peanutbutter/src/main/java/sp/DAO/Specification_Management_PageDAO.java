package sp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import sp.DTO.Specification_ManagementDTO;

public class Specification_Management_PageDAO {

	public List selectspPage(int start, int end, String search, String optionvalue ) {
		List list = new ArrayList();
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String 	query =  " select * ";
		            query += " from ( ";
		            query += "    select ROWNUM RNUM, SPECIFICATION_NUMBER, PRODUCT_NAME, PLAN_START_DATE, PLAN_END_DATE, PLAN_REG_DATE, PLAN_AMOUNT, SPECIFICATION_STATUS ";
		            query += "    from ( ";
		            query += "		select SPECIFICATION_NUMBER, PRODUCT_NAME, PLAN_START_DATE, PLAN_END_DATE, PLAN_REG_DATE, PLAN_AMOUNT, SPECIFICATION_STATUS ";
		            query += "		from TABLE_SP ";
		            			if("sp_number".equals(optionvalue)) {
		            				query += " where SPECIFICATION_NUMBER like '%' || ? || '%' ";
		            			}else if("pm_name".equals(optionvalue)) {
		            				query += " where PRODUCT_NAME like '%' || ? || '%' ";
		            			}
		            query += "		order by PLAN_START_DATE";
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
				Specification_ManagementDTO spDTO = new Specification_ManagementDTO();
				
				// 이번 줄에서 empno 컬럼의 값을 int로 형변환해서 가져옴
				String specification_number = rs.getString("specification_number");
				spDTO.setSpecification_number(specification_number);
				
				String product_name = rs.getString("product_name");
				spDTO.setProduct_name(product_name);
				
				spDTO.setPlan_start_date( rs.getDate("plan_start_date") );
				spDTO.setPlan_end_date( rs.getDate("plan_end_date") );
				spDTO.setPlan_reg_date( rs.getDate("plan_reg_date") );
				
				
				spDTO.setPlan_amount( rs.getInt("plan_amount") );
				
				spDTO.setSpecification_status( rs.getString("specification_status") );
			
				spDTO.setRnum( rs.getInt("rnum") );
				
				
				list.add(spDTO);
			}
			
			rs.close();
			ps.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int totalspPage() {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String 	query =  " select count(*) cnt from TABLE_SP ";
            
            
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
