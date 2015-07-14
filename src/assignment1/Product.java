package assignment1;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * @author Matt Sullivan
 * @author Luis Rocha
 */
abstract class Product implements Serializable {
    int sku, qty;
    double price, credit, commission;
    String title, type;
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
     * @returns A formatted string of a Product's type and field values
     * common to all Products
     */
    public String toStringGeneric() {
        DecimalFormat money = new DecimalFormat("$0.00");
        return String.format("%-7s %-7s %-7s %-7s %s", this.type,
                this.sku, this.qty, money.format(this.price),
                this.title);
    }

    /**
     * @return A formatted string of a Product's field values including
     * Product-specific values (i.e. UPC for Movie)
     */
    abstract public String toStringSpecific();

}