package controllers;

import models.ContactUpdateModel;
import utils.AppStarter;
import utils.Constants;
import views.ContactUpdateView;

public class ContactUpdateController {

    ContactUpdateModel model;
    ContactUpdateView view;

    public ContactUpdateController(ContactUpdateModel model, ContactUpdateView view) {
        this.model = model;
        this.view = view;
    }

    public void updateContact() {

        String str = model.updateContact(view.doInputs());
        if (str.equals(Constants.DB_ABSENT_MSG)) {
            view.getOutput(str);
            System.exit(0);
        } else {
            view.getOutput(str);
            AppStarter.startApp();
        }
    }
}
