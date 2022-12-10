package model.database.utilities;

import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.MetroCard;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public abstract class ExcelLoadSaveTemplate<K,V> {
    // LOAD
    public HashMap<K,V> load(File file) throws IOException {
        ExcelPlugin excelPlugin = new ExcelPlugin();
        HashMap<K,V> returnMap;
        ArrayList<ArrayList<String>> data = null;
        try {
            data = excelPlugin.read(file);
        } catch (IOException | BiffException e) {
            System.out.println(e.getMessage());
        }

        returnMap = new HashMap<K,V>();

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
    public void save(HashMap<K,V> map) throws IOException {
        // turn the hashmap into an arraylist
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        for (Map.Entry<K,V> entry : map.entrySet()) {
            ArrayList<String> row = new ArrayList<String>();
            String value = entry.getValue().toString();
            // split the string into tokens
            String[] tokens = value.split(";");
            for (String token : tokens) {
                row.add(token);
            }
            data.add(row);
            System.out.println(data);
        }
        System.out.println(data);

        ExcelPlugin excelPlugin = new ExcelPlugin();
        try {
            excelPlugin.write(new File("src/bestanden/metrocards.xls"), data);
        } catch (BiffException | WriteException e) {
            throw new RuntimeException(e);

        }
    }

    public abstract V maakObject(String[] tokens);

    public abstract K getKey(String[] tokens);

    // SAVE
}
