package assignment1;

import java.io.Serializable;

/**
 * @author Matt Sullivan
 * @author Luis Rocha
 */
abstract class Product implements Serializable {
    int sku, qty;
    double price, credit, commission;
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
     * @return: returns the title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Gets the commission for a given item
     * @return: returns the commission
     */
    public double getCommission(){
        return this.commission;
    }

    /**
     *Calculates the total commission on a sale
     * @return: commission percentage * price per item * items sold
     */
    public double calcTotalCommission(int itemsSold){
        return this.commission * this.price * itemsSold;
    }

    /**
     * Calculates the total shipping credit on a sale
     * @return per item credit * items sold
     */
    public double calcTotalCredit(int itemsSold){
        return this.credit * itemsSold;
    }

    /**
     * Calculates the total price of a sale
     * @return per item price * items sold
     */
    public double calcTotalPrice(int itemsSold){
        return this.price * itemsSold;
    }

    /**
     *
     * @return
     */
    abstract public String toStringLabel();

    /**
     *
     * @return
     */
    abstract public String toString();
}