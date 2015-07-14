package assignment1;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Matt Sullivan
 * @author Luis Rocha
 */
abstract class Product implements Serializable {
    int sku, qty;
    double price;
    String title;

    //Trying to add items will start with books first.
    public void getValues(){
        String input;
        Scanner s = new Scanner(System.in);

        System.out.print("Enter movie SKU (integer, must " +
                "be unique): ");
        sku = s.nextInt(); //Uniqueness checked in
        // Inventory.addMovie

        System.out.print("Enter quantity available " +
                "(cannot be a negative number): ");
        qty = s.nextInt();

        System.out.print("Enter movie price (e.g. 17.99)" +
                ": ");
        price = s.nextDouble();
        s.nextLine();

        System.out.print("Enter movie title (e.g. Turner " +
                "& Hooch): ");
        title = s.nextLine();
    }

    abstract void getSpecial();
    ///////////////////////////////////////////////////////////////////////////
    ///Getters
    ///////////////////////////////////////////////////////////////////////////
    /**
     * Gets the SKU for a given item
     * @return: returns a Movie SKU
     */
    public int getSku(){
        return this.sku;
    }
    /**
     * Gets the SKU for a given item
     * @return: returns a Movie SKU in string format to be able to sort the list.
     */
    public String getSkuString(){
        return Integer.toString(this.sku);
    }
    /**
     * Gets the qty for a given Item
     * @return: returns a qty
     */
    public int getQty(){
        return this.qty;
    }
    /**
     * Gets the price for any given item
     * @return: returns a price
     */
    public double getPrice(){
        return this.price;
    }
    /**
     * Gets the qty for a given Item
     * @return: returns the tille
     */
    public String getTitle(){
        return this.title;
    }

    abstract public String labeledString();

    abstract public String toString();/*{
        DecimalFormat money = new DecimalFormat("$0.00");
        return String.format("%5s %5d %8s %-20s", sku, qty, money.format
                (price), title);
    }*/


}
/*&
abstract class Product implements Comparable<Product> {

}*/