package model.database.loadSaveStrategies;

import model.MetroCard;
import model.database.utilities.ExcelLoadSaveTemplate;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class MetrocardsExcelLoadSaveStrategy<K,V> extends ExcelLoadSaveTemplate implements LoadSaveStrategy{
    File file = new File("src/bestanden/metrocards.xls");


    public MetrocardsExcelLoadSaveStrategy() throws IOException {
        //super();
    }

    @Override
    public HashMap<K,V> load() throws IOException {
        return super.load(file);
    }

    @Override
    public void save(HashMap map) throws IOException {
        super.save(map);

    }

    @Override
    public MetroCard maakObject(String[] tokens) {
        MetroCard metroCard = new MetroCard(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
        return metroCard;
    }

    @Override
    public String getKey(String[] tokens) {
        return tokens[0];
    }
}
