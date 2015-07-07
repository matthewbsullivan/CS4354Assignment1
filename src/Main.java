import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Store Menu: ");
        System.out.println("1. Add a movie to the inventory.");
        System.out.println("2. Remove a movie from the inventory (by sku).");
        System.out.println("3. Display the information for a movie (given the sku).");
        System.out.println("4. Display the inventory in a table.");
        System.out.println("5. Quit.");

        String input = null;
        Scanner s = new Scanner(System.in);
        do {
            input = s.nextLine();
            switch (input) {
                case "1": // Function call to addMovie
                    System.out.println("Not yet implemented. Returning to Main Menu.");
                    break;
                case "2": // Function call to removeMovie
                    System.out.println("Not yet implemented. Returning to Main Menu.");
                    break;
                case "3": // Function call to displayMovie
                    System.out.println("Not yet implemented. Returning to Main Menu.");
                    break;
                case "4": // Function call to printInventoryTable
                    System.out.println("Not yet implemented. Returning to Main Menu.");
                    break;
                case "5":
                    System.out.println("Quitting.");
                    break;
                default: System.out.println("Invalid Input, Pick A Number Between 1 And 5.");
            }
        } while (!input.equals("5")); //
    }
}
