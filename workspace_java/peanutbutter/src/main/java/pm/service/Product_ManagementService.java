package pm.service;

import java.util.List;
import pm.DAO.Product_ManagementDAO;
import pm.DTO.Product_ManagementDTO;
import product_stock.DAO.Product_Stock_ManagementDAO;

public class Product_ManagementService {

	Product_ManagementDAO pmDAO = new Product_ManagementDAO();
	Product_Stock_ManagementDAO pm_stockDAO = new Product_Stock_ManagementDAO();
	
	public List getPM(String a) {
		Product_ManagementDAO pmDAO = new Product_ManagementDAO();
		
		List result = pmDAO.selectPM(a);
		
		return result;
	}
	
	public Product_ManagementDTO get(String product_code) {
		
		Product_ManagementDAO pmDAO = new Product_ManagementDAO();
		
		Product_ManagementDTO dto = new Product_ManagementDTO();
		
		dto = pmDAO.selectOne(product_code);
		
		return dto;
		
	}
	
	public int insertPM(Product_ManagementDTO dto) {
		
		long sequence = pmDAO.selectSequence();
		
		System.out.println("sequence "+ sequence);
		
		String sequenceString = Long.toString(sequence);
		
		dto.setProduct_code(sequenceString);
		
		System.out.println("dto: "+dto);
		
		int insertCount = this.pmDAO.insertPM(dto);
		int insertCount_stock = this.pm_stockDAO.insert_PM_stock(dto);
		
		return insertCount;
	}
	
	public int delete(String[] product_codes) {
		Product_ManagementDAO dao = new Product_ManagementDAO();
		return dao.deletOne(product_codes);
	}
	
	public int modify(Product_ManagementDTO pmDTO) {
		
		Product_ManagementDAO pmDAO = new Product_ManagementDAO();
		return pmDAO.modify(pmDTO);
	}
	
//	public List searchPM()
	
}
