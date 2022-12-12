package model.ticketPriceDecorator;

public abstract class TicketPrice {
    private boolean is64Plus;
    private boolean isStudent;
    private boolean isChristmas;
    private boolean isFrequentCustomer;
    private double price;// 50+ verbruikte tickets

    // getIs64Plus(): boolean
    public boolean getIs64Plus() {
        return is64Plus;
    }

    // setIs64Plus(is64Plus: boolean): void
    public void setIs64Plus(boolean is64Plus) {
        this.is64Plus = is64Plus;
    }

    // getIsStudent(): boolean
    public boolean getIsStudent() {
        return isStudent;
    }

    // setIsStudent(isStudent: boolean): void
    public void setIsStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }

    // getIsChristmas(): boolean
    public boolean getIsChristmas() {
        return isChristmas;
    }

    // setIsChristmas(isChristmas: boolean): void
    public void setIsChristmas(boolean isChristmas) {
        this.isChristmas = isChristmas;
    }

    // getIsFrequentCustomer(): boolean
    public boolean getIsFrequentCustomer() {
        return isFrequentCustomer;
    }

    // setIsFrequentCustomer(isFrequentCustomer: boolean): void
    public void setIsFrequentCustomer(boolean isFrequentCustomer) {
        this.isFrequentCustomer = isFrequentCustomer;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // getPrice(): double // abstract
    public abstract double getPrice();

    // getPriceText(): String // abstract
    public abstract String getPriceText();
}
