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
        this.credit = 4.49 + 0.50*(Math.ceil(weight/16.0));//16 oz in a pound
        this.commission = .15;
        this.type = "Toy: ";
    }

    /**
     * @return A formatted string of a Product's field values including
     * Product-specific values (i.e. UPC for Movie)
     */
    public String toStringSpecific(){
        return String.format("sku=      " + sku +
                             "\nquantity= " + qty +
                             "\nprice=    " + price +
                             "\ntitle=    " + title +
                             "\nweight=   " + weight);
    }
}
