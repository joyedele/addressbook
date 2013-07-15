package addressbook.servlet;

import static org.junit.Assert.*;

import org.junit.Test;

import addressbook.model.AddressBook;

public class AddressBookServletTest {

	@Test
	public void test() {
		AddressBook book = new AddressBook();
		
		assertEquals(0, book.size());
		book.addEntry("John", "2145648780");
		
		assertEquals(1, book.size() );
	}

}
