package collision;

import datastructures.DataTableStrategy;

public class LinearProbingImpl implements CollisionResolutionStrategy {

    @Override
    public int resolveCollision(int index, String key, DataTableStrategy symbolTable) {
        int step = 1;
        int newIndex = (index + step) % symbolTable.length();

        while (!symbolTable.isCellEmpty(newIndex)) {
            step++;
            newIndex = (newIndex + step) % symbolTable.length();
        }

        return newIndex;
    }
}