/**
 * Created by Matt Sullivan on 7/7/2015.
 * Inventory allows the user to manage the inventory of a store that sells DVDs.
 * User can:
 * Add a movie to the inventory.
 * Remove a movie from the inventory (by SKU).
 * Display the information for a movie (by SKU).
 * Display the contents of the inventory in a table.
 */
public class Inventory {

    /**
     * Add a movie to inventory
     */
    public void addMovie() {
        //add a movie to inventory
        //fails if SKU entered already exists
    }

    /**
     * Remove a movie from inventory
     */
    public void removeMovie () {
        //remove a movie from inventory (by SKU).
        //fails if SKU entered is not in inventory
    }

    /**
     * Display one movie from inventory
     */
    public void displayMovie () {
        //display a single movie from inventory (by SKU).
        //fails if SKU entered is not in inventory
    }

    /**
     * Display entire inventory in a table
     */
    public void displayTable (){
        //display a table of the inventory contents
        //display an empty notification if inventory has no contents
    }
}
