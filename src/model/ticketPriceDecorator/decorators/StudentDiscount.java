package model.ticketPriceDecorator.decorators;

import model.ticketPriceDecorator.TicketPrice;

public class StudentDiscount extends TicketPriceDiscountDecorator {

    public StudentDiscount(TicketPrice ticketPrice) {
        super(ticketPrice);
    }

    // getPrice(): double
    @Override
    public double getPrice() {
        return ticketPrice.getPrice() - 0.25;
    }

    // getPriceText(): String
    @Override
    public String getPriceText() {
        return ticketPrice.getPriceText() + " -0.25 Student Discount";
    }
}
