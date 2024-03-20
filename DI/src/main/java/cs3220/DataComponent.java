package cs3220;

import java.util.ArrayList;
import java.util.List;

import cs3220.model.GuestBookEntry;

public class DataComponent {
	private List<GuestBookEntry> entries;
	
	public DataComponent() {
		entries = new ArrayList<GuestBookEntry>();
		entries.add(new GuestBookEntry("john", "Hello from component"));
		entries.add(new GuestBookEntry("jane", "Hello again from component"));
	}
	
	public List<GuestBookEntry> getEntries() {
		return entries;
	}
	
	public void setEntries(List<GuestBookEntry> entries) {
		this.entries = entries;
	}
}
