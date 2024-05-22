package hash;

public class DigitSelectionImpl extends HashFunctionStrategy {

    @Override
    public int hash(String ASCIIValue) {
        return Character.getNumericValue(ASCIIValue.charAt(0));
    }

    @Override
    public String toString() {
        return "Digit Selection";
    }
}
