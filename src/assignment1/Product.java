package assignment1;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author Matt Sullivan
 * @author Luis Rocha
 */
abstract class Product implements Serializable {
    int sku, qty;
    double price;
    String title;

    /**
     * Gets the SKU for a given item
     * @return: returns a Movie SKU
     */
    public int getSku(){
        return this.sku;
    }
    /**
     * Gets the SKU for a given item
     * @return: returns a Movie SKU
     */
    public String getSkuString(){
        return Integer.toString(this.sku);
    }
    /**
     * Gets the qty for a given Item
     * @return: returns a qty
     */
    public int getQty(){
        return this.qty;
    }
    /**
     * Gets the qty for a given Item
     * @return: returns a qty
     */
    public double getPrice(){
        return this.price;
    }
    /**
     * Gets the qty for a given Item
     * @return: returns a qty
     */
    public String getTitle(){
        return this.title;
    }

    abstract public String labeledString();

    abstract public String toString();/*{
        DecimalFormat money = new DecimalFormat("$0.00");
        return String.format("%5s %5d %8s %-20s", sku, qty, money.format
                (price), title);
    }*/


}
/*&
abstract class Product implements Comparable<Product> {

}*/