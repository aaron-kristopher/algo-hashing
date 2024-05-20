package datastructures;

import collision.CollisionResolutionStrategy;
import hash.HashFunctionStrategy;

public abstract class DataTableStrategy {

    protected CollisionResolutionStrategy collisionResolution;
    protected HashFunctionStrategy hashFunction;
    protected final int size = 50;

    public DataTableStrategy(HashFunctionStrategy hashFunction, CollisionResolutionStrategy collisionResolution) {
        this.collisionResolution = collisionResolution;
        this.hashFunction = hashFunction;
    }

    public abstract void put(String key);

    public abstract String get(int index);

    public abstract boolean isCellEmpty(int index);

    public abstract int getLongestWordLength();

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ": " + get(i));
        }
    }

    public int length() {
        return size;
    }

    public void setCollisionResolutionStrategy(CollisionResolutionStrategy collisionResolution) {
        this.collisionResolution = collisionResolution;
    }

    public void setHashFunctionStrategy(HashFunctionStrategy hashFunction) {
        this.hashFunction = hashFunction;
    }

    public String getCollisionResolutionStrategy() {
        return collisionResolution.toString();
    }

    public String getHashFunctionStrategy() {
        return hashFunction.toString();
    }

}
