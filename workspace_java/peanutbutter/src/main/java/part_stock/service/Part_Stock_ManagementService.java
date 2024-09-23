package part_stock.service;

import java.util.List;
import part_stock.DAO.Part_Stock_ManagementDAO;
import part_stock.DTO.Part_Stock_ManagementDTO;
import pt.DTO.Part_ManagementDTO;

public class Part_Stock_ManagementService {

	Part_Stock_ManagementDAO pt_stockDAO = new Part_Stock_ManagementDAO();
	
	public List get_PT_Stock(String a) {
		Part_Stock_ManagementDAO ptDAO = new Part_Stock_ManagementDAO();
		
		List result = ptDAO.select_PT_Stock(a);
		
		return result;
	}
	
	public Part_Stock_ManagementDTO get(String part_code) {
		
		Part_Stock_ManagementDAO pt_stockDAO = new Part_Stock_ManagementDAO();
		
		Part_Stock_ManagementDTO dto = new Part_Stock_ManagementDTO();
		
		dto = pt_stockDAO.selectOne(part_code);
		
		return dto;
		
	}
	
	public int insertPT(Part_ManagementDTO dto) {
		int insertCount = this.pt_stockDAO.insert_PT_Stock(dto);
		return insertCount;
	}
	
	public int delete(String[] part_codes) {
		Part_Stock_ManagementDAO dao = new Part_Stock_ManagementDAO();
		return dao.deletOne(part_codes);
	}
	
	public int modify(Part_Stock_ManagementDTO pt_stockDTO) {
		
		Part_Stock_ManagementDAO pt_stockDAO = new Part_Stock_ManagementDAO();
		return pt_stockDAO.modify(pt_stockDTO);
	}
	
//	public List searchPM()
	
}
