package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		AddressBook addressBook = new AddressBook();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean condition = true;
		while (condition) {
			System.out.println(
					"\nEnter \n\n 1 To add The contact \n 2 To edit the contact \n 3 To delete the contact \n 4 to exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addressBook.addContact();
				break;
			case 2:
				addressBook.editContact();
				break;
			case 3:
				addressBook.deleteContact();
				break;
			case 4:
				System.out.println("Terminated");
				condition = false;
				break;
			default:
				System.out.println("Enter the wrong input");
				continue;
			}
		}
	}
}
