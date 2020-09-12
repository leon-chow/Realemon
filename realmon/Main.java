package realmon;

import java.util.*;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Main menu options
        System.out.println("Welcome to Realmon! Please type in a number for one " + 
        "of the following options! \n 1. New Game \n 2. Load Game" +
        "\n 3. Exit");
        
        // Main Menu Scanner
        Scanner menuScanner = new Scanner(System.in); 

        while (true) {
            String choice = menuScanner.nextLine();  
            
            // ***Option 1 - NEW GAME***    
            if (Integer.parseInt(choice.trim()) == 1) {
                Scanner newGameScanner = new Scanner(System.in);
                System.out.println("Please enter your name (No more than 10 characters)");
                String name = newGameScanner.nextLine();
                // check to see if name is too long, TODO: change break with while loop
                if (name.length() > 10) {
                    System.out.println("Name is too large! Try again!");
                    break;
                }

                System.out.println("Please enter the number for your starting job. \n Starting jobs: \n");
                
                // reading the jobs text file here and displaying it to the user
                try {
                    File startingJobs = new File("Jobs.txt");
                    Scanner jobsReader = new Scanner(startingJobs);
                    while (jobsReader.hasNextLine()) {
                      String data = jobsReader.nextLine();
                      System.out.println(data);
                    }
                } catch (IOException e) {
                    System.out.println("An error has occured");
                }
                
                // get the user input for the job they pick
                String job = newGameScanner.nextLine();

                try {
                    // writing to the characters txt file
                    File charactersFile = new File("Characters.txt");
                    charactersFile.createNewFile();
                    
                    File stats = new File("Job Stats.txt");
                    Scanner statsReader = new Scanner(stats);

                    while(statsReader.hasNextLine()) {
                        try {
                            String jobStats = statsReader.nextLine();
                            if(jobStats.contains("00" + job)) {
                                FileWriter characterWriter = new FileWriter("Saves/" + name + ".txt", false);
                                characterWriter.write(name + "\t \t \t" + jobStats + "\t0\tPRO");
                                characterWriter.close();
                            }
                        } catch (IOException e) {
                            System.out.println("Job not found!");
                            System.exit(1);
                        }
                    }
                    
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            // initializing new objects
            Story story = new Story();
            Combat combat = new Combat();

            //String currentAct = story.getActName();
            while (story.getActName() != "END") {
                Character player = new Character();
                Character enemy = new Character();
                combat.initiateCombat(story.getActName());
                combat.setPlayer(name);
                combat.setEnemy(story.getActName());
                combat.startCombat();
            }

            // ***Option 3 - DELETE A GAME***   
            /*} else if (Integer.parseInt(choice.trim()) == 3) {
                // TODO: print the characters.txt file and take deleted file user input
                System.out.println("Choose a file to delete.");*/
            // ***OPTION 4 - EXIT***
            } else if (Integer.parseInt(choice.trim()) == 3) {
                System.out.println("Thank you for playing!");
                System.exit(1);
            } else {
                System.out.println("Error: Invalid number!");
                // repeat main menu if the user enters an invalid number
                System.out.println("Back to main menu: \n1. New Game\n2. Load Game\n3. Quit");
            }
            // TODO: Add Try and Catch block after
        }
    }
}