package collision;

import datastructures.DataTableStrategy;

public class BucketChainingImpl implements CollisionResolutionStrategy {

    @Override
    public int resolveCollision(int index, String key, DataTableStrategy symbolTable) {
        return index;
    }
}
