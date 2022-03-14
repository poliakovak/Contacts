package controllers;

import database.entities.Contact;
import models.ContactAddModel;
import utils.AppStarter;
import utils.Constants;
import views.ContactAddView;

public class ContactAddController {

    ContactAddModel model;
    ContactAddView view;
    Contact contact;

    public ContactAddController(ContactAddModel model, ContactAddView view) {
        this.model = model;
        this.view = view;
    }

    public void addContact() {

        contact = view.doInputs();
        String str = model.addContact(contact);

        if (str.equals(Constants.DB_ABSENT_MSG)) {
            view.getOutput(str);
            System.exit(0);
        } else {
            view.getOutput(str);
            AppStarter.startApp();
        }
    }
}
