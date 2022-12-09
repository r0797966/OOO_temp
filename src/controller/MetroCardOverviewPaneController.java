package controller;

import model.Observer;
import model.Subject;
import model.facade.MetroEventsEnum;
import model.facade.MetroFacade;
import view.panels.MetroCardOverviewPane;

public class MetroCardOverviewPaneController implements Observer {
    private MetroCardOverviewPane metroCardOverviewPane;
    private MetroFacade metroFacade = new MetroFacade();

    public MetroCardOverviewPaneController() {

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

