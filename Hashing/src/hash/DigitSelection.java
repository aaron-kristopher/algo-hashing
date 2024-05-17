package hash;

public class DigitSelection extends HashFunction {

    @Override
    public int hash(String key) {
        return toASCIIValue(key).charAt(0);
    }

}
