package controller;

import model.observer.Observer;
import model.facade.MetroEventsEnum;
import model.observer.Subject;

public class SetupPaneController implements Observer {
    //private SetupPane setupPane = new SetupPane();

    public SetupPaneController() {
        //metroFacadeSubject.addObserver(this);
    }

    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {
            default -> System.out.println("nothing yet");
        }
    }
}
