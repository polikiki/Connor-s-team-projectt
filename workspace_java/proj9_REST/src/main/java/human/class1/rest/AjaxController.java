package human.class1.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	/*
	 * "/rest/ajax.view" <<<<
	 * "/rest/ajax" 
	 * 
	 */
	
	@RequestMapping(value="/ajax.view", method=RequestMethod.GET)	
	public String ajaxView() {
	        
		return "ajax";
	}
	
//	@RequestBody : post로 보낸 json을 처리
	@RequestMapping(value="/ajax", method=RequestMethod.POST)	
	public String ajax( 
			// 이 2개는 parameter 방식으로 보낸다면 여전히 유효하지만 json으로 보내면 불가
			@RequestParam(value="ename", required=false)String ename,
			@ModelAttribute EmpDTO dto2,
			
			@RequestBody EmpDTO dto
			) {
		// json으로 보냈더니 @RequestParam 또는 request.getParameter로 받을 수 없다
		System.out.println("ename :"+ ename);
		System.out.println("dto2 :"+ dto2);
		System.out.println("dto :"+ dto);
		return "ajax";
	}
	
	// @ResponseBody : 그냥 값이나 json으로 리턴해줌
	@RequestMapping(value="/ajax/string", method=RequestMethod.POST)	
	// calss나 returnType에 붙이면 viewresolver를 보내지 않아서 .jsp를 붙여서 찾는게 아닌"human"이라는 String을 return 한다  
	@ResponseBody
	public String ajaxString( 
			@RequestBody EmpDTO dto
			) {
		// json으로 보냈더니 @RequestParam 또는 request.getParameter로 받을 수 없다

		System.out.println("dto :"+ dto);
		return "human";
	}
	
	@RequestMapping(value="/ajax/dto", method=RequestMethod.POST)	
	@ResponseBody
	public EmpDTO ajaxDto( 
			@RequestBody EmpDTO dto
			) {
		System.out.println("dto :"+ dto);
		return dto;
	}
	
	@RequestMapping(value="/ajax/list", method=RequestMethod.POST)	
	@ResponseBody
	public List ajaxList( 
			@RequestBody EmpDTO dto
			) {
		System.out.println("dto :"+ dto);
		
		List list = new ArrayList();
		list.add(dto);
		list.add(dto);
		list.add(dto);
		
		return list;
	}
	
	@RequestMapping(value="/ajax/forward", method=RequestMethod.GET)	
	public String ajaxForward() {
	        
		return "forward:/ajax.view";
	}
	
	@RequestMapping(value="/ajax/redirect", method=RequestMethod.GET)	
	public String ajaxRedirect() {
	        
		return "redirect:/ajax.view";
	}
	
	@RequestMapping(value="/ajax/notice/{num}/static/{str}")
	@ResponseBody
	public int notice(
			@PathVariable("num")
			int number,
			
			@PathVariable("str") String str1,
			
			HttpServletRequest request
			) {
		System.out.println(request.getParameter("num"));
		System.out.println("number :"+ number);
		System.out.println("str1 :"+ str1);
		return number;
	}
	
}