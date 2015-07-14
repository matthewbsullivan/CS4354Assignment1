/**
 * Created by Matt Sullivan & Luis Rocha on 7/7/2015.
 */
package assignment1;
import java.io.*;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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

    private ArrayList<Product> inv = new ArrayList<>(0); //Movies are stored
    // in an
                                                // ArrayList, which starts empty

    /**
     * Adds a Movie to inventory if its SKU does not match an existing Movie's
     * SKU. Prints an error and returns to main without adding the Movie
     * otherwise.
     */
    public void addMovie(int sku, int qty, double price, String title, int
            upc) {
        if (isUnique(sku)) {
            Movie mov = new Movie(sku, qty, price, title, upc);
            inv.add(mov);
            System.out.println("Movie added successfully.");
        }
        else System.out.println("That SKU exists in the inventory, movie not " +
                "added. ");
    }

    /**
     * Void addItemToArray
     *
     * This function prints out the menu to select books, dvd, or toys
     * sets up a scanner and gets choice.
     * depending on choice it will invoke a getValues(); to get the values that all three products share. Then it will
     * get the values that only that specific item has. Finally it will add it to the array of products.
     * @param
     * @retun void
     */
    public void addItemToArray(char optionMBT){
        System.out.print("Enter M for Movies, B for books, or T for toys: ");
        char choice = 'B';
        if(choice=='B'){Product newProduct=new Book();newProduct.getValues();newProduct.getSpecial();inv.add(newProduct);}
        else if(choice=='M'){Product newProduct=new Book();newProduct.getValues();newProduct.getSpecial();inv.add(newProduct);}
        else if(choice=='M'){Product newProduct=new Book();newProduct.getValues();newProduct.getSpecial();inv.add(newProduct);}
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
        int index = searchList(sku);
        if(index==-1){
            System.out.println("No movie found with that sku");
        } else {
            inv.remove(index);
            System.out.println("Removed movie with sku " +sku);
        }
    }

    /**
     * Searches Inventory for a given SKU and, if found, displays the
     * information in the corresponding Movie's entry. Prints an error and
     * returns to Menu otherwise.
     * @param sku: int, a unique identifier
     */
    public void displayMovie (int sku) {
        int index = searchList(sku);
        if(index==-1){
            System.out.println("No movie found with that sku");
        } else {
            Product product = inv.get(index);
            //System.out.println(product.labeledString());
            System.out.println("Found, stub implementation for now");
        }
    }

    /**
     * Displays all Movie entries in Inventory line by line, or prints an
     * empty notification if there are no Movies in Inventory.
     */
    public void displayInventory (){
        Collections.sort(inv, new Comparator<Product>() {
            @Override
            public int compare(Product  fruite1, Product  fruite2)
            {

                return  fruite1.getSkuString().compareTo(fruite2.getSkuString());
            }
        });

        if (inv.isEmpty()){
            System.out.println("Inventory is empty, returning to Store " +
                    "Menu..."); //Inventory is empty

         }
        else{
            System.out.println(String.format("%-20s %-20s %-20s %s" , "SKU",
                                            "QTY","Price","Title"));
            //This next loop prints out sku,qty,price,and title all space apart equally to match the
            //spacing of the header above.
            for (Product p: inv) {
                System.out.println(String.format("%-20s %-20s %-20s %s", p.getSku(), p.getQty(), p.getPrice(),
                        p.getTitle()));
            }
        }
        System.out.println();
    }

    /**
     *
     * @param sku
     * @return 1 if sku is found in Inventory, -1 if not found
     */
    private int searchList(int sku){
        for (int i=0; i<inv.size(); i++){
            if (inv.get(i).getSku() == sku) return 1;
        }
        return -1;
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
            inv = (ArrayList<Product>) ois.readObject();
            fis.close();
        }   catch (FileNotFoundException e) {
            System.out.println("Cannot find datafile.");
        } catch (IOException e) {
            System.out.println("Problem with file input.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found on input from file.");
        }
    }
    public void MenuOptions(){
        System.out.println();
        System.out.println("Store Menu: ");
        System.out.println("1. Add a movie to the inventory.");
        System.out.println("2. Remove a movie from the inventory " +
                "(by sku).");
        System.out.println("3. Display the information for a movie " +
                "(given the sku).");
        System.out.println("4. Display the inventory in a table.");
        System.out.println("5. Quit.");
    }
    public void ChoiceOptions(){
        System.out.print("Enter the character that corresponds to" +
                " the item you want to add:\n" +
                "'M' for Movie\n" +
                "'B' for Book\n" +
                "'T' for Toy\n\nEnter your choice:");
    }

}
