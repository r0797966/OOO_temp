package model.ticketPriceDecorator.decorators;

import model.ticketPriceDecorator.TicketPrice;

public class Age64PlusDiscount extends TicketPriceDiscountDecorator {

    public Age64PlusDiscount(TicketPrice ticketPrice) {
        super(ticketPrice);
    }

    // getPrice(): double
    @Override
    public double getPrice() {
        return ticketPrice.getPrice() - 0.15;
    }

    // getPriceText(): String
    @Override
    public String getPriceText() {
        return ticketPrice.getPriceText() + " -0.15 Age 64+ Discount";
    }
}
