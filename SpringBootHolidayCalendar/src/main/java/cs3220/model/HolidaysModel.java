package cs3220.model;

import java.time.LocalDate;

public class HolidaysModel implements Comparable<HolidaysModel> {
	static int idSeed = 1;
	private int id;
	private LocalDate holidayDate;
	private String holidayName;
	
	public HolidaysModel(String holidayDate, String holidayName) {
		this.id = idSeed++;
		this.holidayDate = LocalDate.parse(holidayDate);
		this.holidayName = holidayName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDate getHolidayDate() {
		return holidayDate;
	}
	
	public void setHolidayDate(LocalDate holidayDate) {
		this.holidayDate = holidayDate;
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
		LocalDate date1 = this.holidayDate;
		LocalDate date2 = other.holidayDate;
		
		if (date1.isBefore(date2)) {
			return -1;
		}
		if (date1.isAfter(date2)) {
			return 1;
		}
		return 0;
	}
}
