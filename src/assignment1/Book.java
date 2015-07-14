package assignment1;
import java.text.*;

/**
 * @author Matt Sullivan
 * @author Luis Rocha
 */
public class Book extends Product{
    private int isbn;


    /**
     * Initialized Constructor for Book
     * @param sku: int, a unique identifier
     * @param qty: int, how many copies of Movie are in stock
     * @param price: double, how much Movie costs in dollars & cents
     * @param title: String, the name of Movie
     * @param isbn: int,
     */
    public Book(int sku, int qty, double price, String title, int isbn) {
        this.sku = sku;
        this.qty = qty;
        this.price = price;
        this.title = title;
        this.isbn  = isbn;
        this.credit = 3.99;
        this.commission = .15;
    }

    /**
     *
     * @return
     */
    public String toStringLabel(){
        return String.format("%-7s %-7s %-7s %-7s %-7s %s", "", "SKU",
                "QTY","Price", "ISBN", "Title");
    }

    /**
     *
     * @return
     */
    public String toString() {
        DecimalFormat money = new DecimalFormat("$0.00");
        return String.format("%-7s %-7s %-7s %-7s %-7s %s", "Book: ",
                this.sku, this.qty, money.format(this.price),
                this.isbn, this.title);
    }
}
