package hash;

public class AddAndFoldImpl extends HashFunctionStrategy {

    @Override
    public int hash(String key) {
        int sum = 0;
        String ASCIIValue = toASCIIValue(key);

        for (int i = 0; i < ASCIIValue.length(); i++)
            sum += Integer.parseInt(String.valueOf(ASCIIValue.charAt(i)));

        return sum;
    }

}
