/*
 * Class: CMSC203
 * Instructor: Monshi
 * Description: ESPGame that picks a color and the player guesses
 * Due: 02/10/2025
 * Platform/compiler:
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Christopher Andrews
 */
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Random;

public class ESPGame {
    public static void main(String[] args) {

        //Game Variables
        Scanner sc = new Scanner(System.in);
        int correct = 0;
        final int GUESSES = 3;

        //Introduction
        System.out.println("CMSC203 Assignment1: ESP Game\n Welcome to the ESP Game!");

        boolean continueGame;
        do {
            //Option selection
            System.out.println("Please select one of the 4 options from the menu\n");
            System.out.println("1- Use all 16 colors from colors.txt to play the ESP game");
            System.out.println("2- Use the first 10 colors from colors.txt to play the ESP game");
            System.out.println("3- Use the first 5 colors from colors.txt to play the ESP game");
            System.out.println("4- Exit from the game\n");

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            //Get file name and create scanner
            String filename = "";
            Scanner filescanner = null;
            File file = null;
            if (choice != 4) {

                System.out.println("Enter the file name: ");
                filename = sc.nextLine();

                try {
                    file = new File(filename);
                    filescanner = new Scanner(file);
                } catch (FileNotFoundException e) {
                    System.out.println("File not found");
                }
            }

            int colors = 0;
            String number = "";
            switch (choice) {
                case 1:
                    colors = 16;
                    number = "sixteen";
                    break;
                case 2:
                    colors = 10;
                    number = "ten";
                    break;
                case 3:
                    colors = 5;
                    number = "five";
                    break;
            }
            if(choice == 4) {
                break;
                //breaks from game loop to run game over code and result file
            }

            //Print eligible colors
            System.out.println("Here are the " + number + " colors from the file:");
            for (int i = 0; i < colors; i++) {
                if(filescanner.hasNextLine()) {
                    String color = filescanner.nextLine();
                    System.out.println(color);
                }
            }


            //Game Logic(for-loop for 3 rounds)
            for (int i = 1; i <= 3; i++) {
                System.out.println("\nRound " + i + "\n");

                //Pick Random color
                Random rand = new Random();
                int randomColor = rand.nextInt(colors) + 1;
                Scanner colorSelect = null;
                String selectedColor = null;
                try {
                    colorSelect = new Scanner(file);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

                for (int j = 0; j < randomColor; j++) {
                    selectedColor = colorSelect.nextLine();
                }

                //Prompt user for guess
                System.out.println("I am thinking of a color.");
                System.out.println("It is in the list above.");
                System.out.println("Enter your guess: ");
                String guess = sc.nextLine();
                System.out.println("I was thinking of: " + selectedColor);
                if (selectedColor.equals(guess)) {
                    correct++;
                }
            }

            //Game Over
            System.out.println("Game Over");
            System.out.println("\nYou Guessed " + correct + " out of " + GUESSES + " colors correctly.\n");
            System.out.println("Would You like to continue? Type Yes/No");
            String yesno = sc.nextLine();
            if (yesno.equals("Yes")) {
                continueGame = true;
            } else {
                continueGame = false;
            }
        }while(continueGame);

        //Player info/Game over
        System.out.println("\nEnter your name: ");
        String name = sc.nextLine();

        System.out.println("Describe yourself: ");
        String description = sc.nextLine();

        System.out.println("Due Date: ");
        String dueDate = sc.nextLine();

        System.out.println("Username: " + name);
        System.out.println("Description: " + description);
        System.out.println("Due Date: " + dueDate);

        //Create Scanner and FileWriter for ESPGame Results file
        File output = new File("ESPGameResults.txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(output);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nPrinting results to ESPGameResults.txt");

        //ESP game results file
        pw.println("Game Over");
        pw.println("You Guessed " + correct + " out of " + GUESSES + " colors correctly.");
        pw.println("Name: " + name);
        pw.println("Description: " + description);
        pw.println("Due Date: " + dueDate);
        pw.close();
        System.exit(0);
    }
}