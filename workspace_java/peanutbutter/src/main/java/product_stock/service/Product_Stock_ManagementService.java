package product_stock.service;

import java.util.List;

import pl.DAO.Plan_ManagementDAO;
import product_stock.DAO.Product_Stock_ManagementDAO;
import product_stock.DTO.Product_Stock_ManagementDTO;
import sp.DTO.Specification_ManagementDTO;
import pm.DTO.Product_ManagementDTO;

public class Product_Stock_ManagementService {

	Product_Stock_ManagementDAO pm_stock_DAO = new Product_Stock_ManagementDAO();
	
	public List get_PM_stock(String a) {
		Product_Stock_ManagementDAO pmDAO = new Product_Stock_ManagementDAO();
		
		List result = pmDAO.select_PM_stock(a);
		
		return result;
	}
	
	public Product_Stock_ManagementDTO get(String product_code) {
		
		Product_Stock_ManagementDAO pm_stock_DAO = new Product_Stock_ManagementDAO();
		
		Product_Stock_ManagementDTO dto = new Product_Stock_ManagementDTO();
		
		dto = pm_stock_DAO.selectOne(product_code);
		
		return dto;
		
	}
	
	public int insert_PM_stock(Product_ManagementDTO dto) {
		int insertCount = this.pm_stock_DAO.insert_PM_stock(dto);
		return insertCount;
	}
	
	public int delete(String[] product_codes) {
		Product_Stock_ManagementDAO dao = new Product_Stock_ManagementDAO();
		return dao.deletOne(product_codes);
	}
	
	public List<Specification_ManagementDTO> getSP_data() {
		Product_Stock_ManagementDAO dao = new Product_Stock_ManagementDAO();
		
		return dao.selectSP_data();
	}
	
	public List getPL_data() {
		Product_Stock_ManagementDAO dao = new Product_Stock_ManagementDAO();
		
		return dao.selectPL_data();
	}
	
	public int modify_pm_stock(Specification_ManagementDTO spDTO) {
		
		Product_Stock_ManagementDAO pm_stock_DAO = new Product_Stock_ManagementDAO();
		return pm_stock_DAO.modify(spDTO);
	}
	
}
