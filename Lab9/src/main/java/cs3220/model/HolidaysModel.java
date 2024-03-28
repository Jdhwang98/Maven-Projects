package cs3220.model;

import java.time.LocalDate;
import java.util.Collections;

import jakarta.validation.constraints.NotBlank;

public class HolidaysModel implements Comparable<HolidaysModel> {
	static int idSeed = 1;
	private int id;
	private String holidayName;
	private LocalDate date;
	private String day,month,year;
	
	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public HolidaysModel(String date, String holidayName) {
		this.id = idSeed++;
		this.holidayName = holidayName;
		this.date = parseDate(date);
		
		//Collections.sort();
	}
	

	public int getId() {
		return id;
	}
	
	public LocalDate getHolidayDate() {
		return date;
	}
	
	public void setHolidayDate(LocalDate date) {
		this.date = date;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getHolidayName() {
		return holidayName;
	}
	
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}
	
	public LocalDate parseDate(String date) {
		if (date != null) {
			LocalDate parsedDate = LocalDate.parse(date);
			return parsedDate;
		}
		return null;
	}
	
	 @Override
	    public int compareTo(HolidaysModel other) {
		 LocalDate date1 = this.date;
	     LocalDate date2  = other.date;

	     if(date1.isBefore(date2)){
	            return -1;
	     }
	     if(date1.isAfter(date2)){
	            return 1;
	     }
	    return 0;
	   }
	
}
