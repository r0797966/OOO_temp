package model.ticketPriceDecorator;

public enum TicketPriceDiscountEnum {
    AGE64PLUSDISCOUNT("64+"),
    STUDENTDISCOUNT("Student"),
    CHRISTMASDISCOUNT("Christmas"),
    FREQUENTCUSTOMERDISCOUNT("Frequent");

    private final String omschrijving;

    TicketPriceDiscountEnum(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getOmschrijving() { return omschrijving; }
}
