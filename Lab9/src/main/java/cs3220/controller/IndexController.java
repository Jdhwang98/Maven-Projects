package cs3220.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cs3220.DataComponent;
import cs3220.model.HolidaysModel;
import jakarta.validation.Valid;

@Controller
public class IndexController {
	private DataComponent dataComponent;
	
	
	public IndexController(DataComponent dataComponent) {
		//this is all handled in data component using the constructor!!!
		//now you can use model to handle everything
		this.dataComponent = dataComponent;
	}
	
	
	//this is how you connect the index with all the calendar entries
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("entries", dataComponent.getEntries());
		return "index";
	}
	
	//this is how you map addHoliday 
	@GetMapping("/addHoliday")
	public String addHoliday(Model model) {
		//this is for the drop down for days!!!
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
	public String add(Model model, @Valid @ModelAttribute("entry") HolidaysModel entry, 
			String name, String day, String month, String year, String holidayName, BindingResult validationResult) {
		
		if(validationResult.hasErrors()) {
			return "/addHoliday";
		}
		
		String errorMessage = null;
		String dayEntry = entry.getDay();
		String monthEntry = entry.getMonth();
		String yearEntry = entry.getYear();
		
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
		String date1 = day + "-" + month + "-" + year.replace("," ,"");
		LocalDate date2 = LocalDate.parse(date1, formatter);
		entry.setHolidayDate(date2);
		
		String checkDate = date2.toString();
		boolean duplicateExists = dataComponent.checkHolidayDuplicate(checkDate);
		if (duplicateExists) {
			errorMessage = "Holiday already exists";
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
			
			return "/addHoliday";
		}
		else {
			dataComponent.getEntries().add(entry);
	        Collections.sort(dataComponent.getEntries());
			return "redirect:/";
		}
	}


	//this is how you map updateHoliday 
	@GetMapping("/updateHoliday/{id}")
	public String updateHoliday(@PathVariable int id, Model model) {
		
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
		
		model.addAttribute("entry", dataComponent.getEntryById(id));
		return "updateHoliday";
	}
	

	@PostMapping("/updateHoliday/{id}")
	public String updateHoliday(@PathVariable int id,@ModelAttribute("entry") HolidaysModel newEntry, 
			String name, String day, String month, String year, String holidayName) {
		
		HolidaysModel entry = dataComponent.getEntryById(id);
			
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
		String date1 = day + "-" + month + "-" + year.replace("," ,"");
		LocalDate date2 = LocalDate.parse(date1, formatter);
		
		entry.setHolidayDate(date2);
		entry.setHolidayDate(entry.getHolidayDate());
		entry.setHolidayName(entry.getHolidayName());
		Collections.sort(dataComponent.getEntries());
		return "redirect:/";
	}
	
	
	@GetMapping("/index/{id}")
    public String deleteHoliday(@PathVariable int id,@ModelAttribute("entry") HolidaysModel newEntry) {
		
		HolidaysModel entry = null;
    	for (HolidaysModel temporary: dataComponent.getEntries() ) {
    		if (temporary.getId() == id) {
                entry = temporary;
                break;
            }
        }
        
        if (entry != null) {
            dataComponent.getEntries().remove(entry);
        }
        
        
		return "redirect:/";
	}	
	
}
