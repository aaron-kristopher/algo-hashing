package collision;

import datastructures.DataTableStrategy;
import hash.ModuloArithmeticImpl;

public class SecondHashFunctionImpl implements CollisionResolutionStrategy {

    @Override
    public int resolveCollision(int index, String key, DataTableStrategy table) {
        int MAX_LOOPS = 10;

        System.out.println("Resolving collision");

        ModuloArithmeticImpl moduloArithmetic = new ModuloArithmeticImpl();
        int step = moduloArithmetic.hash(key);
        int newIndex = (index + step) % table.length();

        int loops = 0; // Prevent infinite loop
        while (!table.isCellEmpty(newIndex) && loops < 10 && step != 0) {
            newIndex = (newIndex + step) % table.length();
            loops++;
        }

        if (loops == MAX_LOOPS || step == 0) {
            CollisionResolutionStrategy linearProbing = new LinearProbingImpl();
            return linearProbing.resolveCollision(index, key, table);
        }

        return newIndex;
    }

    @Override
    public String toString() {
        return "Second Hash Function";
    }
}
