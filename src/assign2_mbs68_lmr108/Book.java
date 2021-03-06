package assign2_mbs68_lmr108;
/**
 *
 * @author Matt Sullivan
 * @author Luis Rocha
 * Implements a subclass of Product that contains retail information pertaining
 * to a Book
 */
public class Book extends Product{
    private int isbn;
    private String author;

    /**
     * Initialized Constructor for Book
     * @param sku: int, a unique identifier
     * @param qty: int, how many copies of Movie are in stock
     * @param price: double, how much Movie costs in dollars & cents
     * @param title: String, the name of Movie
     * @param isbn: int,
     */
    public Book(int sku, int qty, double price, String title, int isbn, String
            author) {
        this.sku = sku;
        this.qty = qty;
        this.price = price;
        this.title = title;
        this.isbn  = isbn;
        this.credit = 3.99;
        this.commission = .15;
        this.author = author;
        this.type = "Book: ";
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
                             "\nisbn=     " + isbn +
                             "\nauthor=   " +author);
    }
}
