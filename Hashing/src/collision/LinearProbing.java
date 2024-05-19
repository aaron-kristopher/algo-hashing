package collision;

import datastructures.SymbolTable;

public class LinearProbing implements CollisionResolution {

    @Override
    public int resolveCollision(int index, String hashedValue, SymbolTable symbolTable) {
        int step = 1;
        int newIndex = (index + step) % symbolTable.length();

        while (!symbolTable.isCellEmpty(newIndex)) {
            step++;
            newIndex = (newIndex + step) % symbolTable.length();
        }

        return newIndex;
    }

}