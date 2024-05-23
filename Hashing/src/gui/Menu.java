package gui;

import datastructures.DataTableStrategy;

public class Menu {

    public static void displayHome() {
        System.out.println(
                """
                        ╔════════════─┉┈◈◉◈┈┉════════════════─┉┈◈◉◈┈┉═════════════ ≪ °❈° ≫ ═══════════════─┉┈◈◉◈┈┉════════════════─┉┈◈◉◈┈┉═════════════╗

                            ██╗  ██╗ █████╗ ███████╗██╗  ██╗██╗███╗   ██╗ ██████╗     ██████╗ ██████╗  ██████╗  ██████╗ ██████╗  █████╗ ███╗   ███╗██╗
                            ██║  ██║██╔══██╗██╔════╝██║  ██║██║████╗  ██║██╔════╝     ██╔══██╗██╔══██╗██╔═══██╗██╔════╝ ██╔══██╗██╔══██╗████╗ ████║██║
                            ███████║███████║███████╗███████║██║██╔██╗ ██║██║  ███╗    ██████╔╝██████╔╝██║   ██║██║  ███╗██████╔╝███████║██╔████╔██║██║
                            ██╔══██║██╔══██║╚════██║██╔══██║██║██║╚██╗██║██║   ██║    ██╔═══╝ ██╔══██╗██║   ██║██║   ██║██╔══██╗██╔══██║██║╚██╔╝██║╚═╝
                            ██║  ██║██║  ██║███████║██║  ██║██║██║ ╚████║╚██████╔╝    ██║     ██║  ██║╚██████╔╝╚██████╔╝██║  ██║██║  ██║██║ ╚═╝ ██║██╗
                            ╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝ ╚═════╝     ╚═╝     ╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝     ╚═╝╚═╝

                        ╚════════════─┉┈◈◉◈┈┉════════════════─┉┈◈◉◈┈┉═════════════ ≪ °❈° ≫ ═══════════════─┉┈◈◉◈┈┉════════════════─┉┈◈◉◈┈┉═════════════╝
                                            """);

        System.out.println("WELCOME TO THE HASHING PROGRAM!");
        System.out.println();
        System.out.println("Introduction:");
        System.out.println();
        System.out.println("This program will create a hash table based on the options you choose.");
        System.out.println("You will be asked to enter a number of words, and then the words themselves.");
        System.out.println("The program will then display the hash table.");
        System.out.println("Let's get started!");
        System.out.println();
        System.out.print("(Press enter to continue...) ");
    }

    public static void displayHashingMenu() {
        System.out.println();
        System.out.println("HASH FUNCTION MENU ");
        System.out.println();
        System.out.println("1. Add and Fold");
        System.out.println("2. Digit Selection");
        System.out.println("3. Midsquare");
        System.out.println("4. Modulo Arithmetic");
        System.out.println();
    }

    public static void displayCollisionResolutionMenu() {
        System.out.println();
        System.out.println("COLLISION RESOLUTION MENU:");
        System.out.println();
        System.out.println("1. Bucket Chaining");
        System.out.println("2. Linear Probing");
        System.out.println("3. Second Hash Function");
        System.out.println();
    }

    public static void displayStrategy(String hashFunction, String collisionResolution) {
        System.out.println();
        System.out.printf("HASH FUNCTION: %s\t\tCOLLISION RESOLUTION: %s", hashFunction, collisionResolution);
        System.out.println();
        System.out.println();
    }

    public static void displayCloseProgram() {
        System.out.println();
        System.out.println("Closing Program...");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void displayTable(DataTableStrategy table) {

        if (table.getCollisionResolutionStrategy().equals("Bucket Chaining"))
            displayBucket(table);
        else
            displayString(table);

    }

    private static void displayString(DataTableStrategy table) {
        int longestWordLength = table.getLongestWordLength();
        String bar = "-".repeat(longestWordLength);
        String segment = String.format("+------+---%s---", bar);
        String header = segment.repeat(5) + "+";
        int indexCount = 0;

        String[] indexDisplay = new String[5];
        String[] wordDisplay = new String[5];

        for (int i = 0; i < table.length() / 5; i++) {
            System.out.println(header);
            String word = "";
            String padding = "";

            indexCount = i;
            for (int j = 0; j < 5; j++) {
                indexDisplay[j] = indexCount < 10 ? String.format("|   %d  |", indexCount)
                        : String.format("|  %d  |", indexCount);
                indexCount += table.length() / 5;
            }

            String formatWord = "";
            indexCount = i;
            for (int k = 0; k < 5; k++) {
                word = table.get(indexCount) != null ? table.get(indexCount) : " ";
                padding = createPadding(word, longestWordLength);

                formatWord = String.format("%s%s%s%s", padding, word, padding,
                        (longestWordLength % 2 == 0) ? ((word.length() % 2 == 1) ? " " : "")
                                : word.length() % 2 == 0 ? " " : "");

                if (k == 4)
                    formatWord += "|";
                wordDisplay[k] = formatWord;
                indexCount += table.length() / 5;
            }

            for (int l = 0; l < 5; l++) {
                System.out.printf("%s%s", indexDisplay[l], wordDisplay[l]);
            }

            System.out.println();
        }
        System.out.println(header);
        System.out.println();
    }

    private static String createPadding(String word, int longestWordLength) {
        return " ".repeat(((longestWordLength - word.length()) / 2) + 3);
    }

    private static void displayBucket(DataTableStrategy table) {
        System.out.println(table);
    }

}
