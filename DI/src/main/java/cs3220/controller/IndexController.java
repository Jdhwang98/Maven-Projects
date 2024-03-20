package cs3220.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cs3220.model.GuestBookEntry;

public class IndexController {
	
	private List<GuestBookEntry> entries;
	
	public IndexController(List<GuestBookEntry> entries2) {
		this.entries = entries2;
		
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("entries", entries);
		return "index";
	}
}
