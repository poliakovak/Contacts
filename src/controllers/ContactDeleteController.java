package controllers;

import models.ContactDeleteModel;
import utils.AppStarter;
import utils.Constants;
import views.ContactDeleteView;

public class ContactDeleteController {

    ContactDeleteModel model;
    ContactDeleteView view;

    public ContactDeleteController(ContactDeleteModel model, ContactDeleteView view) {
        this.model = model;
        this.view = view;
    }

    public void deleteContact() {

        String str = model.deleteContact(view.doInput());
        if (str.equals(Constants.DB_ABSENT_MSG)) {
            view.getOutput(str);
            System.exit(0);
        } else {
            view.getOutput(str);
            AppStarter.startApp();
        }
    }
}
