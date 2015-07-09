/**
 * Created by Matt Sullivan on 7/7/2015.
 * Inventory allows the user to manage the inventory of a store that sells DVDs.
 * User can:
 * Add a movie to the inventory.
 * Remove a movie from the inventory (by SKU).
 * Display the information for a movie (by SKU).
 * Display the contents of the inventory in a table.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {



    /**
     * Add a movie to inventory
     */
    public Movie addMovie() {
        int sku;
        int qty;
        double price;
        String title;
        Scanner s = new Scanner(System.in);
        //add a movie to inventory
        System.out.println("Enter movie SKU (integer, must be unique): ");
        sku = s.nextInt();
        //need a function to search inventory for SKU matches, return to main with error if match found
        do {
            System.out.println("Enter quantity available (cannot be a negative number): ");
            qty = s.nextInt();
            if (qty < 0 ) System.out.println("Quantity cannot be negative. ");
        } while (qty < 0 );

        do {
            System.out.println("Enter movie price (e.g. 17.99): ");
            price = s.nextDouble();
            if (price < 0.0 ) System.out.println("Quantity cannot be negative. ");
        } while (price < 0.0 );

     //   do {
            System.out.println("Enter movie title (e.g. Turner & Hooch): ");

            title = s.nextLine();
     //       if (title.equals(null)) System.out.println("Title must be initialized ");
    //    } while (title.equals(null));
        s.nextLine(); // added this because if you don't it keeps skipping the last question.
        Movie newMovie = new Movie(sku, qty, price, title);

        return newMovie;
    }

    /**
     * Remove a movie from inventory
     */
    public void removeMovie (ArrayList<Movie> inventoryList,int sku) {
        //remove a movie from inventory (by SKU).
        //fails if SKU entered is not in inventory
        for(int x = 0; x < inventoryList.size(); x++){
            if(sku == inventoryList.get(x).skuGet())
            {
                inventoryList.remove(x);
                System.out.println(sku+" has been removed!");
                return;

            }
        }
        System.out.println(sku+" was not found");
    }

    /**
     * Display one movie from inventory
     */
    public void displayMovie (ArrayList<Movie> inventoryList,int sku) {
        //display a single movie from inventory (by SKU).
        //fails if SKU entered is not in inventory
        for(int x = 0; x < inventoryList.size(); x++){
            if(sku == inventoryList.get(x).skuGet())
            {
                System.out.println("Movie Title:"+inventoryList.get(x).titleGet());
                System.out.println("Sku:\t"+inventoryList.get(x).skuGet());
                System.out.println("Price:\t"+inventoryList.get(x).priceGet());
                System.out.println("Qty:\t"+inventoryList.get(x).qtyGet());
                return;
            }
        }
        System.out.println(sku+" was not found");
    }

    /**
     * Display entire inventory in a table
     */
    public void displayTable (){
        //display a table of the inventory contents
        //display an empty notification if inventory has no contents
        System.out.println("WARNING: stub implementation"); //Stub warning
    }
}
