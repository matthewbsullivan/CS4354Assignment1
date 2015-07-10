/**
 * Created by Matt Sullivan & Luis Rocha on 7/7/2015.
 */
package assignment1;
import java.util.Scanner;

public class  Main {

    /**
     * A menu for a movie store inventory. Users can add, remove, or view
     * a movie's entry in the inventory, as well as view a list of the
     * inventory's contents.
     * @param args: takes input from keyboard for Scanner
     */
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.loadFromFile(); //load a saved ArrayList<Movie> to inv
                            // from file "Inventory"
        Movie mov = new Movie();
        String input;
        Scanner s = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println("Store Menu: ");
            System.out.println("1. Add a movie to the inventory.");
            System.out.println("2. Remove a movie from the inventory " +
                                "(by sku).");
            System.out.println("3. Display the information for a movie " +
                                "(given the sku).");
            System.out.println("4. Display the inventory in a table.");
            System.out.println("5. Quit.");
            input = s.nextLine();

            switch (input) {
                case "1":
                    int sku;
                    int qty;
                    double price;
                    String title;
                    System.out.print("Enter movie SKU (integer, must be " +
                            "unique): ");
                    sku = s.nextInt(); //Uniqueness checked in
                                        // Inventory.addMovie

                    do {
                        System.out.print("Enter quantity available " +
                                "(cannot be a negative number): ");
                        qty = s.nextInt();
                        if (qty < 0 ) System.out.println("Quantity cannot be " +
                                                        "negative. ");
                    } while (qty < 0 );

                    do {
                        System.out.print("Enter movie price (e.g. 17.99): ");
                        price = s.nextDouble();
                        if (price < 0.0 ) System.out.println("Price cannot be "+
                                                            "negative. ");
                    } while (price < 0.0 );
                    s.nextLine();

                    do {
                        System.out.print("Enter movie title (e.g. Turner & " +
                                            "Hooch): ");
                        title = s.nextLine();
                        if (title.equals("")) System.out.println("Movie title" +
                                                    " cannot be blank. ");
                    } while (title.equals(""));
                    inv.addMovie(mov.newMovie(sku, qty, price, title));
                    //prompts user for needed
                                        // info to add a movie to Inventory
                    break;
                case "2":
                    System.out.println("Enter SKU of movie to remove: ");
                    int removalCandidate = s.nextInt();
                    inv.removeMovie(removalCandidate); //checks Inventory for a
                            // SKU match and removes the matching movie if found
                    s.nextLine();
                    break;
                case "3":
                    System.out.println("Enter SKU of movie to display: ");
                    int displayCandidate = s.nextInt();
                    inv.displayMovie(displayCandidate); //checks Inventory for
                        // a SKU match and displays the matching movie if found
                    s.nextLine();
                    break;
                case "4":
                    inv.displayInventory(); //displays entire contents
                                            // of Inventory
                    break;
                case "5":
                    System.out.println("Quitting.");
                    break;
                default: System.out.println("Invalid Input, Pick A Number " +
                                            "Between 1 And 5.");
            }
        } while (!input.equals("5")); //

        inv.saveToFile(); //save inv to file for later use
    }
}

