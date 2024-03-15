package cs3220.model;

import java.time.LocalDate;

public class GuestBookEntry {
	private static int idSeed = 1;
	private int id;
	private String name;
	private String message;
	private LocalDate date;
	
	public GuestBookEntry(String name, String message) {
		this.id = idSeed++;
		this.name = name;
		this.message = message;
		this.date = LocalDate.now();
	}
	
	public String getAll() {
		return name + " says " + message + " on " + date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
