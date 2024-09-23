package pt.service;

import java.util.List;

import part_stock.DAO.Part_Stock_ManagementDAO;
import pt.DAO.Part_ManagementDAO;
import pt.DTO.Part_ManagementDTO;

public class Part_ManagementService {

	Part_ManagementDAO ptDAO = new Part_ManagementDAO();
	Part_Stock_ManagementDAO pt_stockDAO = new Part_Stock_ManagementDAO();
	
	public List getPT(String a) {
		Part_ManagementDAO ptDAO = new Part_ManagementDAO();
		
		List result = ptDAO.selectPT(a);
		
		return result;
	}
	
	public Part_ManagementDTO get(String part_code) {
		
		Part_ManagementDAO ptDAO = new Part_ManagementDAO();
		
		Part_ManagementDTO dto = new Part_ManagementDTO();
		
		dto = ptDAO.selectOne(part_code);
		
		return dto;
		
	}
	
	public int insertPT(Part_ManagementDTO dto) {
		
		long sequence = ptDAO.selectSequence();
		
		System.out.println("sequence "+ sequence);
		
		String sequenceStriong = Long.toString(sequence);
		
		dto.setPart_code(sequenceStriong);
		
		System.out.println("dto: "+dto);
		
		int insertCount = this.ptDAO.insertPT(dto);
		
		int insertCount_sp = this.pt_stockDAO.insert_PT_Stock(dto);
		
		return insertCount;
	}
	
	public int delete(String[] part_codes) {
		Part_ManagementDAO dao = new Part_ManagementDAO();
		return dao.deletOne(part_codes);
	}
	
	public int modify(Part_ManagementDTO ptDTO) {
		
		Part_ManagementDAO ptDAO = new Part_ManagementDAO();
		return ptDAO.modify(ptDTO);
	}
	
//	public List searchPM()
	
}
