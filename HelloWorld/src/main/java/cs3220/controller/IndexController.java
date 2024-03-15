package cs3220.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cs3220.model.GuestBookEntry;

public class IndexController {
	
	private List<GuestBookEntry> entries;
	
	public IndexController() {
		entries = new ArrayList<GuestBookEntry>();
		entries.add(new GuestBookEntry("John", "Hello"));
		entries.add(new GuestBookEntry("Jane", "Hello again"));
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("entries",entries);
		return "index";
	}
	
}
