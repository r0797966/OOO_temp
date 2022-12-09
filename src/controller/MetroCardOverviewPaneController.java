package controller;

import model.observer.Observer;
import model.facade.MetroEventsEnum;
import model.facade.MetroFacade;
import model.observer.Subject;
import view.panels.MetroCardOverviewPane;

public class MetroCardOverviewPaneController implements Observer {
    private MetroCardOverviewPane metroCardOverviewPane;
    private MetroFacade metroFacade = new MetroFacade();

    public MetroCardOverviewPaneController() {
        //metroFacadeSubject.addObserver(this);
    }

    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {
            case OPEN_METROSTATION -> System.out.println("observer called");//getMetroCardList();
        }
    }

    public void getMetroCardList() {
        metroFacade.getMetroCardList();
        // TODO
        System.out.println("implement arraylist?");
        metroCardOverviewPane.updateMetroCardList(null);
    }
}

