package model.ticketPriceDecorator;

public class BasicTicketPrice extends TicketPrice {

    // getPrice(): double
    public double getPrice() {
        return 2.10;
    }

    // getPriceText(): String
    public String getPriceText() {
        return "the basic price of a ride is " + getPrice() + " € ";
    }
}
