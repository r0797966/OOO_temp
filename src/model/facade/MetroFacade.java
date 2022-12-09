package model.facade;

import model.observer.Observer;
import model.observer.Subject;
import model.database.MetrocardDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static model.facade.MetroEventsEnum.OPEN_METROSTATION;

public class MetroFacade implements Subject {
    private MetrocardDatabase metrocardDatabase = new MetrocardDatabase();
    private List<Observer> observers = new ArrayList<Observer>();

    public MetroFacade() {
    }

    // OPENMETROSTATION
    public void openMetroStation() {
        try {
            // createLoadSaveStrategy in LoadSaveStrategyFactory
            InputStream input = new FileInputStream("src/bestanden/settings.properties");
            Properties properties = new Properties();
            properties.load(input);
            LoadSaveStrategy loadSaveStrategy = LoadSaveStrategyFactory.createLoadSaveStrategy(properties.getProperty("filetype").toUpperCase());

            // setLoadSaveStrategy in MetrocardDatabase
            // load in MetrocardDatabase
            metrocardDatabase.setLoadSaveStrategy(loadSaveStrategy);
            metrocardDatabase.load();

            System.out.println("notify observers");
            System.out.println(observers);
            notifyObservers(OPEN_METROSTATION);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //GETMETROCARDLIST: ARRAYLIST<METROCARD>
    public void getMetroCardList() {
        metrocardDatabase.getMetroCardList();
    }

    // GETMETROCARDIDLIST: ARRAYLIST<INTEGER>
    public void getMetroCardIdList() {
        metrocardDatabase.getMetroCardIdList();
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
        observers.forEach(o -> o.update(event));
    }

    // GET OBSERVERS
    public List<Observer> getObservers() {
        return observers;
    }
}
