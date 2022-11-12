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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.User;
import service.UserServiceImpl;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	
	@GetMapping("main")
	public String getAdmin() {
		
		return "admin/main";
	}
	
	@GetMapping("accessDenied")
	public String AccessDenied() {
		return "admin/accessDenied";
	}
	
	
}
