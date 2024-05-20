package collision;

import datastructures.DataTableStrategy;

public class LinearProbingImpl implements CollisionResolutionStrategy {

    @Override
    public int resolveCollision(int index, String key, DataTableStrategy table) {
        int newIndex = (index + 1) % table.length();

        while (!table.isCellEmpty(newIndex)) {
            newIndex = (newIndex + 1) % table.length();
        }

        return newIndex;
    }

    @Override
    public String toString() {
        return "Linear Probing";
    }
}