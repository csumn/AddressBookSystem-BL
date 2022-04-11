package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultipleAddressBook {
	Map<String, AddressBook> addressBookMap = new HashMap<String, AddressBook>();

	public void addAddressBook() {
		System.out.println("Enter Name of new Address Book: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) {
			System.out.println("Address book with this name already exists, Enter new name!");
			addAddressBook();
		} else {
			AddressBook addressBook = new AddressBook();
			addressBookMap.put(bookName, addressBook);
			System.out.println("press 1 if you want to add another book or press any key to exit");
			int newBook = scanner.nextInt();
			if (newBook == 1) {
				addAddressBook();
			}
		}
	}

	public void addContact() {
		System.out.println("Enter the name of Address book to add the contact.");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String newContact = scanner.nextLine();
		AddressBook addressBook = addressBookMap.get(newContact);
		if (addressBook == null) {
			System.out.println("No book found");

		} else {
			addressBookMap.get(newContact).addContact();
		}
	}

	public void editContactInBook() {
		System.out.println("Enter Name of Address Book you want to edit: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String editBookName = scanner.next();
		if (addressBookMap.containsKey(editBookName)) {
			addressBookMap.get(editBookName).editContact();
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name");
			editContactInBook();
		}
	}

	public void deleteAddressBook() {
		System.out.println("Enter Name of Address Book you want to delete: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) {
			addressBookMap.remove(bookName);
			System.out.println("Address Book deleted sucessfully");
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name");
			deleteAddressBook();
		}
	}

	public void deleteContactInBook() {
		System.out.println("Enter Name of Address Book you want to delete the contacts in it: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) {
			addressBookMap.get(bookName).deleteContact();
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name");
			deleteContactInBook();
		}
	}

	public void printBook() {
		System.out.println("These are AddressBooks in program.");
		for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
			System.out.println(entry.getKey() + "[]");
		}
	}

	public void printContactsInBook() {
		for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are...");
			System.out.println(entry.getValue().contactDetailsList);
		}
		System.out.println(" ");
	}

}
