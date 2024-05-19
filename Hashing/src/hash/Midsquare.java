package hash;

public class Midsquare extends HashFunction {

    @Override
    public int hash(String key) {
        String ASCIIValue = toASCIIValue(key);
        int mid = Character.getNumericValue(ASCIIValue.charAt(ASCIIValue.length() / 2));
        int midsquare = mid * mid;

        return midsquare < 50 ? midsquare : midsquare % 10;
    }
}
