package hash;

public class Midsquare extends HashFunction {

    @Override
    public int hash(String key) {
        String ASCIIValue = toASCIIValue(key);
        return Character.getNumericValue(ASCIIValue.charAt(ASCIIValue.length() / 2));
    }
}
