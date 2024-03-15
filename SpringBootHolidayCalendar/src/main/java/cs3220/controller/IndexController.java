package cs3220.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cs3220.model.HolidaysModel;

@Controller
public class IndexController {
	private List<HolidaysModel> entries;
	
	public IndexController() {
		entries = new ArrayList<HolidaysModel>();
		entries.add(new HolidaysModel("2024-01-01", "New Year's Day"));
		entries.add(new HolidaysModel("2024-01-15", "Martin Luther King Jr. Day"));
		entries.add(new HolidaysModel("2024-02-12", "Lincoln's Birthday"));
		entries.add(new HolidaysModel("2024-02-19", "Presidents' Day"));
		entries.add(new HolidaysModel("2024-07-04", "Independence Day"));
		entries.add(new HolidaysModel("2024-09-02", "Labor Day"));
		entries.add(new HolidaysModel("2024-11-28", "Thanksgiving Day"));
		entries.add(new HolidaysModel("2024-12-25", "Christmas Day"));
	}
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("entries", entries);
		return "index";
	}
}
