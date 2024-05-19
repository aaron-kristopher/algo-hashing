package hash;

public class ModuloArithmeticImpl extends HashFunctionStrategy {

    @Override
    public int hash(String key) {
        String ASCIIValue = toASCIIValue(key);
        return Math.toIntExact(Long.parseLong(ASCIIValue) % 47);
    }
}
