package controller;

import model.Observer;
import model.facade.MetroEventsEnum;
import view.panels.SetupPane;

public class SetupPaneController implements Observer {
    //private SetupPane setupPane = new SetupPane();

    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {
            default -> System.out.println("nothing yet");
        }
    }
}
