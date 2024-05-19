package collision;

import datastructures.SymbolTable;
import hash.ModuloArithmetic;

public class SecondHashFunction implements CollisionResolution {

    @Override
    public int resolveCollision(int index, String hashedValue, SymbolTable symbolTable) {
        ModuloArithmetic moduloArithmetic = new ModuloArithmetic();
        int step = moduloArithmetic.hash(hashedValue);
        int newIndex = (index + step) % symbolTable.length();

        int loops = 0; // Prevent infinite loop
        while (!symbolTable.isCellEmpty(newIndex) || loops < 50) {
            step += step;
            newIndex = (newIndex + step) % symbolTable.length();
            loops++;
        }

        return newIndex;
    }

}
