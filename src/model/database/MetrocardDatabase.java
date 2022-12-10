package model.database;

import model.MetroCard;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;
import model.database.loadSaveStrategies.MetrocardsExcelLoadSaveStrategy;
import model.database.loadSaveStrategies.MetrocardsTekstLoadSaveStrategy;
import model.database.utilities.TekstLoadSaveTemplate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MetrocardDatabase {
    private TreeMap<Integer, MetroCard> metroCards;
    private LoadSaveStrategy loadSaveStrategy;

    // CONSTRUCTOR
    public MetrocardDatabase() {
        metroCards = new TreeMap<Integer, MetroCard>();
        metroCards.put(1, new MetroCard(1, "05#2022", 2, 3));
        metroCards.put(2, new MetroCard(2, "06#2022", 3, 4));
        metroCards.put(3, new MetroCard(3, "06#2022", 4, 5));
    }

    // GETTERS
    public Map<Integer, MetroCard> getMetroCards() {
        return metroCards;
    }

    // METHODS
    public int getAantalMetroCards(){
    	return metroCards.size()-1;
    }

    public void setLoadSaveStrategy(LoadSaveStrategy type) {
        if (type.getClass().getSimpleName().equals("MetrocardsTekstLoadSaveStrategy")) {
             this.loadSaveStrategy = LoadSaveStrategyFactory.createLoadSaveStrategy("TEKST");
        } else {
            this.loadSaveStrategy = LoadSaveStrategyFactory.createLoadSaveStrategy("EXCEL");
        }
    }

    public ArrayList<MetroCard> getMetroCardList() {
        return new ArrayList<>(metroCards.values());
    }

    public ArrayList<Integer> getMetroCardIdList() {
        // TODO: implement
        // return ids from metroCards
        ArrayList<Integer> ids = new ArrayList<>();
        for(Map.Entry<Integer, MetroCard> entry : metroCards.entrySet()) {
            ids.add(entry.getValue().getMetrokaartID());
        }
        return ids;
    }

    // LOAD
    public void load() throws IOException {
        metroCards = loadSaveStrategy.load();
    }

    // SAVE

}
