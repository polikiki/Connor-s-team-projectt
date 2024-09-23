package pl.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import pl.DTO.Plan_ManagementDTO;

public class Plan_Management_PageDAO {

	public List selectplPage(int start, int end, String search, String optionvalue ) {
		List list = new ArrayList();
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String 	query =  " select * ";
		            query += " from ( ";
		            query += "    select ROWNUM RNUM, PLAN_NUMBER, PRODUCT_CODE, PRODUCT_NAME, PLAN_START_DATE, PLAN_END_DATE, PLAN_AMOUNT, PLAN_REMARKS ";
		            query += "    from ( ";
		            query += "		select PLAN_NUMBER, PRODUCT_CODE, PRODUCT_NAME, PLAN_START_DATE, PLAN_END_DATE, PLAN_AMOUNT, PLAN_REMARKS ";
		            query += "		from TABLE_PL ";
		            			if("code".equals(optionvalue)) {
		            				query += " where PLAN_NUMBER like '%' || ? || '%' ";
		            			}else if("name".equals(optionvalue)) {
		            				query += " where PRODUCT_NAME like '%' || ? || '%' ";
		            			}
		            query += "		order by PLAN_NUMBER";
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
				Plan_ManagementDTO plDTO = new Plan_ManagementDTO();
				
				// 이번 줄에서 empno 컬럼의 값을 int로 형변환해서 가져옴
				String plan_number = rs.getString("plan_number");
				plDTO.setPlan_number(plan_number);
				
				String product_code = rs.getString("product_code");
				plDTO.setProduct_code(product_code);
				
				plDTO.setProduct_name( rs.getString("product_name") );
				plDTO.setPlan_start_date( rs.getDate("plan_start_date") );
				
				plDTO.setPlan_end_date( rs.getDate("plan_end_date") );
				plDTO.setPlan_amount( rs.getInt("plan_amount") );
				
				plDTO.setPlan_remarks( rs.getString("plan_remarks") );
			
				plDTO.setRnum( rs.getInt("rnum") );
				
				
				list.add(plDTO);
			}
			
			rs.close();
			ps.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int totalplPage() {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();

			// SQL 준비
			String 	query =  " select count(*) cnt from TABLE_PL ";
            
            
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
