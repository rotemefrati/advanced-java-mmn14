package main.java.com.maman14.q2;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Map;

public class PhoneBookController {

    @FXML
    private TextField addName;
    @FXML
    private TextField addNumber;
    @FXML
    private TableView<Map.Entry<String, String>> contactsTable;
    @FXML
    private TableColumn<Map.Entry<String, String>, String> nameCol;
    @FXML
    private TableColumn<Map.Entry<String, String>, String> numberCol;
    @FXML
    private TextField removeName;
    @FXML
    private TextField searchName;
    @FXML
    private TextField updateName;
    @FXML
    private TextField updateNumber;

    private PhoneBookTreeMap phoneBook;
    private Alert error;

    // initialize method called when the controller is loaded
    public void initialize() {
        phoneBook = new PhoneBookTreeMap();
        // create an Alert for displaying errors
        error = new Alert(Alert.AlertType.ERROR);
        // set a placeholder for the contacts table when no contacts are available
        contactsTable.setPlaceholder(new Label("No contacts to show"));
        // Set cell value factories for the name and number columns
        nameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKey()));
        numberCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValue()));
    }

    // handle the "Add Contact" button click event
    @FXML
    void addContact(ActionEvent event) {
        try {
            phoneBook.add(addName.getText(), addNumber.getText());
        } catch(ContactAlreadyExistsException | InvalidPhoneNumberException e) {
            error.setContentText(e.getMessage());
            error.show();
        }
        // update and display the contacts in the TableView
        showContactsTable();
        // clear the input fields after adding a contact
        addName.setText("");
        addNumber.setText("");
    }

    // handle the "Clear Name" button click event
    @FXML
    void clearName(ActionEvent event) {
        // clear the search name field
        searchName.setText("");
        showContactsTable();
    }

    // handle the "Remove Contact" button click event
    @FXML
    void removeContact(ActionEvent event) {
        try {
            phoneBook.remove(removeName.getText());
        } catch(ContactDoesNotExistException e) {
            error.setContentText(e.getMessage());
            error.show();
        }
        showContactsTable();
        // clear the input field after removing a contact
        removeName.setText("");
    }

    // handle the "Search Name" button click event
    @FXML
    void searchName(ActionEvent event) {
        // clear existing items and add search results to the contacts table
        contactsTable.getItems().clear();
        contactsTable.getItems().addAll(phoneBook.search(searchName.getText()).entrySet());
    }

    // handle the "Update Contact" button click event
    @FXML
    void updateContact(ActionEvent event) {
        try {
            phoneBook.update(updateName.getText(), updateNumber.getText());
        } catch(ContactDoesNotExistException | InvalidPhoneNumberException e) {
            error.setContentText(e.getMessage());
            error.show();
        }
        showContactsTable();
        // clear the input fields after updating a contact
        updateName.setText("");
        updateNumber.setText("");
    }

    // update the TableView with the current contacts in the phone book
    private void showContactsTable() {
        contactsTable.getItems().clear();
        contactsTable.getItems().addAll(phoneBook.getPhoneBook().entrySet());
    }
}