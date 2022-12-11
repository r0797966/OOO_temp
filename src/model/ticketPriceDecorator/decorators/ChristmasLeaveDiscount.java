package model.ticketPriceDecorator.decorators;

import model.ticketPriceDecorator.TicketPrice;

public class ChristmasLeaveDiscount extends TicketPriceDiscountDecorator {

    public ChristmasLeaveDiscount(TicketPrice ticketPrice) {
        super(ticketPrice);
    }

    // getPrice(): double
    @Override
    public double getPrice() {
        return ticketPrice.getPrice() - 0.10;
    }

    // getPriceText(): String
    @Override
    public String getPriceText() {
        return ticketPrice.getPriceText() + " -0.10 Christmas Leave Discount";
    }
}
