
package controller;


import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.User;
import service.UserServiceImpl;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired

	private UserServiceImpl service;

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
		mav.setViewName("redirect:/");
		return mav;
	}

	@GetMapping("login")
	public String login() { // 로그인 페이지 이동 return
		return "user/login";
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

	@RequestMapping("main")
	public String main(Principal principal, Model model) {
		/*
		 * controller에서 시큐리티를 통해 로그인 한 사용자정보 얻어오기 : @Controller로 선언된 클래스에서는 메소드 인자로
		 * Principal 객체를 통해 사용자 아이디를 얻어올수 있다.
		 */

		// 1.Principal 객체를 통한 사용자 아이디 얻기
		String user_id = principal.getName();
		System.out.println("user_id=" + user_id);

		model.addAttribute("user_id", user_id);

		return "/main";
	}

	// 로그아웃 시 -> 세션 해제 잊지 말기!
}
