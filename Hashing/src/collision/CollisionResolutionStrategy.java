package collision;

import datastructures.DataTableStrategy;

public interface CollisionResolutionStrategy {

    int resolveCollision(int index, String hashedValue, DataTableStrategy symbolTable);

}
