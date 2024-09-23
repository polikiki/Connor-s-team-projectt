package pt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pt.DAO.Part_Management_PageDAO;

public class Part_Management_Page_Service {

	public Map getptPage(String countPerPage, String page, String search, String optionvalue ) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo-1)* count) + 1;
		int end = pageNo * count;
//		int end = start + count -1 ;
		
		Part_Management_PageDAO ptPageDAO = new Part_Management_PageDAO();
		List list = ptPageDAO.selectptPage(start, end, search, optionvalue);
		
		int totalCount = ptPageDAO.totalptPage();
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
}
