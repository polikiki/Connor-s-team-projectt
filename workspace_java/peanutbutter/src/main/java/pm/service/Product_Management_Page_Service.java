package pm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pm.DAO.Product_Management_PageDAO;

public class Product_Management_Page_Service {

	public Map getpmPage(String countPerPage, String page, String search, String optionvalue ) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo-1)* count) + 1;
		int end = pageNo * count;
//		int end = start + count -1 ;
		
		Product_Management_PageDAO pmPageDAO = new Product_Management_PageDAO();
		List list = pmPageDAO.selectpmPage(start, end, search, optionvalue);
		
		int totalCount = pmPageDAO.totalpmPage();
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
}
