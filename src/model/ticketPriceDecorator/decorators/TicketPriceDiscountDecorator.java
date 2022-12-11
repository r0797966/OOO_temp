package model.ticketPriceDecorator.decorators;

import model.ticketPriceDecorator.TicketPrice;

public abstract class TicketPriceDiscountDecorator extends TicketPrice {
    TicketPrice ticketPrice;

    public TicketPriceDiscountDecorator(TicketPrice ticketPrice) {
        this.ticketPrice = ticketPrice;
    }


}
