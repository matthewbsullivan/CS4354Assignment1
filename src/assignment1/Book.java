/**
 * Created by Matt Sullivan & Luis Rocha on 7/7/2015.
 */
package assignment1;
import java.text.*;

/**
 * Implements a class of items that describe a movie. A movie
 * has a unique SKU, a quantity available, a price, and a title.
 * Movies can be added and removed from Inventory, displayed, and
 * located via their SKU.
 */
public class Book extends Product{
    private int isbn;


    /**
     * Initialized Constructor for Movie
     * @param sku: int, a unique identifier
     * @param qty: int, how many copies of Movie are in stock
     * @param price: double, how much Movie costs in dollars & cents
     * @param title: String, the name of Movie
     * @param upc: int, a Universal Product Code
     */
    public Book(int sku, int qty, double price, String title, int isbn) {
        this.sku = sku;
        this.qty = qty;
        this.price = price;
        this.title = title;
        this.isbn  = isbn;
    }

    /**
     *
     * @return
     */
    //probably end up moving this .
    public String labeledString(){
        DecimalFormat money = new DecimalFormat("$0.00");
        return "sku=" +sku+ "\nquantity=" +qty+ "\nprice=" +money.format(price)
                + "\ntitle=" +title+ "\nISBN=" +isbn;
    }

    public String toString(){
        DecimalFormat money = new DecimalFormat("$0.00");
        return String.format("%5s %5d %8s %-20s", sku, qty, money.format
                (price), title, isbn);
    }
}
