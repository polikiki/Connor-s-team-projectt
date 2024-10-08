package human.class1.ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import human.class1.ajax.dto.EmpDTO;
import human.class1.ajax.service.EmpService;

@Controller
public class InsertController {

	@Autowired
	EmpService empService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		
		return "empjoin";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	@ResponseBody	
	public String join(@RequestBody EmpDTO empDTO) {
		System.out.println("empDTO : "+empDTO);
		
		int result = empService.joinEmp(empDTO);
		System.out.println("회원 가입 결과 :"+ result);
	
		return "redirect:/emp";
	}
	
}
