package addressbook.model;

import java.util.HashMap;
import java.util.Map;

public class AddressBook {
	
	private Map<String, String> addressMap = new HashMap<String, String>();

	public void addEntry(String firstName, String phoneNumber) {
		addressMap.put( firstName,  phoneNumber );
		
	}

	public int size() {
		// TODO Auto-generated method stub
		return addressMap.size();
	}

}
