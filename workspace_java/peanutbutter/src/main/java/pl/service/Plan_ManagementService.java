package pl.service;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import pl.DAO.Plan_ManagementDAO;
import pl.DTO.Plan_ManagementDTO;
import sp.DAO.Specification_ManagementDAO;

public class Plan_ManagementService {

	Plan_ManagementDAO plDAO = new Plan_ManagementDAO();
	Specification_ManagementDAO spDAO = new Specification_ManagementDAO();
	
	public List getPM_data() {
		Plan_ManagementDAO plDAO = new Plan_ManagementDAO();
		
		List result = plDAO.selectPM_data();
		
		return result;
	}
	
	public List getPM_data_one(String product_code) {
		Plan_ManagementDAO plDAO = new Plan_ManagementDAO();
		
		List result = plDAO.selectPM_data_one(product_code);
		
		return result;
	}
	
	public Plan_ManagementDTO get(String plan_number) {
		
		Plan_ManagementDAO plDAO = new Plan_ManagementDAO();
		
		Plan_ManagementDTO dto = new Plan_ManagementDTO();
		
		dto = plDAO.selectOne(plan_number);
		
		return dto;
		
	}
	
	public int insertPL(Plan_ManagementDTO dto) {
		int insertCount = this.plDAO.insertPL(dto);
		
		Date plan_start_date = dto.getPlan_start_date();
		Date plan_end_date = dto.getPlan_end_date();
		
		// Calendar 객체를 사용하기 위해 Calendar 인스턴스를 생성합니다.
		Calendar calStrDt = Calendar.getInstance();
		Calendar calEndDt = Calendar.getInstance();
		
		// 시작 날짜를 Calendar 객체에 설정합니다.
		calStrDt.setTime(plan_start_date);
		
		// 시작일의 일(day), 월(month), 연(year)을 가져옵니다.
		int strDayOfMonth = calStrDt.get(Calendar.DAY_OF_MONTH); 
		int strMonth = calStrDt.get(Calendar.MONTH); 
		int strYear = calStrDt.get(Calendar.YEAR);
		
		// 종료 날짜를 Calendar 객체에 설정합니다.
		calEndDt.setTime(plan_end_date);
		// 종료일의 일(day), 월(month), 연(year)을 가져옵니다.
		int endDayOfMonth = calEndDt.get(Calendar.DAY_OF_MONTH); 
		int endMonth = calEndDt.get(Calendar.MONTH); 
		int endYear = calEndDt.get(Calendar.YEAR); 

		// 두 날짜의 일(day) 차이를 계산합니다.
		int diffDays = calStrDt.getActualMaximum(Calendar.DAY_OF_MONTH) == strDayOfMonth && calEndDt.getActualMaximum(Calendar.DAY_OF_MONTH) == endDayOfMonth ? 0 : endDayOfMonth - strDayOfMonth;
		// 두 날짜의 월(month) 차이를 계산합니다.
		int diffMonths = endMonth - strMonth;
		// 두 날짜의 연(year) 차이를 계산합니다.
		int diffYears = endYear - strYear;
		
		// 일 차이 결과를 출력합니다.
		System.out.println(diffDays);	
		
		int plan_amount = dto.getPlan_amount();
		double plan_amout_per_day = (double)(plan_amount/diffDays);
		
		for(int i=0; i<=diffDays; i++) {	
			
		java.sql.Date sqlStartDate = new java.sql.Date(calStrDt.getTimeInMillis());	
			
		dto.setPlan_start_date(sqlStartDate);
		
		int dailyAmount = (int) Math.round(plan_amout_per_day);
		
		// 마지막 일에 나머지 몰아넣기
		if (i == diffDays) { 
			dailyAmount = plan_amount - (dailyAmount * (diffDays));
		}
		dto.setPlan_amount(dailyAmount);
		
		int insertCount_sp = this.spDAO.insertSP(dto);
		
		// 시작일에 1일을 추가 합니다 
		calStrDt.add(Calendar.DAY_OF_MONTH,1);
		
		System.out.println("sqlStartDate :"+ sqlStartDate);
		
		}
		return insertCount;
	}
	
	public int delete(String[] plan_numbers) {
		Plan_ManagementDAO dao = new Plan_ManagementDAO();
		return dao.deletOne(plan_numbers);
	}
	
	public int modify(Plan_ManagementDTO plDTO) {
		
		Plan_ManagementDAO plDAO = new Plan_ManagementDAO();
		return plDAO.modify(plDTO);
	}
	
}
