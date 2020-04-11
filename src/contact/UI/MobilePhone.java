package contact.UI;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> ContectArray;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.ContectArray = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (isConactExist(contact.getName()) >= 0) {
            System.out.println("contact already exists.");
            return false;
        }
        this.ContectArray.add(contact);
        return true;
    }

    public Contact contractQueryName(String contractName) {
        int contractPosition = isConactExist(contractName);
        if (isConactExist(contractName) < 0) {
            return null;
        }
        return this.getContectArray().get(contractPosition);
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = isConactExist(oldContact);
        if (foundPosition < 0) {
            System.out.println("Contact Not Found# " + oldContact.getName());
            return false;
        } else if (isConactExist(newContact.getName()) != -1) {
            System.out.println(newContact.getName() + " already exists!.");
            return false;
        }
        this.ContectArray.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + "# old contact Updated with # " + newContact.getName());
        return true;
    }

    public int isConactExist(Contact contact) {
        return this.ContectArray.indexOf(contact);
    }

    public int isConactExist(String contactName) {
        for (int i = 0; i < this.ContectArray.size(); i++) {
            if (this.ContectArray.get(i).getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact) {
        if (isConactExist(contact) < 0) {
            System.out.println("Contact Not Found# " + contact.getName());
            return null;
        }
        return contact.getName();
    }

    public boolean removeContact(Contact contact) {
        int contactPosition = isConactExist(contact);
        if (isConactExist(contact) < 0) {
            System.out.println("Contact Not Found# " + contact.getName());
            return false;
        }
        this.ContectArray.remove(contactPosition);
        System.out.println("Contact was deleted# " + contact.getName());
        return true;
    }

    private ArrayList<Contact> getContectArray() {
        return ContectArray;
    }

    private boolean isContactListNotEmpty() {
        if (getContectArray().size() <= 0) {
            return false;
        }
        return true;
    }

    public void mobilePhoneGetContact() {
        if (isContactListNotEmpty()) {
            for (int i = 0; i < getContectArray().size(); i++) {
                System.out.println((i + 1) + "." + "Contact :" + getContectArray().get(i).getName()
                        + " ---> " + getContectArray().get(i).getPhoneNumber());
            }
        } else {
            System.out.println("There's no Available Data to be Viewed.");
        }
    }
}
