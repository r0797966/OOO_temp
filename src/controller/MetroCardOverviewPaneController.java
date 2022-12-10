package controller;

import model.observer.Observer;
import model.facade.MetroEventsEnum;
import model.facade.MetroFacade;
import view.panels.MetroCardOverviewPane;

public class MetroCardOverviewPaneController implements Observer {
    private final MetroFacade model;
    private MetroCardOverviewPane view;

    public MetroCardOverviewPaneController(MetroFacade model) {
        this.model = model;
        this.model.addObserver(this);
    }

    public void setView(MetroCardOverviewPane metroCardOverviewView) {
        this.view = metroCardOverviewView;
    }

    public void getMetroCardList() {
        model.getMetroCardList();
        // TODO
        System.out.println("implement arraylist?");
        view.updateMetroCardList(null);
    }

    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {
            case OPEN_METROSTATION -> System.out.println("observer called");//getMetroCardList();
        }
    }
}

