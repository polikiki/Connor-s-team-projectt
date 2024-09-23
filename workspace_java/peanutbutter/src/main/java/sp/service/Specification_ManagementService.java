package sp.service;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import sp.DTO.Specification_ManagementDTO;
import sp.DAO.Specification_ManagementDAO;

public class Specification_ManagementService {

	Specification_ManagementDAO spDAO = new Specification_ManagementDAO();
	
//	public List getPM_data() {
//		Plan_ManagementDAO plDAO = new Plan_ManagementDAO();
//		
//		List result = plDAO.selectPM_data();
//		
//		return result;
//	}
//	
//	public List getPM_data_one(String product_code) {
//		Plan_ManagementDAO plDAO = new Plan_ManagementDAO();
//		
//		List result = plDAO.selectPM_data_one(product_code);
//		
//		return result;
//	}
//	
	public Specification_ManagementDTO get(String specification_number) {
		
		Specification_ManagementDAO spDAO = new Specification_ManagementDAO();
		
		Specification_ManagementDTO dto = new Specification_ManagementDTO();
		
		dto = spDAO.selectOne(specification_number);
		
		return dto;
		
	}
//	
//	public int insertPL(Plan_ManagementDTO dto) {
//		int insertCount = this.plDAO.insertPL(dto);
//		
//		Date plan_start_date = dto.getPlan_start_date();
//		Date plan_end_date = dto.getPlan_end_date();
//		
//		for(int i=0;i<7;i++) {
//		int insertCount_sp = this.spDAO.insertSP(dto);
//		}
//		return insertCount;
//	}
//	
	public int delete(String[] specification_numbers) {
		Specification_ManagementDAO dao = new Specification_ManagementDAO();
		return dao.deletOne(specification_numbers);
	}
	
	public int modify(Specification_ManagementDTO spDTO) {
		
		Specification_ManagementDAO spDAO = new Specification_ManagementDAO();
		return spDAO.modify(spDTO);
	}
	
}
