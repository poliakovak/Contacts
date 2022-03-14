package views;

import database.entities.Contact;
import models.ContactDeleteModel;
import utils.Validator;

import java.util.Scanner;

public class ContactDeleteView {

    ContactDeleteModel model;

    public ContactDeleteView(ContactDeleteModel model) {
        this.model = model;
    }

    public Contact doInput() {

        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();

        String title = "Введите ID контакта: ";
        System.out.print(title);
        contact.setId(Validator.validateIdInput(scanner));

        return contact;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
