package assignment1;
import java.text.*;

/**
 * @author Matt Sullivan
 * @author Luis Rocha
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
    void setUpcIsbnWeight(){};
    void getSpecial(){};

    /**
     *
     * @return
     */
    public String toStringLabel(){
        return String.format("%-7s %-7s %-7s %-7s %-7s %s", "", "SKU",
                "QTY","Price", "UPC", "Title");
    }

    /**
     *
     * @return
     */
    public String toString(){
        DecimalFormat money = new DecimalFormat("$0.00");
        return String.format("%-7s %-7s %-7s %-7s %-7s %s", "Movie: ",
        this.sku, this.qty, money.format(this.price),this.upc, this.title);
    }
}
