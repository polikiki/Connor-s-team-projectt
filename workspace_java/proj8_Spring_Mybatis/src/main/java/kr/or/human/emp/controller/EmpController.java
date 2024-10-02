package kr.or.human.emp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.human.emp.dto.EmpDTO;
import kr.or.human.emp.service.EmpService;

@Controller
public class EmpController {

	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	EmpService empService;
	
	@RequestMapping("/member")
	public String listEmp(Model model) {
		
		List<EmpDTO> list = empService.listEmp();
		model.addAttribute("emplist",list);
		
//		System.out.println("list.size() :"+ list.size());
		logger.debug("debug list.size() : "+ list.size());
		logger.info("debug list.size() : "+ list.size());
		logger.warn("debug list.size() : "+ list.size());
		logger.error("debug list.size() : "+ list.size());
		
		return "emp";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		
		return "empjoin";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join2(@ModelAttribute("empDTO") EmpDTO empDTO, Model model) {
		int result = empService.joinEmp(empDTO);
		System.out.println("회원 가입 결과 :"+ result);
	
		return "redirect:/member";
//		return "forward:member";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(@RequestParam("empno") int empno, Model model) {
			
		EmpDTO empDTO = empService.detailEmp(empno);
		
		model.addAttribute("empDTO",empDTO);
		model.addAttribute("cmd","detail");
		return "empjoin";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String edit(@RequestParam("empno") int empno, Model model) {
			
		EmpDTO empDTO = empService.detailEmp(empno);
		
		model.addAttribute("empDTO",empDTO);
		model.addAttribute("cmd","edit");
		return "empjoin";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String edit(EmpDTO empDTO, Model model) {
			
		int result = empService.modifyEmp(empDTO);
		System.out.println("업데이트 결과 :"+ result);
		
		return "redirect:/member";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(EmpDTO empDTO, Model model) {
			
		int result = empService.deleteEmp(empDTO);
		System.out.println("삭제 결과 :"+ result);
		
		return "redirect:/member";
	}
}