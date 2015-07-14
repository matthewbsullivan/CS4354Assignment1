package assignment1;

import java.io.*;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

/**
 * @author Matt Sullivan
 * @author Luis Rocha
 * Inventory allows the user to manage the inventory of a store that sells
 * various products.
 * User can:
 * Add a product to the inventory.
 * Remove a product from the inventory (by SKU).
 * Display the information for a product (by SKU).
 * Display the sorted contents of the inventory in a table.
 * Save the contents of Inventory to a file named "Inventory".
 * Load the contents of a file named "Inventory" to keep Inventory persistence
 */
public class Inventory implements Serializable {

    private ArrayList<Product> inv = new ArrayList<>(0); //Products are stored
                                        //in an ArrayList, which starts empty

    /**
     * Adds a Movie to inventory if its SKU does not match an existing Movie's
     * SKU. Prints an error and returns to main without adding the Movie
     * otherwise.
     */
    public void addMovie (int sku, int qty, double price, String title, int
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
     *
     * @param sku
     * @param qty
     * @param price
     * @param title
     * @param isbn
     */
    public void addBook (int sku, int qty, double price, String title, int
            isbn) {
        if (isUnique(sku)) {
            Book book = new Book(sku, qty, price, title, isbn);
            inv.add(book);
            System.out.println("Book added successfully.");
        }
        else System.out.println("That SKU exists in the inventory, book not " +
                "added. ");
    }

    /**
     *
     * @param sku
     * @param qty
     * @param price
     * @param title
     * @param weight
     */
    public void addToy (int sku, int qty, double price, String title, double
    weight) {
        if (isUnique(sku)) {
            Toy toy = new Toy(sku, qty, price, title, weight);
            inv.add(toy);
            System.out.println("Toy added successfully.");
        }
        else System.out.println("That SKU exists in the inventory, toy not " +
                "added. ");
    }

    /**
     * Checks a SKU for uniqueness and returns true or false
     * @param sku: int, a unique identifier
     * @return: returns true if a SKU is unique, false if it matches an
     * existing SKU in Inventory.
     */
    public boolean isUnique (int sku){
        int flag = searchList(sku);
        if (flag == -1) return true;
        else return false;//found a matching SKU in Inventory, set
                            //unique to false
    }

    /**
     * Searches Inventory for a given SKU and, if found, removes the Movie
     * entry it corresponds to. Prints an error and returns to Menu without
     * changing anything otherwise.
     * @param sku
     */
    public void removeProduct (int sku) {
        int index = searchList(sku);
        if(index==-1){
            System.out.println("No item found with that sku");
        } else {
            inv.remove(index);
            System.out.println("Removed item with sku " +sku);
        }
    }

    /**
     * Searches Inventory for a given SKU and, if found, displays the
     * information in the corresponding Movie's entry. Prints an error and
     * returns to Menu otherwise.
     * @param sku: int, a unique identifier
     */
    public void displayProduct (int sku) {
        int index = searchList(sku);
        if(index==-1){
            System.out.println("No item found with that sku");
        } else {
            System.out.println(inv.get(index).toStringLabel());
            System.out.println(inv.get(index).toString());
        }

    }

    /**
     * Displays all Movie entries in Inventory line by line, or prints an
     * empty notification if there are no Movies in Inventory.
     */
    public void displayInventory (){
        Collections.sort(inv, new Comparator<Product>() {
            @Override
            public int compare(Product fruite1, Product fruite2)
            {
                //TODO: sort doesn't seem to be working yet
                return fruite1.getSkuString().compareTo(fruite2.getSkuString());
            }
        });

        if (inv.isEmpty()){
            System.out.println("Inventory is empty, returning to Store " +
                    "Menu..."); //Inventory is empty
         }
        else
            for (Product p: inv) {
                System.out.println(p.toStringLabel());
                System.out.println(p.toString());//Display Inventory
                            // contents in order they appear in ArrayList
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
            if (inv.get(i).getSku() == sku) return i;
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
}
