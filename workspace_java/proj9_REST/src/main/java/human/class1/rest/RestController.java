package human.class1.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/human")
@Controller
//@RestController // @Controller + @ResponseBody
//@ResponseBody RestController 클래스 안에 있는 매소드들이 전부 가지고 있으면 올려서 전부 적용 할 수 있다
// 하지만 매소드가 100, 200개 같이 많이지면 헷갈릴 수 있으므로 각각 붙이는걸 선호
public class RestController {

	@RequestMapping("/test1")
	@ResponseBody
	public int test1() {
		return 100;
	}
	
	@RequestMapping("/test2")
	@ResponseBody
	public int test2() {
		return 100;
	}
	
}
