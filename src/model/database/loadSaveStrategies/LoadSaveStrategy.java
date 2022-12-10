package model.database.loadSaveStrategies;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public interface LoadSaveStrategy<K,V> {
    // LOAD
    HashMap<K,V> load() throws IOException;

    void save(HashMap<K,V> map) throws IOException;

    // SAVE

}
