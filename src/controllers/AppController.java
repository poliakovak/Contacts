package controllers;

import models.AppModel;
import utils.Constants;
import views.AppView;

public class AppController {

    AppModel model;
    AppView view;

    public AppController(AppModel model, AppView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {
        filterChoice(view.doChoice());
    }

    private void filterChoice(int choice) {
        switch (choice) {
            case 1 -> model.createContact();
            case 2 -> model.readContacts();
            case 3 -> model.updateContact();
            case 4 -> model.deleteContact();
            case 0 -> {
                String output = Constants.JOB_QUIT_MSG;
                view.getOutput(output, choice);
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
}
