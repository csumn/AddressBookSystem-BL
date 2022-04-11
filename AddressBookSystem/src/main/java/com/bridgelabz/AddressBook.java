package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	List<ContactDetails> contactDetailsList = new ArrayList<ContactDetails>();
	Scanner scanner = new Scanner(System.in);

	public void addContact() {
		ContactDetails contactDetails = new ContactDetails();
		System.out.println("Enter the number of contacts you want to enter");
		int number = scanner.nextInt();
		for (int i = 1; i <= number; i++) {
			System.out.println("\nFor contact "+i+" Enter the first name of person to check if there are any such names");			
			String name = scanner.next();
			contactDetails.setFirstName(name);
			if (!isPersonExist(contactDetails.getFirstName())){
				System.out.println("\nPerfect ! No contacts with that name, you can enter the details now...\n ");
				writeContact();
			}else {
				System.out.println("oooops!  The entered contact already exist!");
				System.out.println("redirecting to main menu");
			}
		}
	}

	private boolean isPersonExist(String name){
		return contactDetailsList.stream().anyMatch(contact -> contact.getFirstName().equals(name) || contact.getLastName().equals(name));
	}

	public void writeContact() {
		ContactDetails person = new ContactDetails();
		System.out.println("Enter First Name : ");
		String firstName = scanner.next();
		System.out.println("Enter Last Name : ");
		String lastName = scanner.next();
		System.out.println("Enter Address : ");
		String address = scanner.next();
		System.out.println("Enter City : ");
		String city = scanner.next();
		System.out.println("Enter State : ");
		String state = scanner.next();
		System.out.println("Enter ZipCode : ");
		int zipCode = scanner.nextInt();
		System.out.println("Enter Mobile Number : ");
		long mobileNumber = scanner.nextLong();
		System.out.println("Enter EmailId : ");
		String emailId = scanner.next();
		person = new ContactDetails(firstName, lastName, address, city, state, zipCode, mobileNumber, emailId);
		contactDetailsList.add(person);
		System.out.println("Details Updated!");
	}

	public void editContact() {
		System.out.println("Enter the first name of person to edit the contact");
		String editName = scanner.next();
		boolean edited = false;
		for (int i = 0; i < contactDetailsList.size(); i++) {
			String name = contactDetailsList.get(i).getFirstName();
			if (name.equalsIgnoreCase(editName)) {
				writeContact();
				edited = true;
				break;
			}
		}
		if (!edited) {
			System.out.println("Such contact doesn't Exist!");
		}
	}

	public void deleteContact() {
		System.out.println("Enter the first name of person to delete the contact");
		String deleteName = scanner.next();
		int i = 0;
		for (; i < contactDetailsList.size(); i++) {
			String name = contactDetailsList.get(i).getFirstName();
			if (name.equalsIgnoreCase(deleteName)) {
				break;
			}
		}
		if (i < contactDetailsList.size()) {
			contactDetailsList.remove(i);
			System.out.println("Contact Deleted sucsessfully");
		} else {
			System.out.println("Contact not found");
		}
	}
}

