package model;

import model.ticketPriceDecorator.TicketPrice;

import java.time.LocalDate;

public class MetroCard {
    private int metrokaartID;
    private String datum;
    private int beschikbareTickets;
    private int verbruikteTickets;
    private TicketPrice ticketPrice;

    // CONSTRUCTOR
    public MetroCard(int id, String datum, int beschikbaar, int verbruikt) {
        setMetrokaartID(id);
        setDatum(datum);
        setBeschikbareTickets(beschikbaar);
        setVerbruikeTickets(verbruikt);
    }

    // GETTERS
    public int getMetrokaartID() {
        return metrokaartID;
    }

    public String getDatum() {
        return datum;
    }

    public int getBeschikbareTickets() {
        return beschikbareTickets;
    }

    public int getVerbruikeTickets() {
        return verbruikteTickets;
    }

    // SETTERS
    public void setMetrokaartID(int metrokaartID) {
        if(metrokaartID <= 0) {
            throw new IllegalArgumentException("MetrokaarID moet groter zijn dan 0");
        }
        this.metrokaartID = metrokaartID;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setBeschikbareTickets(int beschikbareTickets) {
        if(beschikbareTickets < 0) {
            throw new IllegalArgumentException("Beschikbare tickets moet groter of gelijk zijn dan 0");
        }
        this.beschikbareTickets = beschikbareTickets;
    }

    public void setVerbruikeTickets(int verbruikteTickets) {
        if(verbruikteTickets < 0) {
            throw new IllegalArgumentException("Verbruike tickets moet groter of gelijk zijn dan 0");
        }
        this.verbruikteTickets = verbruikteTickets;
    }

    public TicketPrice getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(TicketPrice ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    // METHODS
    @Override
    public String toString(){
        return  getMetrokaartID() + ";" + getDatum() + ";" + getBeschikbareTickets() + ";" + getVerbruikeTickets();
    }

    public void scannedMetroGate() {
        setBeschikbareTickets(getBeschikbareTickets() - 1);
        setVerbruikeTickets(getVerbruikeTickets() + 1);
    }

    public boolean isValidCard() {
        int month = Integer.parseInt(datum.split("#")[0]);
        int year = Integer.parseInt(datum.split("#")[1]);
        LocalDate date = LocalDate.of(year, month, 1);
        // date is 1 year before now
        return getBeschikbareTickets() == 0 || date.isBefore(LocalDate.now().minusYears(1));
    }



}
