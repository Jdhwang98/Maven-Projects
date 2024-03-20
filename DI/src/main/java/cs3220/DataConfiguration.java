package cs3220;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cs3220.model.GuestBookEntry;

@Configuration
public class DataConfiguration {
	@Bean
	List<GuestBookEntry> entries() {
		List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
		entries.add(new GuestBookEntry("john", "Hello from configuratio "));
		entries.add(new GuestBookEntry("jane", "Hello again from configuratio"));
		return entries;
	}
	
	@Bean
	List<GuestBookEntry> entries2() {
		List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
		entries.add(new GuestBookEntry("john", "Hello from configuration 2"));
		entries.add(new GuestBookEntry("jane", "Hello again from configuration 2"));
		return entries;
	}
}
