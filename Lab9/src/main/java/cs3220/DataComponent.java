package cs3220;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import cs3220.model.HolidaysModel;

@Component
public class DataComponent {
	
	private List<HolidaysModel> entries;
	
	public DataComponent() {
		entries = new ArrayList<HolidaysModel>();
		entries.add(new HolidaysModel("2024-01-01", "New Year's Day"));
		entries.add(new HolidaysModel("2024-01-15", "Martin Luther King Jr. Day"));
		entries.add(new HolidaysModel("2024-02-12", "Lincoln's Birthday"));
		entries.add(new HolidaysModel("2024-02-19", "Presidents' Day"));
		entries.add(new HolidaysModel("2024-07-04", "Independence Day"));
		entries.add(new HolidaysModel("2024-09-02", "Labor Day"));
		entries.add(new HolidaysModel("2024-11-28", "Thanksgiving Day"));
		entries.add(new HolidaysModel("2024-12-25", "Christmas Day"));
		//check sorting algorithm
		Collections.sort(entries);
	}
	
	public boolean checkHolidayDuplicate(String holidayDate) {
		boolean exists = false;
		for (HolidaysModel existingHoliday : entries) {
			if (existingHoliday.getHolidayDate().toString().equals(holidayDate)) {
				exists = true;
				break;
			}
		}
		return exists;
	}
	
	public HolidaysModel getEntryById(int id) {
		for (HolidaysModel entry : entries) {
			if (entry.getId() == id) {
				return entry;
			}
			else {
				continue;
			}
		}
		return null;
	}
	
	public List<HolidaysModel> getEntries() {
		return entries;
	}
	
	public void setEntries(List<HolidaysModel> entries) {
		this.entries = entries;
		Collections.sort(entries);
	}
}
