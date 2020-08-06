package realemon;

import java.util.*;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Real-e-mon! Please type in a number for one " + 
        "of the following options! \n 1. Load a character. \n 2. Create a new character." +
        "\n 3. Delete a character. \n 4. Exit");
        
        Scanner menuScanner = new Scanner(System.in);  // Create a Scanner object

        String choice = menuScanner.nextLine();  // Read user input
        while (true) {
            if (Integer.parseInt(choice.trim()) == 1) {
                System.out.println("Choose a character to load.");
            } else if (Integer.parseInt(choice.trim()) == 2) {
                System.out.println("Please enter your name");
                String name = menuScanner.nextLine();
                System.out.println("Please enter the number for your starting job \n " + 
                "1. Farmer \n 2. Taxi Driver \n 3. Cashier \n 4. Burger Flipper \n 5. Server \n " +
                "6. Babysitter \n 7. Janitor \n 8. Ticketer");
                String job = menuScanner.nextLine();
                while (true) {
                    if (Integer.parseInt(job.trim()) < 1 && Integer.parseInt(job.trim()) > 8) {
                        System.out.println("Error: Invalid number!");
                    } else {
                        break;
                    }
                }
                try {
                    File charactersFile = new File("Characters.txt");
                    charactersFile.createNewFile();
                    FileWriter myWriter = new FileWriter("Characters.txt", true);
                    myWriter.write(name + "\t" + job + "\t" + "50 \t 25 \t 5 \t 5 \t 5 \t 5 \n");
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                break;
            } else if (Integer.parseInt(choice.trim()) == 3) {
                System.out.println("Choose a character to delete.");
            } else if (Integer.parseInt(choice.trim()) == 4) {
                System.out.println("Goodbye...");
                System.exit(1);
            } 
            // TODO: Add Try and Catch block after
            System.out.println("Error: Invalid number!");
            choice = menuScanner.nextLine();
        }
    }
}