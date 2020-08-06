package realemon;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Real-e-mon! Please type in a number for one " + 
        "of the following options! \n 1. Load a character. \n 2. Create a new character." +
        "\n 3. Delete a character. \n 4. Exit");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        String choice = myObj.nextLine();  // Read user input
        
        while (true) {
            if (Integer.parseInt(choice.trim()) == 1) {
                System.out.println("Choose a character to load.");
            } else if (Integer.parseInt(choice.trim()) == 2) {
                System.out.println("Creating a new character...");
            } else if (Integer.parseInt(choice.trim()) == 3) {
                System.out.println("Choose a character to delete.");
            } else if (Integer.parseInt(choice.trim()) == 4) {
                System.out.println("Goodbye...");
                System.exit(1);
            } else {
                System.out.println("Invalid option. ");
                choice = myObj.nextLine();
            }
        }
    }
}