package assignment1;

import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

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
     * @param sku: int, a unique identifier
     * @param qty: int, quantity of a movie in Inventory
     * @param price: double, price of a movie in dollars and cents
     * @param title: string, a movie's title
     * @param upc: int, Universal Product Code, unique to Movies
     */
    public void addMovie (int sku, int qty, double price, String title, int
            upc)
    {
        if (qty < 0 || price < 0.0 || Objects.equals(title, "") || upc < 0){
            System.out.println("Invalid input, item not added.");
        }else if (isUnique(sku)) {
            Movie mov = new Movie(sku, qty, price, title, upc);
            inv.add(mov);
            System.out.println("Movie added successfully.");
        }
        else System.out.println("That SKU exists in the inventory, movie not " +
                "added. ");
    }

    /**
     * Adds a Book to the Inventory if provide SKU is unique. Prints an error
     * and returns to main without adding the Book otherwise.
     * @param sku: int, a unique identifier
     * @param qty: int, quantity of a book in Inventory
     * @param price: double, price of a toy in dollars and cents
     * @param title: string, a book's title
     * @param isbn: int, International Standard Book Number, unique to Books
     */
    public void addBook (int sku, int qty, double price, String title, int
            isbn, String author)
    {
        if (qty < 0 || price < 0.0 || Objects.equals(title, "") || isbn < 0){
            System.out.println("Invalid input, item not added.");
        }else if (isUnique(sku)) {
            Book book = new Book(sku, qty, price, title, isbn, author);
            inv.add(book);
            System.out.println("Book added successfully.");
        }
        else System.out.println("That SKU exists in the inventory, book not " +
                "added. ");
    }

    /**
     * Adds a Toy to the Inventory if provide SKU is unique. Prints an error
     * and returns to main without adding the Toy otherwise.
     * @param sku: sku: int, a unique identifier
     * @param qty: int, quantity of a toy in Inventory
     * @param price: double, price of a toy in dollars and cents
     * @param title: string, a toy's name.
     * @param weight: double, toy's weight. Used to calculate shipping credit.
     *              Unique to Toys.
     */
    public void addToy (int sku, int qty, double price, String title, double
    weight)
    {
        if (qty < 0 || price < 0.0 || Objects.equals(title, "") ||
                weight <= 0.0)
        {
            System.out.println("Invalid input, item not added.");
        }else if (isUnique(sku)) {
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
     * existing SKU in Inventory.
     */
    public boolean isUnique (int sku){
        int flag = searchList(sku);
        return flag == -1;
    }

    /**
     * Searches Inventory for a given SKU and, if found, removes the Movie
     * entry it corresponds to. Prints an error and returns to Menu without
     * changing anything otherwise.
     * @param sku: int, a unique identifier
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
            System.out.println(inv.get(index).toStringSpecific());
        }

    }

    /**
     * Displays all Product entries in Inventory line by line, or prints an
     * empty notification if there are no Products in Inventory.
     */
    public void displayInventory (){
        Collections.sort(inv, new Comparator<Product>(){
            public int compare(Product p1, Product p2)
            {
                return p1.getSku() - p2.getSku();
            }
        });

        if (inv.isEmpty()){
            System.out.println("Inventory is empty, returning to Store " +
                    "Menu..."); //Inventory is empty
         }
        else

            for (Product p: inv) {
                System.out.println(p.toStringGeneric());//Display Inventory
                            // contents in order they appear in ArrayList
        }
        System.out.println();
    }

    /**
     * Processes a sale based on assignment specifications and prints the
     * profit. Profit = Total price + Total shipping credit - (Total
     * commission + Shipping Cost)
     * @param sku: int, a unique identifier
     * @param qtySold: int, the number of an item sold
     * @param shipCost: double, the total cost to ship a sale
     */
    public void processSale(int sku, int qtySold, double shipCost) {
        int index = searchList(sku);
        if (index == -1) {
            System.out.println("Item not found, sale aborted.");
        }
        else {
            //quantity after items sold are subtracted
            int qtyNew = inv.get(index).getQty() - qtySold;

            if (qtyNew < 0){ //qty after sale cannot be less than zero
                System.out.println("Not enough inventory, sale aborted.");
            } else {
                inv.get(index).setQty(qtyNew); //item's qty updated to qtyNew

                //calculate profit on sale
                double  credit = inv.get(index).calcTotalCredit(qtySold),
                        commission = inv.get(index).calcTotalCommission
                                (qtySold),
                        price = inv.get(index).calcTotalPrice(qtySold),
                        profit = price + credit - (commission + shipCost);

                //print profit in money format
                DecimalFormat money = new DecimalFormat("$0.00");
                money.setRoundingMode(RoundingMode.HALF_UP);
                System.out.println("Total Price: " + money.format(price));
                System.out.println("S&H Credit:  " + money.format(credit));
                System.out.println("Commission:  " + money.format(commission));
                System.out.println("Profit:      " + money.format(profit));
            }
        }
    }

    /**
     *
     * @param sku: int, a unique identifier
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
     *
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
