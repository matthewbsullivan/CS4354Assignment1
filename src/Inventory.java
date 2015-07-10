/**
 * Created by Matt Sullivan & Luis Rocha on 7/7/2015.
 */
import java.io.*;
import java.util.ArrayList;

/**
 * Inventory allows the user to manage the inventory of a store that sells
 * movies.
 * User can:
 * Add a movie to the inventory.
 * Remove a movie from the inventory (by SKU).
 * Display the information for a movie (by SKU).
 * Display the contents of the inventory in a table.
 * Save the contents of Inventory to a file named "Inventory".
 * Load the contents of a file named "Inventory" to keep Inventory persistence
 */
public class Inventory implements Serializable {

    private ArrayList<Movie> inv = new ArrayList<>(0); //Movies are stored in an
                                                // ArrayList, which starts empty

    /**
     * Adds a Movie to inventory if its SKU does not match an existing Movie's
     * SKU. Prints an error and returns to main without adding the Movie
     * otherwise.
     */
    public void addMovie(Movie mov) {
        if (isUnique(mov.getSku())) inv.add(mov);
        else System.out.println("That SKU exists in the inventory, movie not " +
                "added. ");
    }

    /**
     * Checks a SKU for uniqueness and returns true or false
     * @param sku: int, a unique identifier
     * @return: returns true if a SKU is unique, false if it matches an
     * existing SKU in Inventory.
     */
    public boolean isUnique(int sku){
        boolean unique = true;
        for (int x = 0; x < inv.size(); x++) {
            if (sku == inv.get(x).getSku()) {
                unique = false; //found a matching SKU in Inventory, set
                                // unique to false
            }
        }
        return unique;
    }

    /**
     * Searches Inventory for a given SKU and, if found, removes the Movie
     * entry it corresponds to. Prints an error and returns to Menu without
     * changing anything otherwise.
     * @param sku
     */
    public void removeMovie (int sku) {
        boolean found = false;
        for (int x = 0; x < inv.size(); x++){
            if (sku == inv.get(x).getSku()){
                inv.remove(x);
                found = true;
                System.out.println("SKU " + sku + " successfully removed.");
            }
        }
        if(!found) System.out.println("SKU " + sku + " not found, nothing " +
                "removed.");
    }

    /**
     * Searches Inventory for a given SKU and, if found, displays the
     * information in the corresponding Movie's entry. Prints an error and
     * returns to Menu otherwise.
     * @param sku: int, a unique identifier
     */
    public void displayMovie (int sku) {

        for(int x = 0; x < inv.size(); x++){
            if(sku == inv.get(x).getSku()) {
                inv.get(x).displayMovieInfo();
                return;
            }
        }
        System.out.println("SKU not found, returning to Store Menu...");
    }

    /**
     * Displays all Movie entries in Inventory line by line, or prints an
     * empty notification if there are no Movies in Inventory.
     */
    public void displayInventory (){

        if (inv.isEmpty()){
            System.out.println("Inventory is empty, returning to Store " +
                    "Menu..."); //Inventory is empty
         }

        else
            System.out.println(String.format("%-10s %-10s %-10s %s" , "SKU", "QTY","Price","Title"));
            for(int x = 0; x < inv.size(); x++){
                inv.get(x).displayMovieInfo(); //Display Inventory contents
                                        // in order they appear in ArrayList
        }
        System.out.println();
    }

    /**
     * Saves current state of Inventory to file "Inventory"
     */
    public void saveToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("Inventory");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(inv);
            fos.close();
        }   catch (IOException e) {
            System.out.println("Problem with file output");
        }
    }

    /**
     * Loads version of Inventory that exists in file "Inventory"
     */
    public void loadFromFile(){
        try {
            FileInputStream fis = new FileInputStream("Inventory");
            ObjectInputStream ois = new ObjectInputStream(fis);
            inv = (ArrayList<Movie>) ois.readObject();
            fis.close();
        }   catch (FileNotFoundException e) {
            System.out.println("Cannot find datafile.");
        } catch (IOException e) {
            System.out.println("Problem with file input.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found on input from file.");
        }
    }
}
