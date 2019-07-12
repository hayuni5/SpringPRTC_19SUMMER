package poly.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;		//어노테이션 Controller 따라서
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;	//어노테이션 RequestMapping 따라서
import org.springframework.web.bind.annotation.RequestMethod;

//자동 임포트!!

@Controller
public class MainController {

	@RequestMapping(value="index")
	public String Index() {
		return "/index";	//이게 뭐였지?
	}
	
	@RequestMapping(value="receive", method=RequestMethod.POST)
	public String Receive(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "/receive";
	}
	
}
