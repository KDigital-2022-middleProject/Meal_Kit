
package controller;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.User;
import service.UserService;
import service.UserServiceImpl;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("join")
	public ModelAndView join(User user) {
		ModelAndView mav = new ModelAndView();

		try {
			user.setAuthority("USER"); // 회원가입은 유저
			service.userInsert(user);
			mav.addObject("user", user);

		} catch (DataIntegrityViolationException e) { // 중복 데이터
			e.printStackTrace();
			mav.addObject("result", "회원가입 실패");
			return mav;
		}
		mav.setViewName("redirect:/user/login");
		return mav;
	}

	@GetMapping("login")
	public String login() { // 로그인 페이지 이동 return
		return "user/login";
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      if (auth != null && auth.isAuthenticated()) {
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	      }
		return "redirect:/main";
	}

	@RequestMapping("login")
	public String logindo(Model model, Principal principal) {

		String user_id = "";
		try {
			if( user_id != null) {
			user_id = principal.getName();
			System.out.println("user_id=" + user_id);}
		} catch (Exception e) {
			System.out.println("principal = null");
		}

		model.addAttribute("user_id", user_id);

		return "user/login";
	}
	
}
