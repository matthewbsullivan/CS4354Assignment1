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
        inv.loadFromFile(); //load a saved ArrayList<Product> to inv
                            // from file "Inventory"
        Scanner s = new Scanner(System.in);
        int input = 0;
        do {
            inv.MenuOptions();  //displays menu options from 1-to-5

            input = s.nextInt();
            switch (input) {
                case 1:
                    char mbt; //m/M for movie, b/B for book, t/T for toy
                    inv.ChoiceOptions();    //display the options of m b or t
                    mbt = s.next().charAt(0);
                    switch (mbt) {
                        case 'M':
                        case 'm':
                            inv.addItemToArray('M');
                            break;
                        case 'B':
                        case 'b':
                            inv.addItemToArray('B');
                            break;
                        case 'T':
                        case 't':
                            inv.addItemToArray('T');
                            break;
                        default: System.out.println("No valid input detected," +
                                " returning to Main Menu: ");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Enter SKU of movie to remove: ");
                    int removalCandidate = s.nextInt();
                    inv.removeMovie(removalCandidate); //checks Inventory for a
                            // SKU match and removes the matching movie if found
                    s.nextLine();
                    break;
                case 3:
                    System.out.println("Enter SKU of movie to display: ");
                    int displayCandidate = s.nextInt();
                    inv.displayMovie(displayCandidate); //checks Inventory for
                        // a SKU match and displays the matching movie if found
                    s.nextLine();
                    break;
                case 4:
                    inv.displayInventory(); //displays entire contents
                                            // of Inventory
                    break;
                case 5:
                    System.out.println("Quitting.");
                    break;
                default: System.out.println("Invalid Input, Pick A Number " +
                                            "Between 1 And 5.");
                    break;
            }
        } while (input != 5); //

        inv.saveToFile(); //save inv to file for later use
    }


}

