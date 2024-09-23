package pl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.DAO.Plan_Management_PageDAO;

public class Plan_Management_Page_Service {

	public Map getplPage(String countPerPage, String page, String search, String optionvalue ) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo-1)* count) + 1;
		int end = pageNo * count;
//		int end = start + count -1 ;
		
		Plan_Management_PageDAO plPageDAO = new Plan_Management_PageDAO();
		List list = plPageDAO.selectplPage(start, end, search, optionvalue);
		
		int totalCount = plPageDAO.totalplPage();
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
}
