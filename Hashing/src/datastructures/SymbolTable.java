package datastructures;

import collision.CollisionResolution;
import hash.HashFunction;

public class SymbolTable {

    private String[] table = new String[50];

    public void put(String key, int index, HashFunction hashFunction, CollisionResolution collisionResolution) {
        String hashedValue = HashFunction.toASCIIValue(key);

        while (!isCellEmpty(index))
            index = collisionResolution.resolveCollision(index, hashedValue, this);

        table[index] = key;
    }

    public String get(int index) {
        return table[index];
    }

    private boolean isCellEmpty(int index) {
        return table[index] == null;
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + ": " + get(i));
        }
    }
}
