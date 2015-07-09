/**
 * Created by Matt Sullivan & Luis Rocha on 7/7/2015.
 */
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
                    inv.addMovie(mov.newMovie()); //prompts user for needed
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

