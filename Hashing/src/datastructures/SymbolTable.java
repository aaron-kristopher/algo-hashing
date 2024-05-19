package datastructures;

import collision.CollisionResolution;
import hash.HashFunction;

public abstract class SymbolTable {

    protected CollisionResolution collisionResolution;
    protected final int size = 50;

    public SymbolTable(CollisionResolution collisionResolution) {
        this.collisionResolution = collisionResolution;
    }

    public abstract void put(String key, HashFunction hashFunction, CollisionResolution collisionResolution);

    public abstract String get(int index);

    public abstract boolean isCellEmpty(int index);

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ": " + get(i));
        }
    }

    public int length() {
        return size;
    }
}
