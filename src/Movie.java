/**
 * Created by Matt Sullivan on 7/7/2015.
 * Each movie contains the following information for
 *(each title) in the inventory:
 *SKU (stock-keeping unit, an integer, must be unique)
 *quantity (number of copies in inventory, greater than or equal to 0)
 *price (dollars and cents, greater than 0)
 *title (may contain spaces in it)
 */
import java.io.Serializable;
import java.util.Scanner;

public class Movie implements Serializable{
    private int sku;
    private int qty;
    private double price;
    private String title;

    /**
     *
     */
    public Movie(){
    }
    /**
     * Initialized Constructor for Movie
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

    /**
     *
     * @return
     */
    public Movie newMovie() {
        int sku;
        int qty;
        double price;
        String title;
        Scanner s = new Scanner(System.in);
        //add a movie to inventory
        System.out.println("Enter movie SKU (integer, must be unique): "); //Uniqueness checked by Inventory.addMovie
        sku = s.nextInt();

        do {
            System.out.println("Enter quantity available (cannot be a negative number): ");
            qty = s.nextInt();
            if (qty < 0 ) System.out.println("Quantity cannot be negative. ");
        } while (qty < 0 );

        do {
            System.out.println("Enter movie price (e.g. 17.99): ");
            price = s.nextDouble();
            if (price < 0.0 ) System.out.println("Price cannot be negative. ");
        } while (price < 0.0 );

        s.nextLine();

        do {
            System.out.println("Enter movie title (e.g. Turner & Hooch): ");
            title = s.nextLine();
            if (title.equals("")) System.out.println("Movie title cannot be blank. ");
        } while (title.equals(""));

        return new Movie(sku, qty, price, title);
    }

    /**
     *
     */
    public void displayMovieInfo () {
        //display a single movie from inventory (by SKU).
        //fails if SKU entered is not in inventory
        System.out.println("SKU: " + this.sku + " Title: " + this.title + " Qty: " + this.qty + " Price: " +this.price);
        System.out.println();
    }

    /**
     *
     * @return
     */
    public int getSku () {
        return this.sku;
    }
}
