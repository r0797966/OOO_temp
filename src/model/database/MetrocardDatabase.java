package model.database;

import model.MetroCard;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;
import model.database.loadSaveStrategies.MetrocardsExcelLoadSaveStrategy;
import model.database.loadSaveStrategies.MetrocardsTekstLoadSaveStrategy;
import model.database.utilities.TekstLoadSaveTemplate;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MetrocardDatabase {
    private HashMap<Integer, MetroCard> metroCards;
    private LoadSaveStrategy loadSaveStrategy;

    // CONSTRUCTOR
    public MetrocardDatabase() {
        metroCards = new HashMap<Integer, MetroCard>();
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
    	return metroCards.size();
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

    public void newMetrocard() {
        int id = getAantalMetroCards() + 1;
        LocalDate date = LocalDate.now();
        String month = String.valueOf(date.getMonthValue());
        String year = String.valueOf(date.getYear());
        String datum = month + "#" + year;
        // 2 gratis tickets
        MetroCard newCard = new MetroCard(id, datum, 2, 0);
        metroCards.put(id, newCard);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // LOAD
    public void load() throws IOException {
        metroCards = loadSaveStrategy.load();
    }

    public void save() throws IOException {
        loadSaveStrategy.save(metroCards);
    }

    // SAVE

}
