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

    private Movie invMovie;
    private ArrayList<Movie> inventory = new ArrayList<Movie>(0);

    /**
     * Add a movie to the Inventory.
     */
    public void addMovie() {
        Movie movArg = new Movie();
        movArg = movArg.newMovie();
        for (int i = 0; i < inventory.size(); i++) {
            if (i ==  inventory.size()){
                inventory.add(i, movArg);
            }
        }
    }
    /**
     * Display entire inventory in a table
     */
    public void displayTable (){
        //display a table of the inventory contents
        //display an empty notification if inventory has no contents
        System.out.println("Inventory: ");
        System.out.println("===================================================================");
        for (int i = 0; i < inventory.size(); i++) {

            invMovie = inventory.get(i);
            invMovie.displayMovie(invMovie.getSku(), invMovie);
        }
    }
}
