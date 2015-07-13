package assignment1;

import java.io.Serializable;

/**
 * @author Matt Sullivan
 * @author Luis Rocha
 */
abstract class Product implements Serializable {
    int sku, qty;
    double price;
    String title;

    /**
     * Gets the SKU for a given Movie
     * @return: returns a Movie SKU
     */
    public int getSku () {
        return this.sku;
    }

    abstract public String labeledString();

    abstract public String toString();/*{
        DecimalFormat money = new DecimalFormat("$0.00");
        return String.format("%5s %5d %8s %-20s", sku, qty, money.format
                (price), title);
    }*/
}
