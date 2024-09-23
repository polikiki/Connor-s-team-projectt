package product_stock.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import product_stock.DAO.Product_Stock_Management_PageDAO;
import sp.DTO.Specification_ManagementDTO;

public class Product_Stock_Management_Page_Service {

	public Map getpmPage(String countPerPage, String page, String search, String optionvalue ) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo-1)* count) + 1;
		int end = pageNo * count;
//		int end = start + count -1 ;
		
		Product_Stock_Management_PageDAO pm_stockPageDAO = new Product_Stock_Management_PageDAO();
		List list = pm_stockPageDAO.select_pm_stock_Page(start, end, search, optionvalue);
		
		int totalCount = pm_stockPageDAO.total_pm_stock_Page();
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("totalCount", totalCount);
		
		return map;
		
		
	
	}
	
}
