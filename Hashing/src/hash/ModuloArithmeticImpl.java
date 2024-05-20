package hash;

import java.math.BigInteger;

public class ModuloArithmeticImpl extends HashFunctionStrategy {

    @Override
    public int hash(String key) {
        String ASCIIValue = toASCIIValue(key);

        int index = 0;
        try {
            index = Math.toIntExact(Long.parseLong(ASCIIValue) % 47);
        } catch (Exception e) {
            BigInteger bigIntASCIIValue = new BigInteger(ASCIIValue);
            index = bigIntASCIIValue.mod(BigInteger.valueOf(47)).intValue();
        }

        return index;
    }

    @Override
    public String toString() {
        return "Modulo Arithmetic";
    }
}
