package datastructures;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SymbolTable {

    private String[] table = new String[50];

    public static void main(String[] args) {

    }

    public String hash(String key) {

        String hash = key.chars()
                .map(c -> (int) c) // Convert chars to int (ASCII)
                .mapToObj(i -> String.valueOf(i)) // Convert int to String
                .collect(Collectors.joining()); // Combine Strings

        return hash;
    }
}
