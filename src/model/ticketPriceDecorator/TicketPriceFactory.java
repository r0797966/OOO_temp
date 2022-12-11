package model.ticketPriceDecorator;

import model.MetroCard;
import model.ticketPriceDecorator.decorators.Age64PlusDiscount;
import model.ticketPriceDecorator.decorators.ChristmasLeaveDiscount;
import model.ticketPriceDecorator.decorators.FrequentTravellerDiscount;
import model.ticketPriceDecorator.decorators.StudentDiscount;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class TicketPriceFactory {
    /*
    Deze klasse leest in het setup bestand welke kortingen tijdens de sessie mogen worden toegepast en bouwt het decorator object op
     */

    // createTicketPrice(is64Min, isStudent, metroCard): TicketPrice
    public static TicketPrice createTicketPrice(boolean is64Min, boolean isStudent, boolean isFrequent, MetroCard metroCard) {
        try {
            InputStream input = new FileInputStream("src/bestanden/settings.properties");
            Properties properties = new Properties();
            properties.load(input);

            ArrayList<String> discounts = new ArrayList<>(Arrays.asList(properties.getProperty("discounts").split(",")));
            System.out.println(discounts);

            TicketPrice ticketPrice = new BasicTicketPrice();
            if(is64Min && discounts.contains("64+")) {
                ticketPrice = new Age64PlusDiscount(ticketPrice);
            }
            if(isStudent && discounts.contains("Student")) {
                ticketPrice = new StudentDiscount(ticketPrice);
            }
            if(isFrequent && discounts.contains("Frequent")) {
                ticketPrice = new FrequentTravellerDiscount(ticketPrice);
            }
            if(discounts.contains("Christmas")) {
                ticketPrice = new ChristmasLeaveDiscount(ticketPrice);
            }
            metroCard.setTicketPrice(ticketPrice);
            return ticketPrice;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
