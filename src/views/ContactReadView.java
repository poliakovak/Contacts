package views;

import models.ContactReadModel;

public class ContactReadView {

    ContactReadModel model;

    public ContactReadView(ContactReadModel model) {
        this.model = model;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
