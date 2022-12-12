package model.database.loadSaveStrategies;

import model.MetroCard;
import model.database.utilities.TekstLoadSaveTemplate;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class MetrocardsTekstLoadSaveStrategy<K,V> extends TekstLoadSaveTemplate implements LoadSaveStrategy {
    File file = new File("src/bestanden/metrocards.txt");

public MetrocardsTekstLoadSaveStrategy() throws IOException {
        //super();
    }

    public HashMap<K,V> load() throws IOException {
        return super.load(file);
    }


    @Override
    public void save(HashMap map) throws IOException {
        super.save(map);
    }


    @Override
    public MetroCard maakObject(String[] tokens){
        MetroCard metroCard = new MetroCard(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
        return metroCard;
    }

    @Override
    public Integer getKey(String[] tokens){
        return Integer.parseInt(tokens[0]);
    }


}
