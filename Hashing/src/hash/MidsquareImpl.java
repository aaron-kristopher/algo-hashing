package hash;

public class MidsquareImpl extends HashFunctionStrategy {

    @Override
    public int hash(String ASCIIValue) {
        int mid = Character.getNumericValue(ASCIIValue.charAt(ASCIIValue.length() / 2));
        int midsquare = mid * mid;

        int counter = 0; // Prevent infinite loop
        while (midsquare > MAX_INDEX_SIZE && counter < 3) {
            midsquare = square(midsquare % 10); // Get the rightmost digit and square again
            counter++;
        }

        return midsquare;
    }

    private int square(int mid) {
        return mid * mid;
    }

    @Override
    public String toString() {
        return "MidSquare";
    }
}
