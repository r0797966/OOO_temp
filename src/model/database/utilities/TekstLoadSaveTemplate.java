package model.database.utilities;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public abstract class TekstLoadSaveTemplate<K,V>{
    // LOAD
    public HashMap<K,V> load(File file) throws IOException {
        HashMap<K,V> returnMap = new HashMap<K,V>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null && !line.trim().equals("")) {
                String[] tokens = line.split(";");
                V element = maakObject(tokens);
                K key = getKey(tokens);
                returnMap.put(key,element);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return returnMap;
    }

    public void save(HashMap<K,V> map) throws IOException {
        try {
            FileWriter writer = new FileWriter("src/bestanden/metrocards.txt");
            for (Map.Entry<K,V> entry : map.entrySet()) {
                writer.write( entry.getValue() + "\n");

            }
            writer.close();
        } catch (IOException e) {
            System.out.println(">>> File error!!!");
            e.printStackTrace();
        }
    }

        //


    public abstract V maakObject(String[] tokens);

    public abstract K getKey(String[] tokens);

    // SAVE
}
