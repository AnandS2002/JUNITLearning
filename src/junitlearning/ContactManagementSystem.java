package junitlearning;

import java.util.HashMap;

import exceptions.ContactNotFoundException;
import interfaces.*;

public class ContactManagementSystem implements ContactManagement {
	HashMap<String, Contacts> contacts = new HashMap<>();

	public boolean addContact(Contacts c) {
		if (contacts.containsKey(c.phoneNumber)) {
			System.out.println("Number Already Exist");
			return false;
		}
		if (c.phoneNumber.length() == 10) {
			if (c.lastName.length() != 0 && c.firstName.length() != 0) {
				contacts.put(c.phoneNumber, c);
				return true;
			} else
				return false;
		}
		return false;
	}

	public boolean deleteContact(String phoneNumber) {
		if (phoneNumber.length() != 10) {
			System.out.println("Enter Valid Phone Number");
			return false;
		}
		if (contacts.containsKey(phoneNumber)) {
			contacts.remove(phoneNumber);
			return true;
		} else {
			System.out.println("Contact Not Found");
			return false;
		}
	}

	public boolean editContact(Contacts c1) {
		if (c1.phoneNumber.length() != 10)
			return false;
		if (contacts.containsKey(c1.phoneNumber)) {
			contacts.remove(c1.phoneNumber);
			contacts.put(c1.phoneNumber, c1);
			return true;
		} else
			return false;
	};

	public boolean viewContact(String phoneNumber) throws ContactNotFoundException {
		if (contacts.containsKey(phoneNumber)) {
			contacts.get(phoneNumber);
			return true;
		} else {
			System.out.println("Contact Does Not Exist");
			throw new ContactNotFoundException("Contact Not Found");
		}
	
	};

}
