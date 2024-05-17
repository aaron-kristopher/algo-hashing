package hash;

import java.util.stream.Collectors;

public abstract class HashFunction {

    public String hash(String key) {

        String hash = key.chars()
                .map(c -> (int) c) // Convert chars to int (ASCII)
                .mapToObj(i -> String.valueOf(i)) // Convert int to String
                .collect(Collectors.joining()); // Combine Strings

        return hash;
    }
}
