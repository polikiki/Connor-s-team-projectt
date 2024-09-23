package sp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sp.DAO.Specification_Management_PageDAO;

public class Specification_Management_Page_Service {

	public Map getspPage(String countPerPage, String page, String search, String optionvalue ) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo-1)* count) + 1;
		int end = pageNo * count;
//		int end = start + count -1 ;
		
		Specification_Management_PageDAO spPageDAO = new Specification_Management_PageDAO();
		List list = spPageDAO.selectspPage(start, end, search, optionvalue);
		
		int totalCount = spPageDAO.totalspPage();
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
}
