package hash;

public class ModuloArithmetic extends HashFunction {

    @Override
    public int hash(String key) {
        String ASCIIValue = toASCIIValue(key);
        return Math.toIntExact(Long.parseLong(ASCIIValue) % 47);
    }
}
