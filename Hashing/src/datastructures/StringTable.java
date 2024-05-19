package datastructures;

import collision.CollisionResolution;
import hash.HashFunction;

public class StringTable extends SymbolTable {

    private String[] table = new String[50];

    public StringTable(CollisionResolution collisionResolution) {
        super(collisionResolution);
    }

    @Override
    public boolean isCellEmpty(int index) {
        return table[index] == null;
    }

    @Override
    public void put(String key, HashFunction hashFunction, CollisionResolution collisionResolution) {
        String hashedValue = hashFunction.toASCIIValue(key);
        int index = hashFunction.hash(hashedValue);

        while (!isCellEmpty(index))
            index = collisionResolution.resolveCollision(index, hashedValue, this);

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
            sb.append(i + ": " + table[i] + "\n");
        }
        return sb.toString();
    }
}
