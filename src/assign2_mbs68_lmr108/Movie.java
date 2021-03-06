package assign2_mbs68_lmr108;

/**
 * @author Matt Sullivan
 * @author Luis Rocha
 * Implements a subclass of Product that contains retail information pertaining
 * to a Movie
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
        this.credit = 2.98;
        this.commission = .12;
        this.type = "Movie: ";
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
                             "\nupc=      " + upc);
    }
}
