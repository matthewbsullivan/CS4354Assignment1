/**
 * Created by Matt Sullivan on 7/7/2015.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /**
         * Creates a new, empty ArrayList of Movies
         */

            ArrayList<Movie> inventoryList = new ArrayList<Movie>(0);

        String emptyPrompt = "There is not any movies in the inventory";

        Inventory inv = new Inventory();
        String input;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Store Menu: ");
            System.out.println("1. Add a movie to the inventory.");
            System.out.println("2. Remove a movie from the inventory (by sku).");
            System.out.println("3. Display the information for a movie (given the sku).");
            System.out.println("4. Display the inventory in a table.");
            System.out.println("5. Quit.");
            input = s.nextLine();

            switch (input) {
                case "1": // Function call to addMovie
                    inventoryList.add(inv.addMovie());
                    break;

                case "2": // Function call to removeMovie
                    //First check if list is empty.
                    if (inventoryList.isEmpty()){System.out.println(emptyPrompt); break;}

                    System.out.println("Enter SKU of movie to remove: ");
                    int removalCandidate = s.nextInt();
                    inv.removeMovie(inventoryList,removalCandidate);
                    s.nextLine();
                    break;

                case "3": // Function call to displayMovie
                    //Check if list is empty.
                    if (inventoryList.isEmpty()){System.out.println(emptyPrompt); break;}

                    System.out.println("Enter SKU of movie to display: ");
                    int displayCandidate = s.nextInt();
                    inv.displayMovie(inventoryList,displayCandidate);
                    s.nextLine();
                    break;

                case "4": // Function call to printInventoryTable
                    //Check if list is empty.
                    if (inventoryList.isEmpty()){System.out.println(emptyPrompt); break;}

                    inv.displayTable();
                    break;

                case "5":
                    System.out.println("Quitting.");
                    break;

                default: System.out.println("Invalid Input, Pick A Number Between 1 And 5.");
            }
        } while (!input.equals("5")); //
    }
}

