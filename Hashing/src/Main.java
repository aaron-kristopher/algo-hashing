import collision.BucketChainingImpl;
import collision.CollisionResolutionStrategy;
import collision.LinearProbingImpl;
import collision.SecondHashFunctionImpl;
import datastructures.BucketTableImpl;
import datastructures.DataTableStrategy;
import datastructures.StringTableImpl;
import gui.Menu;
import hash.AddAndFoldImpl;
import hash.DigitSelectionImpl;
import hash.HashFunctionStrategy;
import hash.MidsquareImpl;
import hash.ModuloArithmeticImpl;
import util.Input;

public class Main {

    public static void main(String[] args) {

        run();

        // Display the close program screen
        Menu.clearScreen();
        Menu.displayCloseProgram();
    }

    private static void run() {

        // Display the home screen
        Menu.clearScreen();
        Menu.displayHome();
        Input.flush();
        Menu.clearScreen();

        // Display the hashing menu
        Menu.displayHashingMenu();
        int hashFunctionOption = Input.getHashFunction(4);
        Menu.clearScreen();

        // Display the collision resolution menu
        Menu.displayCollisionResolutionMenu();
        int collisionResolutionOption = Input.getCollisionResolution(3);
        Menu.clearScreen();

        // Create the hash table
        DataTableStrategy table = createTable(createHashFunction(hashFunctionOption),
                createCollisionResolution(collisionResolutionOption));

        // Get the words from the user

        int wordCount = Input.getWordCount(table.length());
        populateTable(table, wordCount);

        // Put the words in the table
        Menu.clearScreen();

        // Display the hash table
        Menu.displayStrategy(table.getHashFunctionStrategy(), table.getCollisionResolutionStrategy());
        Menu.displayTable(table);

        int rerun = 1;
        rerun = Input.getRerun();
        if (rerun == 1)
            run();
    }

    private static DataTableStrategy createTable(HashFunctionStrategy hashFunction,
            CollisionResolutionStrategy collisionResolution) {

        return collisionResolution instanceof BucketChainingImpl
                ? new BucketTableImpl(hashFunction, collisionResolution)
                : new StringTableImpl(hashFunction, collisionResolution);
    }

    private static HashFunctionStrategy createHashFunction(int option) {
        return switch (option) {
            case 1 -> new AddAndFoldImpl();
            case 2 -> new DigitSelectionImpl();
            case 3 -> new MidsquareImpl();
            case 4 -> new ModuloArithmeticImpl();
            default -> null;
        };
    }

    private static CollisionResolutionStrategy createCollisionResolution(int option) {
        return switch (option) {
            case 1 -> new BucketChainingImpl();
            case 2 -> new LinearProbingImpl();
            case 3 -> new SecondHashFunctionImpl();
            default -> null;
        };
    }

    private static void populateTable(DataTableStrategy table, int wordCount) {
        int itr = 0;
        while (wordCount > 0) {
            table.put(Input.getWords(itr++));
            wordCount--;
        }
    }
}
