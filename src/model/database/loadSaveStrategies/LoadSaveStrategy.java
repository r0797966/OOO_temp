package model.database.loadSaveStrategies;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public interface LoadSaveStrategy<K,V> {
    // LOAD
    TreeMap<K,V> load() throws IOException;

    // SAVE

}
