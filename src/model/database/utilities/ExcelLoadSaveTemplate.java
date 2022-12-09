package model.database.utilities;

import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import model.MetroCard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class ExcelLoadSaveTemplate<K,V> {
    // LOAD
    public TreeMap<K,V> load(File file) throws IOException {
        ExcelPlugin excelPlugin = new ExcelPlugin();
        TreeMap<K,V> returnMap;
        ArrayList<ArrayList<String>> data = null;
        try {
            data = excelPlugin.read(file);
        } catch (IOException | BiffException e) {
            System.out.println(e.getMessage());
        }

        returnMap = new TreeMap<K,V>();

        for(ArrayList<String> row: data) {
            String[] tokens = new String[row.size()];
            for (int i = 0; i < row.size(); i++) {
                tokens[i] = row.get(i);
            }
            V element = maakObject(tokens);
            K key = getKey(tokens);
            returnMap.put(key, element);
        }
        return returnMap;
    }

    public abstract V maakObject(String[] tokens);

    public abstract K getKey(String[] tokens);

    // SAVE
}
