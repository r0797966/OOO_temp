package model.facade;

import model.MetroCard;
import model.database.MetrocardDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;
import model.observer.Observer;
import model.observer.Subject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MetroFacade implements Subject {
    private MetrocardDatabase metrocardDatabase = new MetrocardDatabase();
    private List<Observer> observers;

    public MetroFacade() {
        observers = new ArrayList<>();
    }

    // OPENMETROSTATION
    public void openMetroStation() {
        try {
            InputStream input = new FileInputStream("src/bestanden/settings.properties");
            Properties properties = new Properties();
            properties.load(input);
            LoadSaveStrategy loadSaveStrategy = LoadSaveStrategyFactory.createLoadSaveStrategy(properties.getProperty("filetype").toUpperCase());
            System.out.println(loadSaveStrategy);

            metrocardDatabase.setLoadSaveStrategy(loadSaveStrategy);
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
    public void getMetroCardIdList() {
        // TODO: implement
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
}
