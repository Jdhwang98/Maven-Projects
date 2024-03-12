package cs3220.model;

public class HolidayCalendarEntry {
	static int idSeed = 1;
	private int id;
	private String holidayDate;
	private String holiday;
	private String day;
	private String month;
	private String year;
	
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

	
	
	public HolidayCalendarEntry(String holidayDate, String holiday) { //, String day, String month, String year
		this.id = idSeed++;
		this.holidayDate = holidayDate;
		this.holiday = holiday;
//		this.holiday = day;
//		this.holiday = month;
//		this.holiday = year;
	}

	public int getId() {
	return id;
	}

	public void setId(int id) {
	this.id = id;
	}

	public String getHolidayDate() {
	return holidayDate;
}

	public void setHolidayDate(String holidayDate) {
	this.holidayDate = holidayDate;
	}

	public String getHoliday() {
	return holiday;
	}

	public void setHoliday(String holiday) {
	this.holiday = holiday;
	}
}

	