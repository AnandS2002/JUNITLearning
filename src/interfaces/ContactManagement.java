package interfaces;

import exceptions.ContactNotFoundException;
import junitlearning.ContactManagementSystem;
import junitlearning.Contacts;

public interface ContactManagement {
	public boolean addContact(Contacts c);

	public boolean deleteContact(String phoneNumber);

	public boolean editContact(Contacts c);

	public boolean viewContact(String phoneNumber)throws ContactNotFoundException;

}
