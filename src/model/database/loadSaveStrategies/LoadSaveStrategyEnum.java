package model.database.loadSaveStrategies;

public enum LoadSaveStrategyEnum {
    TEKST("Tekst", "model.database.loadSaveStrategies.MetrocardsTekstLoadSaveStrategy"),
    EXCEL("Excel", "model.database.loadSaveStrategies.MetrocardsExcelLoadSaveStrategy");

    private final String omschrijving;
    private final String klasseNaam;

    LoadSaveStrategyEnum(String omschrijving, String klasseNaam) {
        this.omschrijving = omschrijving;
        this.klasseNaam = klasseNaam;
    }

    // GETTERS
    public String getOmschrijving() { return omschrijving; }
    public String getKlasseNaam() { return klasseNaam; }
}
