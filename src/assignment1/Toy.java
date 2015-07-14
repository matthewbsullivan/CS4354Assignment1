package assignment1;

import java.text.DecimalFormat;

/**
 * @author Matt Sullivan
 * @author Luis Rocha
 */
public class Toy extends Product{
    private double weight;
    /**
     * Initialized Constructor for Toy
     * @param sku: int, a unique identifier
     * @param qty: int, how many copies of Toy are in stock
     * @param price: double, how much Toy costs in dollars & cents
     * @param title: String, the name of Toy
     * @param weight: double, weight of Toy in ounces
     */
    public Toy(int sku, int qty, double price, String title, double weight) {
        this.sku = sku;
        this.qty = qty;
        this.price = price;
        this.title = title;
        this.weight = weight;
    }

    /**
     *
     * @return
     */
    public String toStringLabel(){
        return String.format("%-7s %-7s %-7s %-7s %-7s %s", "", "SKU",
                "QTY","Price", "Weight", "Title");
    }

    /**
     *
     * @return
     */
    public String toString(){
        DecimalFormat money = new DecimalFormat("$0.00");
        DecimalFormat oz = new DecimalFormat("0.0oz");
        return String.format("%-7s %-7s %-7s %-7s %-7s %s", "Toy: ",
                this.sku, this.qty, money.format(this.price),
                oz.format(this.weight), this.title);
    }
}
