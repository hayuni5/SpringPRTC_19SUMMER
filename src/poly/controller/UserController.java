package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.UserDTO;
import poly.service.IUserService;

@Controller
public class UserController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="UserService")
	private IUserService userservice;

	@RequestMapping("/userReg")
	public String userReg() throws Exception {	
		
		log.info(this.getClass().getName());
		
		return "/user/userReg";
	}
	
	@RequestMapping("/userRegProc")
	public String userRegProc(HttpServletRequest request, Model model) throws Exception {
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
		log.info("userId 확인 :" +userId);
		log.info("userName 확인 :" +userName);
		log.info("userPassword 확인 :" +userPassword);
		
		UserDTO uDTO = new UserDTO();
		uDTO.setUserId(userId);
		uDTO.setUserPassword(userPassword);
		uDTO.setUserName(userName);
		
		int result = 0;
		
		result = userservice.userRegProc(uDTO); 
		log.info("결과값 : " + result);
		
		
		
		if(result>0) {
			model.addAttribute("url", "/index.do");
			model.addAttribute("msg", "가입되었습니다.");
			
		
		} else {
			model.addAttribute("url", "/index.do");
			model.addAttribute("msg", "가입 실패했습니다.");
		}
		
		return "/redirect";		
	}
	
	@RequestMapping(value="/userLogin")
	public String login(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		//로그인 로직은 아이디, 비밀번호를 받아와 조회해서 있는지 없는지 확인해주면 됨!
		
		//1. jsp에서 가져온 값을 String 변수에 담음
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		
		log.info("userId 확인 : "+userId);
		log.info("userPassword 확인 : "+userPassword);
		
		//2. String변수값을 DTO에 세팅
		UserDTO uDTO = new UserDTO();
		uDTO.setUserId(userId);
		uDTO.setUserPassword(userPassword);
		
		//3. DTO를 변수로 service, mapper, mapper.xml 에 보내고 메소드를 실행
		//결과값은 UserDTO형태로 받아오기
		//그 이유는 일치하는 사람의 정보만 받아올 것이기 때문
		
		
		//있다는 가정하에 메소드 만들기
		uDTO = userservice.getLogin(uDTO);
		
		if(uDTO == null) {
			model.addAttribute("url", "/index.do");
			model.addAttribute("msg", "로그인에 실패했습니다.");
			
			log.info("실패");
			
		}else {
			model.addAttribute("url", "/index.do");
			model.addAttribute("msg", "로그인했습니다.");
			session.setAttribute("userId", uDTO.getUserId());
			session.setAttribute("userName", uDTO.getUserName());
			session.setAttribute("userSeq", uDTO.getUserSeq());
			log.info("성공 " + uDTO);
		}
		return "/redirect";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session, Model model) throws Exception {
		//세션을 초기화시킴
		session.invalidate();
		model.addAttribute("msg", "르그아웃했습니다.");
		model.addAttribute("url", "/index.do");
		return "/redirect";
		
	}
	
	
}
