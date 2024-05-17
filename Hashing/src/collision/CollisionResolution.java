package collision;

import datastructures.SymbolTable;

public abstract class CollisionResolution {

    public abstract int resolveCollision(int index, String hashedValue, SymbolTable symbolTable);

}
