package com.idano;

import com.idano.model.BusinessContact;
import com.idano.model.ContactList;
import com.idano.model.PersonalContact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class MyContacts {
    private ContactList mContactList;
    private Map<Integer,String> mMainMenu;
    private BufferedReader mReader;

    public MyContacts(ContactList contactList){
        mContactList = contactList;
        mMainMenu = new LinkedHashMap<>();
        mReader = new BufferedReader(new InputStreamReader(System.in));

        mMainMenu.put(1,"add personal contact");
        mMainMenu.put(2,"add business contact");
        mMainMenu.put(3,"display contacts");
        mMainMenu.put(4,"quit program");
    }

    public void run(){
        boolean doNotQuit = true;
        int selection = 0;
        do {
	    System.out.println("Welcome to My Contact List!!");
            System.out.println("----------------------------");
            System.out.println("Choose one of the following");

            for (Integer choice: mMainMenu.keySet()){
                System.out.printf("%d) %s%n",choice,mMainMenu.get(choice));
            }

            selection = getNumberInput();

            switch (selection){
                case 1:
                    promptAddPersonalContact();
                    break;
                case 2:
                    promptAddBusinessContact();
                    break;
                case 3:
                    promptDisplayContactsMenu();
                    break;
                case 4:
                    doNotQuit = false;
                    break;
                default:
                    System.out.println("Invalid Entry");
                    run();
                    break;
            }
        }while(doNotQuit);
        System.out.println("Thank you for using My Contact List!");
	System.exit(0);
    }

    private void promptDisplayContactsMenu(){
        if(mContactList.isEmpty()){
            System.out.println("There are no contacts in the list."+
                    "\n Returning to the main menu...");
            run();
        }else {
            int selection = 0;
            System.out.println("Display Contacts Menu" +
                    "\n---------------------");
            System.out.println("Select one to see details:");
            for (Map.Entry<Integer, String> entry : mContactList.getContactNames().entrySet()) {
                System.out.println(entry.getKey() + ") " + entry.getValue());
            }
            System.out.println(mContactList.getContactDetails(getNumberInput()));
            System.out.print("Please Choose:\n" +
                    "--------------\n" +
                    "1)View another contact's details\n" +
                    "2)Back to main menu\n");
            selection = getNumberInput();
            switch (selection) {
                case 1:
                    promptDisplayContactsMenu();
                    break;
                case 2:
                    run();
                    break;
                default:
                    System.out.println("Invalid selection!!");
                    promptDisplayContactsMenu();
                    break;
            }
        }
    }

    private void promptAddPersonalContact(){
        String fName;
        String lName;
        String address;
        String phoneNumber;
        String email;
        String birthday;

        System.out.println("Adding personal contact" +
                "-----------------------");
        System.out.print("First Name:  ");
        fName = getLetterInput();
        System.out.print("Last Name:  ");
        lName = getLetterInput();
        System.out.print("Address:  ");
        address = getLetterInput();
        System.out.print("Phone Number:  ");
        phoneNumber = getLetterInput();
        System.out.print("Email:  ");
        email = getLetterInput();
        System.out.print("Birthday:  ");
        birthday = getLetterInput();
        mContactList.add(new PersonalContact(fName, lName, address, phoneNumber, email, birthday));
        run();
    }

    private void promptAddBusinessContact() {
        String fName;
        String lName;
        String address;
        String phoneNumber;
        String email;
        String jobTitle;
        String organization;

        System.out.println("Adding business contact"+
                           "-----------------------");
        System.out.print("First Name:  ");
        fName = getLetterInput();
        System.out.print("Last Name:  ");
        lName = getLetterInput();
        System.out.print("Address:  ");
        address = getLetterInput();
        System.out.print("Phone Number:  ");
        phoneNumber = getLetterInput();
        System.out.print("Email:  ");
        email = getLetterInput();
        System.out.print("Job Title:  ");
        jobTitle = getLetterInput();
        System.out.print("Organization:  ");
        organization = getLetterInput();
        mContactList.add(new BusinessContact(fName, lName, address, phoneNumber, email, jobTitle, organization));
        run();
    }

    private String getLetterInput(){
        String input = null;
        do{
            try{
                input = mReader.readLine().trim();
            } catch (IOException ioe) {
                    System.out.println("Please try your selection again.");
            }
        }while(input == null);
        return input;
    }

    private int getNumberInput(){
        int input = 0;
        do{
            try{
                input = Integer.parseInt(mReader.readLine().trim());
            } catch (IOException ioe) {
                System.out.println(".");
            } catch (NumberFormatException nfe) {
                System.out.println("Please input a number only.");
            }
        }while(input == 0);
        return input;
    }
}
