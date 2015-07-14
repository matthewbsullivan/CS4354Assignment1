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
    ///////////////////////////////////////////////////////////////////////////
    ///Setters
    ///////////////////////////////////////////////////////////////////////////
    /**
     * Sets the SKU for a given item
     * @return: void
     */
    public void setSku(int newSku){
        this.sku = newSku;
    }
    /**
     * Sets the QTY for a given item
     * @return: void
     */
    public void setQty(int newQty){
        this.qty = newQty;
    }
    /**
     * Sets the price for a given item
     * @return: void
     */
    public void setPrice(double newPrice){
        this.price = newPrice;
    }
    /**
     * Set the title for a given Item
     * @return: void
     */
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    ///////////////////////////////////////////////////////////////////////////
    ///Getters
    ///////////////////////////////////////////////////////////////////////////
    /**
     * Gets the SKU for a given item
     * @return: returns a Movie SKU
     */
    public int getSku(){
        return this.sku;
    }
    /**
     * Gets the SKU for a given item
     * @return: returns a Movie SKU in string format to be able to sort the list.
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
     * Gets the price for any given item
     * @return: returns a price
     */
    public double getPrice(){
        return this.price;
    }
    /**
     * Gets the qty for a given Item
     * @return: returns the tille
     */
    public String getTitle(){
        return this.title;
    }

    abstract public String toStringLabel();
    abstract public String toString();
}