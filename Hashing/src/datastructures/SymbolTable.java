package datastructures;

public class SymbolTable {

    private String[] table = new String[50];

    public void put(String key, int index) {
        table[index] = key;
    }

    public String get(int index) {
        return table[index];
    }
}
