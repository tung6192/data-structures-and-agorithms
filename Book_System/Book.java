package Assignment.Book_System;

/**
 * Created by dinhtungtp on 3/2/2017.
 */
public class Book
{
    private String bcode, title;
    private int quantity, lended;
    private double price, value;
    Book nextNode;

    public Book(String bcode, String title, int quantity, int lended, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
        this.value = this.price * this.quantity;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setLended(int lended) {
        this.lended = lended;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNextNode(Book nextNode) {
        this.nextNode = nextNode;
    }

    public String getBcode() {
        return bcode;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getLended() {
        return lended;
    }

    public double getPrice() {
        return price;
    }

    public double getValue() {
        return value;
    }

    public Book getNextNode() {
        return nextNode;
    }

    @Override
    public String toString(){
        String result;
        result = this.getBcode()+ " | " + this.getTitle() + " | " + this.getQuantity() + " | "
                + this.getLended() + " | " + this.getPrice() + " | " + this.getValue();
        return result;
    }
}
