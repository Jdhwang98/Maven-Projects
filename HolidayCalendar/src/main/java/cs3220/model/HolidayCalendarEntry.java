package cs3220.model;

public class HolidayCalendarEntry {
	static int idSeed = 1;
	private int id;
	private String holidayDate;
	private String holiday;
	
	public HolidayCalendarEntry(String holidayDate, String holiday) {
		this.id = idSeed++;
		this.holidayDate = holidayDate;
		this.holiday = holiday;
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

	