/**
 * Created by Matt Sullivan & Luis Rocha on 7/7/2015.
 */
package assignment1;
import java.text.*;
import java.util.Scanner;
import java.lang.*;
/**
 * Implements a class of items that describe a movie. A movie
 * has a unique SKU, a quantity available, a price, and a title.
 * Movies can be added and removed from Inventory, displayed, and
 * located via their SKU.
 */
public class Book extends Product{
    //Variable Declaration
    private String isbn;            //Book.java's special attribute not included in the abstract class of Product.java
    //Default Constructor
    public Book(){}
    /**
     * void getSpecial
     *
     * Gets user input to get the isbn for the book.
     * @return void
     */
    void getSpecial(){
        Scanner isbnScanner = new Scanner(System.in);
        System.out.print("Please enter the isbn for this book\n\t");
        isbn = isbnScanner.nextLine();
    }
    /**
     * String labeledString
     *
     * Returns a string with with labels of each item used when using the menu option of display line item.
     * @return void
     */
    public String labeledString(){
        DecimalFormat money = new DecimalFormat("$0.00");
        return "\nSku=" +sku+ "\nQuantity=" +qty+ "\nPrice=" +money.format(price)
                + "\nTitle=" +title+ "\nISBN=" +isbn;
    }
    /**
     * void getSpecial
     *
     * Returns in uniformed format the sku qty, title, price and isbn;
     * @return void
     */
    public String toString(){
        DecimalFormat money = new DecimalFormat("$0.00");
        return String.format("%5s %5d %8s %-20s", sku, qty, money.format
                (price), title, isbn);
    }
}
