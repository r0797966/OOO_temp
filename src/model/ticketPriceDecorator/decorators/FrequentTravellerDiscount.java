package model.ticketPriceDecorator.decorators;

import model.ticketPriceDecorator.TicketPrice;

public class FrequentTravellerDiscount extends TicketPriceDiscountDecorator {

    public FrequentTravellerDiscount(TicketPrice ticketPrice) {
        super(ticketPrice);
    }

    // getPrice(): double
    @Override
    public double getPrice() {
        return ticketPrice.getPrice() - 0.20;
    }

    // getPriceText(): String
    @Override
    public String getPriceText() {
        return ticketPrice.getPriceText() + " -0.20 Frequent Traveller Discount";
    }

}
