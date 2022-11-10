package controller;

import java.security.Principal;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.User;
import service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService service;


	@PostMapping("join")
	public ModelAndView join (User user ) {
		ModelAndView mav = new ModelAndView();

		try {
			user.setAuthority("USER"); // 회원가입은 유저
			service.userInsert(user);
			mav.addObject("user",user);

		} catch(DataIntegrityViolationException e) { // 중복 데이터
			e.printStackTrace();
			mav.addObject("result","회원가입 실패");
			return mav;
		}
		mav.setViewName("redirect:/");
		return mav;
	}
	

	
	@RequestMapping("login")
	public String securityIndex2_2(Model model, Principal principal) {
		
		String id = "";
		try {
			if (principal!=null) {
			id = principal.getName();
			System.out.println("user_id="+id);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("id", id);
		
		return "user/login";
	}
	
	@GetMapping("main")
	public String main() {

		return "/";
	}
}
