package part_stock.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import part_stock.DAO.Part_Stock_Management_PageDAO;

public class Part_Stock_Management_Page_Service {

	public Map get_pt_stockPage(String countPerPage, String page, String search, String optionvalue ) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo-1)* count) + 1;
		int end = pageNo * count;
//		int end = start + count -1 ;
		
		Part_Stock_Management_PageDAO pt_stockPageDAO = new Part_Stock_Management_PageDAO();
		List list = pt_stockPageDAO.select_pt_stockPage(start, end, search, optionvalue);
		
		int totalCount = pt_stockPageDAO.total_pt_stockPage();
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
}
