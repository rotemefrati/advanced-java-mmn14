package main.java.com.maman14.q2;

import java.util.TreeMap;

public class PhoneBookTreeMap {

    private TreeMap<String, String> phoneBook = new TreeMap<String, String>();

    public TreeMap<String, String> getPhoneBook() {
        return phoneBook;
    }

    // add a contact to the phone book
    public void add(String name, String phoneNumber) throws ContactAlreadyExistsException, InvalidPhoneNumberException {
        // check if the contact already exists
        if(phoneBook.containsKey(name)) {
            throw new ContactAlreadyExistsException("The contact \"" + name + "\" already exists.");
        } else if(isNotValid(phoneNumber)) {
            throw new InvalidPhoneNumberException("The phone number you entered has invalid characters.");
        }
        phoneBook.put(name, phoneNumber);
    }

    // remove a contact from the phone book
    public void remove(String contactName) throws ContactDoesNotExistException {
        // check if the contact exists
        if(!phoneBook.containsKey(contactName)) {
            throw new ContactDoesNotExistException("The contact for removal does not exist.");
        }
        phoneBook.remove(contactName);
    }

    // search for a contact in the phone book
    public TreeMap<String, String> search(String contactName) {
        // if the contact exists, return a TreeMap with the contact
        if(phoneBook.containsKey(contactName)) {
            return new TreeMap<String, String>() {{put(contactName, phoneBook.get(contactName));}};
        }
        // if the contact does not exist, return an empty TreeMap
        return new TreeMap<String,String>();
    }

    // update a contact's phone number in the phone book
    public void update(String contactName, String phoneNumber) throws ContactDoesNotExistException, InvalidPhoneNumberException {
        // check if the contact to update exists
        if(!phoneBook.containsKey(contactName)) {
            throw new ContactDoesNotExistException("The contact to update does not exist.");
            // check if the new phone number is valid
        } else if(isNotValid(phoneNumber)) {
            throw new InvalidPhoneNumberException("The new phone number to update has invalid characters.");
        }
        phoneBook.put(contactName, phoneNumber);
    }

    // validate phone number format and length, chars allowed: 0-9, *, #, +
    // assuming phone number length is between 10 and 15
    private boolean isNotValid(String phoneNumber) {
        return !phoneNumber.matches("[0-9#*+]*") ||
                phoneNumber.length() < 10 ||
                phoneNumber.length() > 15;
    }
}