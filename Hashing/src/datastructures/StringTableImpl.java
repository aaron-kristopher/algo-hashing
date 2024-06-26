package datastructures;

import collision.CollisionResolutionStrategy;
import hash.HashFunctionStrategy;

public class StringTableImpl extends DataTableStrategy {

    private String[] table = new String[50];
    private int longestWordLength = 0;

    public StringTableImpl(HashFunctionStrategy hashFunction, CollisionResolutionStrategy collisionResolution) {
        super(hashFunction, collisionResolution);
    }

    @Override
    public boolean isCellEmpty(int index) {
        return table[index] == null;
    }

    @Override
    public void put(String key) {
        String hashedValue = hashFunction.toASCIIValue(key);
        int index = hashFunction.hash(hashedValue);

        while (!isCellEmpty(index))
            index = collisionResolution.resolveCollision(index, key, this);

        table[index] = key;
    }

    @Override
    public String get(int index) {
        return table[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            sb.append(i + ": " + (table[i] == null ? " " : table[i]) + "\n");
        }
        return sb.toString();
    }

    @Override
    public int getLongestWordLength() {
        for (String word : table) {
            if (word != null && word.length() > longestWordLength)
                longestWordLength = word.length();
        }
        return longestWordLength;
    }

}
