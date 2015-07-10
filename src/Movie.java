/**
 * Created by Matt Sullivan & Luis Rocha on 7/7/2015.
 */
import java.io.Serializable;
import java.util.Scanner;
import java.util.Formatter;

/**
 * Implements a class of items that describe a movie. A movie
 * has a unique SKU, a quantity available, a price, and a title.
 * Movies can be added and removed from Inventory, displayed, and
 * located via their SKU.
 */
public class Movie implements Serializable{
    private int sku;
    private int qty;
    private double price;
    private String title;

    /**
     * Blank Constructor for Movie
     */
    public Movie(){
    }

    /**
     * Initialized Constructor for Movie
     * @param sku: int, a unique identifier
     * @param qty: int, how many copies of Movie are in stock
     * @param price: double, how much Movie costs in dollars & cents
     * @param title: String, the name of Movie
     */
    public Movie(int sku, int qty, double price, String title) {
        this.sku = sku;
        this.qty = qty;
        this.price = price;
        this.title = title;
    }

    /**
     * Prompts user for a new movie's SKU, quantity available, price,
     * and title. A movie with a SKU matching a movie already in Inventory
     * will not be added.
     * @return: returns a Movie with all necessary information for addition
     * to Inventory
     */
    public Movie newMovie() {
        int sku;
        int qty;
        double price;
        String title;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter movie SKU (integer, must be unique): ");
        sku = s.nextInt(); //Uniqueness checked in Inventory.addMovie

        do {
            System.out.println("Enter quantity available (cannot be a " +
                                "negative number): ");
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
            if (title.equals("")) System.out.println("Movie title cannot" +
                                                    " be blank. ");
        } while (title.equals(""));

        return new Movie(sku, qty, price, title);
    }

    /**
     * Displays information about a given Movie
     */
    public void displayMovieInfo () {

        System.out.println(String.format("%-10s %-10s %-10s %s",this.sku,this.qty,"$"+this.price,this.title));
    }

    /**
     * Gets the SKU for a given Movie
     * @return: returns a Movie SKU
     */
    public int getSku () {
        return this.sku;
    }
}
