package controller;

import model.observer.Observer;
import model.facade.MetroEventsEnum;

public class SetupPaneController implements Observer {
    //private SetupPane setupPane = new SetupPane();

    public SetupPaneController() {
        //setupPane.setController(this);
    }

    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {
            default -> System.out.println("nothing yet");
        }
    }
}
