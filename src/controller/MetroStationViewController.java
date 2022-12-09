package controller;

import model.Observer;
import model.facade.MetroEventsEnum;
import model.facade.MetroFacade;
import view.MetroStationView;

public class MetroStationViewController implements Observer {
    public MetroStationView metroStationView;
    private MetroFacade metroFacade = new MetroFacade();

    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {
            case OPEN_METROSTATION -> System.out.println("NOTHING YET");
        }
    }


}
