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
    private String isbn;

    public void setIsbn(String newIsbn){
        this.isbn = newIsbn;
    }


    public Book(){}

    public Book(int sku, int qty, double price, String title, String isbn) {
        this.sku = sku;
        this.qty = qty;
        this.price = price;
        this.title = title;
        this.isbn = isbn;
    }
    void setUpcIsbnWeight(){}
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
     *
     * @return
     */
    //probably end up moving this .
    public String labeledString(){
        DecimalFormat money = new DecimalFormat("$0.00");
        return "sku=" +sku+ "\nquantity=" +qty+ "\nprice=" +money.format(price)
                + "\ntitle=" +title+ "\nISBN=" +isbn;
    }

    public String toString(){
        DecimalFormat money = new DecimalFormat("$0.00");
        return String.format("%5s %5d %8s %-20s", sku, qty, money.format
                (price), title, isbn);
    }
}
