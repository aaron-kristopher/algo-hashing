package collision;

import datastructures.DataTableStrategy;
import hash.ModuloArithmeticImpl;

public class SecondHashFunctionImpl implements CollisionResolutionStrategy {

    @Override
    public int resolveCollision(int index, String hashedValue, DataTableStrategy symbolTable) {
        ModuloArithmeticImpl moduloArithmetic = new ModuloArithmeticImpl();
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
