package gui;

public class Menu {

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

    public static void displayCloseProgram() {
        System.out.println("Closing program...");
    }
}
