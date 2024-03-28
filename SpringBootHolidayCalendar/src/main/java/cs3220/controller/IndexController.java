package cs3220.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		Collections.sort(entries);
	}
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("entries", entries);
		return "index";
	}
	
	@GetMapping("/addHoliday") 
	public String addHoliday(Model model) {
		int dayRange = 31;
		int yearRange = 2030;
		int initialYear = 1994;
		List<String> days = new ArrayList<>();
		for (int i = 1; i <=dayRange ; i++) {
			if (i <= 9) {
				days.add("0" + Integer.toString(i));
			}
			else {
				days.add(Integer.toString(i));
			}
		}
		//this is for the drop down for months
		List<String> months = new ArrayList<>(Arrays.asList(
				"January", "February", "March", "April", "May", 
				"June", "July", "August", "September", "October", 
				"November", "December"));
		//this is for the drop down for years
		List<Integer> years = new ArrayList<>();
		for (int i = initialYear; i <= yearRange; i++) {
			years.add(i);
		}
		
		model.addAttribute("days", days);
		model.addAttribute("months", months);
		model.addAttribute("years", years);
		return "addHoliday";
	}
	
	@PostMapping("/addHoliday")
	public String addHoliday(HolidaysModel entry, Model model, int id, String day, String month, String year, String holidayName) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
		String date1 = day + "-" + month + "-" + year.replace("," ,"");
		LocalDate date2 = LocalDate.parse(date1, formatter);
		entry.setHolidayDate(date2);
        Collections.sort(entries);
		return "redirect:/";
	}
	
	@GetMapping("/updateHoliday")
	public String updateHoliday(Model model, int id) {
		
		int dayRange = 31;
		int yearRange = 2030;
		int initialYear = 1994;
		List<String> days = new ArrayList<>();
		for (int i = 1; i <=dayRange ; i++) {
			if (i <= 9) {
				days.add("0" + Integer.toString(i));
			}
			else {
				days.add(Integer.toString(i));
			}
		}
		//this is for the drop down for months
		List<String> months = new ArrayList<>(Arrays.asList(
				"January", "February", "March", "April", "May", 
				"June", "July", "August", "September", "October", 
				"November", "December"));
		//this is for the drop down for years
		List<Integer> years = new ArrayList<>();
		for (int i = initialYear; i <= yearRange; i++) {
			years.add(i);
		}
		
		model.addAttribute("days", days);
		model.addAttribute("months", months);
		model.addAttribute("years", years);
		model.addAttribute("entries",entries);
		
		return "update";
	}
	
	@PostMapping("/updateHoliday")
	public String postUpdateHoliday(HolidaysModel entry, Model model,  String day, String month, String year, int id, String holidayName) {
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
		String date1 = day + "-" + month + "-" + year.replace("," ,"");
		LocalDate date2 = LocalDate.parse(date1, formatter);
		entry.setId(id);
		entry.setHolidayDate(date2);
		entry.setHolidayName(holidayName);
		Collections.sort(entries);

		return "redirect:/";
	}
	
	public String deleteHoliday(Model model, int id) {
		for (int i = 0; i < entries.size(); i++) {
			if (id == entries.get(i).getId()) {
				entries.remove(entries.get(i));
				break;
			}
		}
		return "redirect:/";
	}
	
}
