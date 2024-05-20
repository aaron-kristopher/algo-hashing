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

        int rerun = 1;

        while (rerun == 1) {
            Menu.displayHashingMenu();
            int hashFunctionOption = Input.getHashFunction(4);

            Menu.displayCollisionResolutionMenu();
            int collisionResolutionOption = Input.getCollisionResolution(3);

            DataTableStrategy table = createTable(createHashFunction(hashFunctionOption),
                    createCollisionResolution(collisionResolutionOption));

            int wordCount = Input.getWordCount(table.length());
            String[] words = Input.getWords(wordCount);

            for (String word : words)
                table.put(word);

            System.out.println(table);

            rerun = Input.getRerun();
        }

        Menu.displayCloseProgram();
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
}
