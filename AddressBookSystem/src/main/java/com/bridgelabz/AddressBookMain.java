package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {

	void choose() {
		MultipleAddressBook multipleAddressBook = new MultipleAddressBook();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean condition = true;
		while (condition) {
			System.out.println("Enter\n \n 1. To add a new AddressBook\n 2. To add contact in the AddressBook\n "
					+ "3. To edit the contact in the AddressBook\n 4. To delete the contact in the AddressBook\n 5. To delete the AddressBook\n "
					+ "6. To Print the AddressBook\n 7. To Print the contacts in the AddressBook\n 0. to exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				multipleAddressBook.addAddressBook();
				break;
			case 2:
				multipleAddressBook.addContact();
				break;
			case 3:
				multipleAddressBook.editContactInBook();
				break;
			case 4:
				multipleAddressBook.deleteContactInBook();
				break;
			case 5:
				multipleAddressBook.deleteAddressBook();
				break;
			case 6:
				multipleAddressBook.printBook();
				break;
			case 7:
				multipleAddressBook.printContactsInBook();
				break;
			case 0:
				System.out.println("Program got terminated !");
				condition = false;
				break;
			default:
				System.out.println("Kindly Enter a Valid input......");
			}
		}
	}
	public static void main(String[] args) {
		AddressBookMain addressBookMain = new AddressBookMain();
		addressBookMain.choose();
	}
}
