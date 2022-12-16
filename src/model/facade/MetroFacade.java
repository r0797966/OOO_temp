package model.facade;

import model.MetroCard;
import model.MetroStation;
import model.database.MetrocardDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;
import model.observer.Observer;
import model.observer.Subject;
import model.ticketPriceDecorator.TicketPrice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MetroFacade implements Subject {
    private MetrocardDatabase metrocardDatabase = new MetrocardDatabase();
    private List<Observer> observers;
    private MetroStation metroStation = new MetroStation();



    public MetroFacade() {
        observers = new ArrayList<>();
    }

    // OPENMETROSTATION
    public void openMetroStation() {
        try {
            InputStream input = new FileInputStream("src/bestanden/settings.properties");
            Properties properties = new Properties();
            properties.load(input);

            metrocardDatabase.setLoadSaveStrategy(LoadSaveStrategyFactory.createLoadSaveStrategy(properties.getProperty("filetype").toUpperCase()));
            metrocardDatabase.load();

            notifyObservers(MetroEventsEnum.OPEN_METROSTATION);
            input.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void reloadMetroStation() {
        try {
            metrocardDatabase.load();
            notifyObservers(MetroEventsEnum.OPEN_METROSTATION);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //GETMETROCARDLIST: ARRAYLIST<METROCARD>
    public ArrayList<MetroCard> getMetroCardList() {
        return metrocardDatabase.getMetroCardList();
    }

    // GETMETROCARDIDLIST: ARRAYLIST<INTEGER>
    public ArrayList<Integer> getMetroCardIdList() {
        return metrocardDatabase.getMetroCardIdList();
    }

    // NEWCARD
    public void newMetrocard() throws IOException {
        metrocardDatabase.newMetrocard();
        notifyObservers(MetroEventsEnum.BUY_METROCARD);
    }

    // ADDRIDESINFORMATION
    public TicketPrice addRidesInformation(int id, int rides, boolean isStudent, boolean isSenior) {
        return metrocardDatabase.addRidesInformation(id, rides, isStudent, isSenior);
    }

    // ADDRIDES
    public void addRides(int id, int rides, double price) {
        metrocardDatabase.addRides(id, rides, price);
        notifyObservers(MetroEventsEnum.BUY_TICKETS);
    }

    public int getTicketCount(){
        return metrocardDatabase.getTicketCount();
    }

    public double getPriceCount(){
        return metrocardDatabase.getPriceCount();
    }

    public String scanMetroGate(int metroCardid, int gateid) {

        MetroCard card = metrocardDatabase.scanMetroGate(metroCardid);
        if (!card.isNotValidCard()) {

            metroStation.increaseNumberOfScannedCards(gateid);
            card.scannedMetroGate();
            notifyObservers(MetroEventsEnum.SCAN_METROGATE);
            return metroStation.scanMetroGate(gateid);
        } else {

           return metroStation.createAlert(gateid);
        }
    }

    public String walkThroughGate(int gateid) {
        notifyObservers(MetroEventsEnum.WALKTHROUGH_GATE);
       return metroStation.walkThroughGate(gateid);
    }



    public void closeStation(){
        metrocardDatabase.save();
    }

    // SUBJECT
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(MetroEventsEnum event) {
        observers.forEach(o -> {
            try {
                o.update(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    public void activateGate(int gateid) {
        metroStation.activateGate(gateid);
        notifyObservers(MetroEventsEnum.ACTIVATE_GATE);
    }

    public void deactivateGate(int gateid) {
        metroStation.deactivateGate(gateid);
        notifyObservers(MetroEventsEnum.ACTIVATE_GATE);
    }
}
