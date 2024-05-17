package collision;

import datastructures.SymbolTable;

public class LinearProbling extends CollisionResolution {
    @Override
    public int resolveCollision(int index, String hashedValue, SymbolTable symbolTable) {
        return 1;
    }
}