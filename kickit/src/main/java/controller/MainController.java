package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.Item;
import dto.User;
import service.ItemService;
import service.ItemServiceImpl;

@Controller
@RequestMapping("main")
public class MainController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("")
	public String getItemAll(Model model) {
		System.out.println("start getItemAll method");
		List<Item> items = itemService.getItemAll();
		model.addAttribute("items",items);
		return "main";
	}
}
