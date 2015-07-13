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
public class Movie extends Product{
    private int upc;

    /**
     * Initialized Constructor for Movie
     * @param sku: int, a unique identifier
     * @param qty: int, how many copies of Movie are in stock
     * @param price: double, how much Movie costs in dollars & cents
     * @param title: String, the name of Movie
     * @param upc: int, a Universal Product Code
    */
    public Movie(int sku, int qty, double price, String title, int upc) {
        this.sku = sku;
        this.qty = qty;
        this.price = price;
        this.title = title;
        this.upc = upc;
    }

    /**
     *
     * @return
     */
    public String labeledString(){
        DecimalFormat money = new DecimalFormat("$0.00");
        return "sku=" +sku+ "\nquantity=" +qty+ "\nprice=" +money.format(price)
                + "\ntitle=" +title+ "\nUPC=" +upc;
    }

    public String toString(){
        DecimalFormat money = new DecimalFormat("$0.00");
        return String.format("%5s %5d %8s %-20s", sku, qty, money.format
                (price), title, upc);
    }
    /**
     * Prompts user for a new movie's SKU, quantity available, price,
     * and title. A movie with a SKU matching a movie already in Inventory
     * will not be added.
     * @return: returns a Movie with all necessary information for addition
     * to Inventory

    public Movie newMovie(int sku, int qty, double price, String title, int
            upc) {
        return new Movie(sku, qty, price, title, upc);
    }*/

}
