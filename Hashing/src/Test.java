import hash.AddAndFold;
import hash.DigitSelection;
import hash.HashFunction;
import hash.Midsquare;
import hash.ModuloArithmetic;

public class Test {

    public static void main(String[] args) {
        String key = "hello";

        // Add & Fold
        AddAndFold addAndFold = new AddAndFold();

        // DigitSelection
        DigitSelection digitSelection = new DigitSelection();

        // Midsquare
        Midsquare midsquare = new Midsquare();

        // ModuloArithmetic
        ModuloArithmetic moduloArithmetic = new ModuloArithmetic();

        HashFunction[] hashFunctions = { addAndFold, digitSelection, midsquare, moduloArithmetic };

        for (HashFunction hashFunction : hashFunctions) {
            System.out.println(hashFunction.getClass().getSimpleName() + ": " + hashFunction.hash(key));
        }
    }
}
