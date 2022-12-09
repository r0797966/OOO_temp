package controller;

import model.facade.MetroFacade;
import model.observer.Observer;
import model.facade.MetroEventsEnum;
import model.observer.Subject;
import view.panels.SetupPane;

public class SetupPaneController implements Observer {
    private SetupPane setupPane;
    private MetroFacade metroFacade;

    public SetupPaneController(MetroFacade metroFacade) {
        this.metroFacade = metroFacade;
        this.metroFacade.addObserver(this);
    }

    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {
            default -> System.out.println("nothing yet");
        }
    }
}
