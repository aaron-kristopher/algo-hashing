package hash;

public class AddAndFoldImpl extends HashFunctionStrategy {

    @Override
    public int hash(String key) {
        int sum = 0;
        String ASCIIValue = toASCIIValue(key);

        for (int i = 0; i < ASCIIValue.length(); i++)
            sum += Integer.parseInt(String.valueOf(ASCIIValue.charAt(i)));

        // Choose right digit if index exceeds the maximum index size
        return sum < MAX_INDEX_SIZE ? sum : sum % 10;
    }

}
