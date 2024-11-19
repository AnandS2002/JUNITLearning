package junitlearning;

import junitlearning.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import exceptions.ContactNotFoundException;

class TestContactManagementSystem {
	Contacts c = null;
	ContactManagementSystem cms = new ContactManagementSystem();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddInvalidContact() {
		c = new Contacts("Anand", "jf", "90749471");
		assertFalse(cms.addContact(c));
	}

	@Test
	void testAddInvalidLastName() {
		c = new Contacts("Anand", "", "9074947148");
		assertFalse(cms.addContact(c));
	}

	@Test
	void testAddInvalidFirstName() {
		c = new Contacts("", "jf", "9074947148");
		assertFalse(cms.addContact(c));

	}

	@Test
	void testAddExistingContact() {

		Contacts c1 = new Contacts("Anand", "jf", "9074947148");
		cms.addContact(c1);
		c = new Contacts("Febin", "P", "9074947148");
		assertFalse(cms.addContact(c));
	}

	@Disabled
	@Test
	void testDeleteExistingContact() {
		c = new Contacts("Anand", "jf", "9074947148");
		cms.addContact(c);
		assertTrue(cms.deleteContact("9074947148"));
	}

	@Test
	void testDeleteNonExistingContact() {
		c = new Contacts("Anand", "jf", "9074947148");
		cms.addContact(c);
		assertFalse(cms.deleteContact("9074947149"));
	}

	@Test
	void testDeleteInvalidPhoneNumber() {
		c = new Contacts("Anand", "jf", "9074947148");
		cms.addContact(c);
		assertFalse(cms.deleteContact("907494714"));
	}

	@Test
	void testEditExistingContact() {
		c = new Contacts("Febin", "P", "9656238552");
		cms.addContact(c);
		Contacts c1 = new Contacts("Sudev", "P", "9656238552");
		assertTrue(cms.editContact(c1));

	}

	@Test
	void testEditInvalidContact() {
		c = new Contacts("Febin", "P", "9656238552");
		cms.addContact(c);
		Contacts c1 = new Contacts("Sudev", "P", "96562385");
		assertFalse(cms.editContact(c1));

	}

	@Test
	void testEditNonExistingContact() {
		c = new Contacts("Febin", "P", "9656238552");
		Contacts c1 = new Contacts("Sudev", "P", "96562385");
		cms.addContact(c);
		assertFalse(cms.editContact(c1));
	}

	@Test
	void testViewExistingContact() {
		c = new Contacts("Febin", "P", "9656238552");
		cms.addContact(c);
		try {
			assertTrue(cms.viewContact("9656238552"));
		} catch (ContactNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testViewNonExistingContact() {
		c = new Contacts("Febin", "P", "9656238552");
		cms.addContact(c);
		assertThrows(ContactNotFoundException.class,()->{cms.viewContact("9656238557");});
	}

}
