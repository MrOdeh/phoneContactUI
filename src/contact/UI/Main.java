package contact.UI;

import java.util.Scanner;

public class Main {
    private static MobilePhone mobilePhone = new MobilePhone("334 552 661");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = true;
        startPhone();
        printMenu();
        while (quit) {
            System.out.printf("Choose your action from 0 - 6 :\r");
            if (scanner.hasNextInt()) {
                int action = scanner.nextInt();
                scanner.nextLine();

                switch (action) {
                    case 0:
                        quit = false;
                        System.out.println("Good Bye!.");
                        break;
                    case 1:
                        printContacts();
                        break;
                    case 2:
                        addNewContact();
                        break;
                    case 3:
                        updateNewContact();
                        break;
                    case 4:
                        removeExistingContact();
                        break;
                    case 5:
                        searchForContact();
                        break;
                    case 6:
                        printMenu();
                        break;
                    default:
                        System.out.println("Wrong Input.");
                }
            } else {
                System.out.println("Wrong Input.");
                scanner.nextLine();
            }

        }
    }

    public static void startPhone() {
        System.out.println("Phone Has Been Started.");
    }

    public static void printMenu() {
        System.out.println("\nAvailable Acations:\nPress:");
        System.out.println("\t0 - To Shutdown\n" +
                "\t1 - To Print Contact\n" +
                "\t2 - To add new Contact\n" +
                "\t3 - To Update an existing account\n" +
                "\t4 - To Remove an existing account\n" +
                "\t5 - To Search for an existing account\n" +
                "\t6 - To Print a list of an Available Actions\n"
        );
    }

    private static void printContacts() {
        mobilePhone.mobilePhoneGetContact();
    }

    private static void addNewContact() {
        System.out.println("Please Enter new Name : \r");
        String contactName = scanner.nextLine();
        System.out.println("Please Enter Phone Number : \r");
        String contactPhoneNumber = scanner.nextLine();
        Contact newContact = Contact.creatContact(contactName, contactPhoneNumber);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("Contact has Been Created --> " + "Name : " + contactName +
                    " / " + "Phone Number : " + contactPhoneNumber);
        } else {
            System.out.println("Connot add " + contactName + " is Already Created with Phone Number : "
                    + contactPhoneNumber);
        }
    }

    public static void updateNewContact() {
        System.out.println("Please Enter the Contract Name : ");
        String name = scanner.nextLine();
        if (mobilePhone.contractQueryName(name) == null) {
            System.out.println("Contract Not Found.!");
            return;
        } else {
            System.out.println("Please Enter new Name : \r");
            String contactName = scanner.nextLine();
            System.out.println("Please Enter Phone Number : \r");
            String contactPhoneNumber = scanner.nextLine();
            Contact newContract = Contact.creatContact(contactName, contactPhoneNumber);
            mobilePhone.updateContact(mobilePhone.contractQueryName(name), newContract);

        }
    }

    public static void removeExistingContact() {
        System.out.println("Please Enter the Contract Name : ");
        String name = scanner.nextLine();
        if (mobilePhone.contractQueryName(name) == null) {
            System.out.println("Contract Not Found.!");
            return;
        } else {
            //call Above Method
            Contact existingContract = mobilePhone.contractQueryName(name);
            if (!mobilePhone.removeContact(existingContract)) {
                System.out.println("please Contact Us for the Related Issue");
            }
        }
    }

    public static void searchForContact() {
        System.out.println("Please Enter the Contract Name : ");
        String name = scanner.nextLine();
        if (mobilePhone.contractQueryName(name) == null) {
            System.out.println("Contract Not Found.!");
            return;
        } else {
            //call Above Method
            System.out.println("Contract Exists with Mobile Number : " +
                    mobilePhone.contractQueryName(name).getPhoneNumber());
        }
    }

}

