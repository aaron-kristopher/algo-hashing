package datastructures;

import java.util.LinkedList;

import collision.CollisionResolution;
import hash.HashFunction;

public class BucketTable extends SymbolTable {

    LinkedList<String>[] table = new LinkedList[50];

    public BucketTable(CollisionResolution collisionResolution) {
        super(collisionResolution);
    }

    @Override
    public void put(String key, HashFunction hashFunction, CollisionResolution collisionResolution) {
        String hashedValue = hashFunction.toASCIIValue(key);
        int index = hashFunction.hash(hashedValue);

        if (!isCellEmpty(index))
            collisionResolution.resolveCollision(index, hashedValue, this);

        table[index] = new LinkedList<>();
        table[index].add(key);
    }

    @Override
    public String get(int index) {
        return "";
    }

    @Override
    public boolean isCellEmpty(int index) {
        return table[index] == null;
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
