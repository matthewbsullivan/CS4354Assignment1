/**
 * Created by Matt Sullivan on 7/7/2015.
 * Each movie contains the following information for
 *(each title) in the inventory:
 *SKU (stock-keeping unit, an integer, must be unique)
 *quantity (number of copies in inventory, greater than or equal to 0)
 *price (dollars and cents, greater than 0)
 *title (may contain spaces in it)
 */
public class Movie {
    private int sku;
    private int qty;
    private double price;
    private String title;
    public int skuGet(){return sku;}
    public double priceGet(){return price;}
    public String titleGet(){return title;}
    public int qtyGet(){return qty;}
    /**
     * Constructor for Movie
     * @param sku: unique tracking integer assigned to movie
     * @param qty: number of copies of movie available
     * @param price: cost in dollars and cents
     * @param title: name of movie
     */
    public Movie(int sku, int qty, double price, String title) {
        this.sku = sku;
        this.qty = qty;
        this.price = price;
        this.title = title;
    }
}
