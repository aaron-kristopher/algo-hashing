package hash;

public class DigitSelectionImpl extends HashFunctionStrategy {

    @Override
    public int hash(String key) {
        return Character.getNumericValue(toASCIIValue(key).charAt(0));
    }

    @Override
    public String toString() {
        return "Digit Selection";
    }
}
