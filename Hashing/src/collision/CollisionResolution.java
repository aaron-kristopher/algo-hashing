package collision;

import datastructures.SymbolTable;

public interface CollisionResolution {

    int resolveCollision(int index, String hashedValue, SymbolTable symbolTable);

}
