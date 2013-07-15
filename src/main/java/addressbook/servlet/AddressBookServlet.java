package addressbook.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import addressbook.model.AddressBook;

public class AddressBookServlet extends HttpServlet {

	AddressBook book = new AddressBook();

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String firstName = request.getParameter( "firstName" );
			String phoneNumber = request.getParameter( "phoneNumber" );
			
			
			book.addEntry( firstName, phoneNumber );
			
			response.getWriter().println("Addeded " + firstName + ", there are now " +
			book.size() + " entries.");
		}
}
