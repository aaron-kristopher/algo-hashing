package hash;

public class DigitSelectionImpl extends HashFunctionStrategy {

    @Override
    public int hash(String hashedValue) {
        return Character.getNumericValue(hashedValue.charAt(0));
    }

    @Override
    public String toString() {
        return "Digit Selection";
    }
}
