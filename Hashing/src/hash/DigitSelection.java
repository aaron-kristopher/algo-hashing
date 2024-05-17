package hash;

public class DigitSelection extends HashFunction {

    @Override
    public int hash(String key) {
        return Character.getNumericValue(toASCIIValue(key).charAt(0));
    }
}
