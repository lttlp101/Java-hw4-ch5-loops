
//
// ------------------------------------------
/*
    @brief This Program:
    This Java program to display a menu of 3 options/parts.
    Option 1 processes travel distance data.
    Option 2 calculates tuition over several years.
    Option 0 is used to exit the program.
    Any other option should result in asking again.
    Use a continuous loop allowing the user to select from the list of options.
    ----------------------------
    Extra: Option 5
    Exercise 5.15 on the Textbook
    Display the ASCII character table.
    Write a program that prints the characters in the ASCII character table
    from ! to ~. Display 10 characters per line. The ASCII table is given in Appendix B.
    Characters are separated by exactly one space.
 */
//
// ------------------------------------------
//
//
//


import java.util.Scanner;

@SuppressWarnings("java:S106") // Disable the warning about System.out from SonarLint

public class CIT130hw4ch5 {
    public static void main(String[] args) {
        System.out.println("\nAssignment 4 ");

        // Create the Input Object and Initiate the Variable
        Scanner inputs = new Scanner(System.in);
        int menuOption;

        // Call the optionMenu Method to Display the Menu
        optionMenu();

        // Menu Option Input
        menuOption = inputs.nextInt();
        // While Loop for Menu Option Not O
        while (menuOption != 0) {
            // Option 1, Call for the Calculate Distance Method
            if (menuOption == 1) {
                calDistance();
            }

            // Option 2, Call for Calculate College Tuition Method
            else if (menuOption == 2) {
                calCollegeTuition();
            }

            // Extra Option 5, Call for the Exercise 5.15 Method
            else if (menuOption == 5) {
                exercise515();
            }

            // When Option Not 1, 2 and 5 and not 0, Prompt Enter Again
            else {
                System.out.println("Invalid Entry - Please Enter Again!");
            }

            // Call for the optionMenu to Display the Menu and Get the Input again
            optionMenu();
            menuOption = inputs.nextInt();

        }

    } // main

    // Methods / Functions

    // Display the Option Menu Method
    public static void optionMenu() {
        System.out.println("\n=========================================");
        System.out.println("Options Menu: ");
        System.out.println("Enter 1 to Calculate Distance. ");
        System.out.println("Enter 2 to Calculate College Tuition. ");
        System.out.println("Enter 0 to End the program. ");
        System.out.println("-----------------------------------------");
        System.out.println("Extra: Enter 5 to perform Exercise 5.15");
        System.out.println("        A ASCII character table program. ");
        System.out.println("=========================================\n");
    }

    // Calculate Distance Method
    public static void calDistance() {
        System.out.println("\n-- Calculate Distance --");
        System.out.println("CARS!!! \n");

        // Create the Input Object and Initiate the Variable
        Scanner inputs = new Scanner(System.in);
        double distance;

        // Prompt and Get the Input for Speed
        System.out.println("How fast is the car going? (must be between 1mph to 120mph) ");
        double speed = inputs.nextDouble();

        // Validate the Speed Input Between 1 and 120
        // Using the Example Code Idea for Comparing Floating number
        while (speed <= 0.99999999999 || speed > 120.00000000001) {
            System.out.println("Invalid Entry! Speed must be between 1mph to 120mph: ");
            speed = inputs.nextDouble();
        }

        // Prompt and Get the Input for Hour
        System.out.println("How many hours is it traveling? ");
        int hour = inputs.nextInt();

        // Validate the Hour Input
        while (hour <= 0) {
            System.out.println("Invalid hours entry!! Enter again! ");
            hour = inputs.nextInt();
        }

        // Display the Table Header Tabs
        System.out.printf("%n%26s%n", "--------------------------");
        System.out.printf("%2s%5s\t%12s\t%n", " ", "Hour:", "Distance:");

        // For Loop Literal for Calculating and Displaying the results
        for (int time = 1; time <= hour; time++) {
            distance = speed * time;
            System.out.printf("%3s\t%d\t%3s%.2f miles %n", " ", time, " ", distance);
        }
        System.out.printf("%26s%n", "--------------------------");

    }

    // Calculate College Tuition Method
    public static void calCollegeTuition() {
        System.out.println("\n-- Calculate College Tuition --");
        System.out.println("Going to College!! \n");

        // Create the Input Object and Initiate the Variable
        Scanner inputs = new Scanner(System.in);
        double tuitionAfterIncreased;

        // Prompt and Get the Input for College Tuition
        System.out.println("How much is your college tuition? ");
        double tuition = inputs.nextDouble();

        // Validate the Tuition Input Over 0
        // Using the Example Code Idea for Comparing Floating number
        while (tuition <= 0.00000000001) {
            System.out.println("Invalid tuition entry!! Enter again! ");
            tuition = inputs.nextDouble();
        }

        // Prompt and Get the Input for Increased Percentage
        System.out.println("How many percent does it increase every year? ");
        int percentage = inputs.nextInt();

        // Validate the Percentage Over 0
        while (percentage <= 0) {
            System.out.println("Invalid percentage entry!! Enter again! ");
            percentage = inputs.nextInt();
        }

        // Prompt and Get the Input for
        System.out.println("How many years are you going to college? ");
        int years = inputs.nextInt();

        // Validate the Years Over 1
        while (years < 1) {
            System.out.println("Invalid years entry!! Enter again! ");
            years = inputs.nextInt();
        }

        // Display the Table Header Tabs
        System.out.printf("%n%32s%n", "--------------------------------");
        System.out.printf("%2s%5s\t%12s\t%n", " ", "Year:", "Tuition:");

        // For Loop Literal for Calculating and Displaying the results
        tuitionAfterIncreased = tuition;
        for (int year = 1; year < (years + 1); year++) {
            // 1st Year
            if (year == 1) {
                System.out.printf("%3s\t%d\t%4s$%.2f dollars %n", " ", year, " ", tuitionAfterIncreased);
            }

            // After 1st Year
            else {
                tuitionAfterIncreased *= (1 + percentage / 100.0);
                System.out.printf("%3s\t%d\t%4s$%.2f dollars %n", " ", year, " ", tuitionAfterIncreased);
            }
        }
        System.out.printf("%32s%n", "--------------------------------");

    }

    // Exercise 5.15 on the Textbook, Display ASCII table
    public static void exercise515() {
        System.out.println("\n-- Exercise 5.15 the ASCII character table program --");
        System.out.println("Display the ASCII table from ! to ~ \n");

        // Header
        System.out.printf("%31s%n", "-------------------------------");
        System.out.printf("%-31s%n", "  The ASCII Table From ! To ~");
        System.out.printf("%31s%n", "-------------------------------");

        // Initiate Variables
        int asciiBeginChar = 33; // character ! decimal number 33
        int asciiEndChar = 126; // character ~ decimal number 126
        int columnNum = 10; // Display 10 characters in a line
        int rowNum = (asciiEndChar - asciiBeginChar) / 10 + 1; // Calculate the row

        // Nest For Loops for Displaying Tabular Format Table of ASCII table
        for (int row = 0; row < rowNum; row++) {
            System.out.print("\t ");
            for (int col = 0; col < columnNum; col++) {
                // Start From !
                int character = asciiBeginChar;

                // When After Reached the ~ , Exit the Loop
                if (character > asciiEndChar) {
                    break;
                }

                System.out.print((char)character + " "); // Characters are separated by exactly one space
                asciiBeginChar++;
            }
            System.out.print("\n");
        }
        System.out.printf("%31s%n", "-------------------------------");
        System.out.println("\n");
    }

}
