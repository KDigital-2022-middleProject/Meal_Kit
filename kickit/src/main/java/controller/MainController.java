package controller;


import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dto.Item;

import service.ItemService;

@Controller
@RequestMapping("main")
public class MainController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("")
	public String getItemAll(Model model,HttpServletRequest request, Principal principal) {
		System.out.println("start getItemAll method");
		String category = request.getParameter("category");
		String order = request.getParameter("order");
		String keyword = request.getParameter("keyword");
		System.out.println("category :" + category+" order : "+order);

		List<Item> items = null;
		if (keyword == null) keyword = "";
		
		if(!keyword.equals("")) {
			System.out.println("start getItemByKeyword() method");
			items = itemService.getItemByKeyword(keyword);
		}else {
			if ((category == null || category.equals("전체")) && (order==null || order.equals("none"))) {
				System.out.println("start getItem() method");
				items = itemService.getItem();
			}else if (!category.equals("전체") && !order.equals("none")) {
				System.out.println("start getItem(category,order)");
				items = itemService.getItem(category,order);
			}else if(!category.equals("전체")&& order.equals("none")) { 
				System.out.println("start getItem(category)");
				items = itemService.getItem(category);
			}else {
				System.out.println("start getItemByOrder method");
				items = itemService.getItemByOrder(order);
			}
		}
		for(Item item : items) {
			System.out.println(item);
		}
		model.addAttribute("items",items);
		try {
			model.addAttribute("email",principal.getName());
		}catch(Exception e) {
			System.out.println("로그인 필요");
		}
		
		return "main";
	}
	

}
