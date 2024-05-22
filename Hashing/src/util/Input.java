package util;

import java.util.Scanner;

public class Input {

    static Scanner scanner = new Scanner(System.in);

    public static int getHashFunction(int MAX_HASH_FUNCTIONS_AVAILABLE) {
        int choice = -1;

        while (choice < 0 || choice > MAX_HASH_FUNCTIONS_AVAILABLE) {
            System.out.print("Choose a hash function: ");

            try {
                choice = scanner.nextInt();
                if (choice < 0 || choice > MAX_HASH_FUNCTIONS_AVAILABLE) {
                    System.out.println("\nInvalid choice. Please try again.\n");
                }

            } catch (Exception e) {
                System.out.println("\nInvalid input. Please enter a number.\n");
                scanner.nextLine();
            }
        }

        return choice;
    }

    public static int getCollisionResolution(int MAX_COLLISION_RESOLUTIONS_AVAILABLE) {
        int choice = -1;

        while (choice < 0 || choice > MAX_COLLISION_RESOLUTIONS_AVAILABLE) {
            System.out.print("Choose a collision resolution strategy: ");

            try {
                choice = scanner.nextInt();
                if (choice < 0 || choice > MAX_COLLISION_RESOLUTIONS_AVAILABLE) {
                    System.out.println("\nInvalid choice. Please try again.\n");
                }

            } catch (Exception e) {
                System.out.println("\nInvalid input. Please enter a number.\n");
                scanner.nextLine();
            }
        }

        return choice;
    }

    public static int getWordCount(int MAX_TABLE_SIZE) {
        int choice = -1;

        while (choice < 0 || choice > MAX_TABLE_SIZE) {
            System.out.print("How many words do you want: ");

            try {
                choice = scanner.nextInt();
                if (choice < 0 || choice > MAX_TABLE_SIZE) {
                    System.out.printf("\n\nInvalid choice (Must be within 1 - %s). Please try again.\n",
                            MAX_TABLE_SIZE + 1);
                }

            } catch (Exception e) {
                System.out.println("\nInvalid input. Please enter a number.\n");
                scanner.nextLine();
            }
        }

        scanner.nextLine();

        return choice;

    }

    public static String getWords(int itr) {
        while (true) {
            System.out.printf("Enter word %s: ", (itr + 1));
            String word = scanner.nextLine();
            if (word.isEmpty() || word.isBlank()) {
                System.out.println("\nInvalid input. Please enter a word!\n");
            } else {
                return word;
            }
        }

    }

    public static int getRerun() {
        int choice = -1;

        while (choice < 0 || choice > 1) {
            System.out.print("Would you like to run the program again? (1: Yes, 0: No): ");

            try {
                choice = scanner.nextInt();
                if (choice < 0 || choice > 1) {
                    System.out.println("\nInvalid choice. Please try again.");
                }

            } catch (Exception e) {
                System.out.println("\nInvalid input. Please enter a number.\n");
                scanner.nextLine();
            }
        }

        return choice;
    }

    public static void flush() {
        scanner.nextLine();
    }
}
