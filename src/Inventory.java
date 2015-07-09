/**
 * Created by Matt Sullivan on 7/7/2015.
 * Inventory allows the user to manage the inventory of a store that sells DVDs.
 * User can:
 * Add a movie to the inventory.
 * Remove a movie from the inventory (by SKU).
 * Display the information for a movie (by SKU).
 * Display the contents of the inventory in a table.
 */
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Inventory implements Serializable {

    private ArrayList<Movie> inv = new ArrayList<>(0);

    /**
     * Add a movie to inventory
     */
    public void addMovie(Movie mov) {
        if (isUnique(mov.getSku())) inv.add(mov);
        else System.out.println("That SKU exists in the inventory, movie not added. ");
    }

    /**
     * Checks a SKU for uniqueness and returns true or false
     * @param sku
     * @return
     */
    public boolean isUnique(int sku){
        boolean unique = true;
        for (int x = 0; x < inv.size(); x++) {
            if (sku == inv.get(x).getSku()) {
                unique = false;
            }
        }
        return unique;
    }

    /**
     *
     * @param sku
     */
    public void removeMovie (int sku) {
        //remove a movie from inventory (by SKU).
        //fails if SKU entered is not in inventory
        boolean found = false;
        for (int x = 0; x < inv.size(); x++){
            if (sku == inv.get(x).getSku()){
                inv.remove(x);
                found = true;
                System.out.println("SKU " + sku + " successfully removed.");
            }
        }
        if(!found) System.out.println("SKU " + sku + " not found, nothing removed.");
    }

    /**
     *
     * @param sku
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
     *
     */
    public void displayInventory (){
        //display a table of the inventory contents
        //display an empty notification if inventory has no contents
        if (inv.isEmpty()){
            System.out.println("Inventory is empty, returning to Store Menu...");
        }
        else for(int x = 0; x < inv.size(); x++){
                inv.get(x).displayMovieInfo();
        }
    }

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
