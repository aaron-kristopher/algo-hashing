package collision;

import datastructures.SymbolTable;
import hash.ModuloArithmetic;

public class SecondHashFunction implements CollisionResolution {

    @Override
    public int resolveCollision(int index, String hashedValue, SymbolTable symbolTable) {
        ModuloArithmetic moduloArithmetic = new ModuloArithmetic();
        return moduloArithmetic.hash(hashedValue);
    }

}
