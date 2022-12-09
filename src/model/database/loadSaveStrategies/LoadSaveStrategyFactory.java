package model.database.loadSaveStrategies;

public class LoadSaveStrategyFactory {
    // CREATELOADSAVESTRATEGY
    public static LoadSaveStrategy createLoadSaveStrategy(String type) {
        LoadSaveStrategyEnum loadSaveStrategyEnum = LoadSaveStrategyEnum.valueOf(type);
        String klasseNaam = loadSaveStrategyEnum.getKlasseNaam();
        LoadSaveStrategy loadSaveStrategy = null;

        try {
            Class dbClass = Class.forName(klasseNaam);
            Object dbObject = dbClass.newInstance();
            loadSaveStrategy = (LoadSaveStrategy) dbObject;
                    }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return loadSaveStrategy;
    }
}
