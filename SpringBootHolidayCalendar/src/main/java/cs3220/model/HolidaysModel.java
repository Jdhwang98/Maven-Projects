package cs3220.model;

public class HolidaysModel {
	static int idSeed = 1;
	private int id;
	private String holidayDate;
	private String holidayName;
	
	public HolidaysModel(String holidayDate, String holidayName) {
		this.id = idSeed++;
		this.holidayDate = holidayDate;
		this.holidayName = holidayName;
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
	
	public String getHolidayName() {
		return holidayName;
	}
	
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}
}
