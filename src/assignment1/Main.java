package assignment1;
import java.util.Scanner;

public class  Main {

    /**
     * @author Matt Sullivan
     * @author Luis Rocha
     * A menu for a movie store inventory. Users can add, remove, or view
     * a movie's entry in the inventory, as well as view a list of the
     * inventory's contents.
     * @param args: takes input from keyboard for Scanner
     */
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.loadFromFile(); //load a saved ArrayList<Product> to inv
                            // from file "Inventory"
        String input;
        Scanner s = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println("Store Menu: ");
            System.out.println("1. Add an item to the inventory.");
            System.out.println("2. Remove an item from the inventory " +
                                "(by sku).");
            System.out.println("3. Display the information for an item " +
                                "(given the sku).");
            System.out.println("4. Display the inventory in a table.");
            System.out.println("5. Process a sale.");
            System.out.println("6. Quit.");
            input = s.nextLine();

            switch (input) {
                case "1":
                    int sku;
                    int qty;
                    double price;
                    String title;
                    char mbt; //m/M for movie, b/B for book, t/T for toy
                    System.out.print("Enter the character that corresponds to" +
                            " the item you want to add:\n" +
                            "'M' for Movie\n" +
                            "'B' for Book\n" +
                            "'T' for Toy\nEnter your choice:");
                    mbt = s.next().trim().charAt(0);
                    switch (mbt) {
                        case 'M':
                        case 'm':
                            int upc;
                            sku = inputSKU(s);
                            qty = inputQTY(s);
                            price = inputPrice(s);
                            title = inputTitle(s);
                            System.out.println("Enter movie UPC: ");
                            upc = s.nextInt();
                            inv.addMovie(sku, qty, price, title, upc);
                            break;
                        case 'B':
                        case 'b':
                            int isbn;
                            String author;
                            sku = inputSKU(s);
                            qty = inputQTY(s);
                            price = inputPrice(s);
                            title = inputTitle(s);
                            System.out.println("Enter book ISBN: ");
                            isbn = s.nextInt();
                            s.nextLine();
                            System.out.println("Enter book author: ");
                            author = s.nextLine();
                            inv.addBook(sku, qty, price, title, isbn, author);
                            break;
                        case 'T':
                        case 't':
                            double weight;
                            sku = inputSKU(s);
                            qty = inputQTY(s);
                            price = inputPrice(s);
                            title = inputTitle(s);
                            System.out.println("Enter toy weight (in ounces):");
                            weight = s.nextDouble();
                            inv.addToy(sku, qty, price, title, weight);
                            break;
                        default: System.out.println("No valid input detected," +
                                " returning to Main Menu: ");
                    }
                    break;
                case "2":
                    System.out.println("Enter SKU of item to remove: ");
                    int removalCandidate = s.nextInt();
                    inv.removeProduct(removalCandidate);//checks Inventory for a
                            // SKU match and removes the matching item if found
                    s.nextLine();
                    break;
                case "3":
                    System.out.println("Enter SKU of item to display: ");
                    int displayCandidate = s.nextInt();
                    inv.displayProduct(displayCandidate);//checks Inventory for
                        // a SKU match and displays the matching item if found
                    s.nextLine();
                    break;
                case "4":
                    inv.displayInventory(); //displays entire contents
                                            // of Inventory
                    break;
                case "5":
                    sku = inputSKU(s);
                    System.out.println("Enter quantity sold: ");
                    int qtySold = s.nextInt();
                    System.out.println("Enter shipping cost: ");
                    double shipCost = s.nextDouble();
                    inv.processSale(sku, qtySold, shipCost);
                    s.nextLine();
                    break;
                case "6":
                    System.out.println("Quitting.");
                    break;
                default: System.out.println("Invalid Input, Pick A Number " +
                                            "Between 1 And 6.");
            }
        } while (!input.equals("6")); //

        inv.saveToFile(); //save inv to file for later use
    }

    /**
     *
     * @param s
     * @return
     */
    public static int inputSKU(Scanner s) {
        System.out.println("Enter SKU (integer, must be unique): ");
        return s.nextInt(); //Uniqueness checked in Inventory.addProduct
    }

    /**
     *
     * @param s
     * @return
     */
    public static int inputQTY(Scanner s) {
        System.out.println("Enter quantity available (cannot be a negative " +
                "number): ");
        return s.nextInt();
    }

    /**
     *
     * @param s
     * @return
     */
    public static double inputPrice(Scanner s) {
        System.out.println("Enter item price (e.g. 17.99): ");
        return s.nextDouble();
    }

    /**
     *
     * @param s
     * @return
     */
    public static String inputTitle(Scanner s) {
        s.nextLine();
        System.out.println("Enter item title: ");
        return s.nextLine();
    }
}

