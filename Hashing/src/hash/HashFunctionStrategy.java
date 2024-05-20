package hash;

import java.util.stream.Collectors;

public abstract class HashFunctionStrategy {

    protected static final int MAX_INDEX_SIZE = 50;

    public abstract int hash(String key);

    public String toASCIIValue(String key) {

        String hash = key.chars()
                .map(c -> (int) c) // Convert chars to int (ASCII)
                .mapToObj(i -> String.valueOf(i)) // Convert int to String
                .collect(Collectors.joining()); // Combine Strings

        return hash;
    }
}
