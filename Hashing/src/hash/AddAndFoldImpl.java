package hash;

public class AddAndFoldImpl extends HashFunctionStrategy {

    @Override
    public int hash(String ASCIIValue) {
        int sum = add(ASCIIValue);

        while (sum > MAX_INDEX_SIZE)
            sum = add(Integer.toString(sum));

        // Choose right digit if index exceeds the maximum index size
        return sum;
    }

    private int add(String ASCIIValue) {
        int sum = 0;

        for (int i = 0; i < ASCIIValue.length(); i++)
            sum += Integer.parseInt(String.valueOf(ASCIIValue.charAt(i)));

        return sum;
    }

    @Override
    public String toString() {
        return "Add and Fold";
    }
}
