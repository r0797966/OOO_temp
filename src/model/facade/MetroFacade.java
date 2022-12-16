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

    public ArrayList<MetroCard> getMetroCardList() {
        return metrocardDatabase.getMetroCardList();
    }

    public ArrayList<Integer> getMetroCardIdList() {
        return metrocardDatabase.getMetroCardIdList();
    }

    public void newMetrocard() throws IOException {
        metrocardDatabase.newMetrocard();
        notifyObservers(MetroEventsEnum.BUY_METROCARD);
    }

    public TicketPrice addRidesInformation(int id, int rides, boolean isStudent, boolean isSenior) {
        return metrocardDatabase.addRidesInformation(id, rides, isStudent, isSenior);
    }

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
        return metroStation.scanMetroGate(gateid, card, this);
    }

    public String walkThroughGate(int gateid) {
       return metroStation.walkThroughGate(gateid, this);
    }

    public void closeStation(){
        metrocardDatabase.save();
    }

    public void activateGate(int gateid) {
        metroStation.activateGate(gateid);
        notifyObservers(MetroEventsEnum.ACTIVATE_GATE);
    }

    public void deactivateGate(int gateid) {
        metroStation.deactivateGate(gateid);
    }

    public String createAlert() {
        return metroStation.createAlert(1);
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
}
