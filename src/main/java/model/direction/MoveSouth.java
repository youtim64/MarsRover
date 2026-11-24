package model.direction;

import io.vavr.collection.List;
import model.Cell;

public final class MoveSouth implements MovementDirection {
    @Override
    public List<Integer> moveToward(Cell currentCell) {
        return List.of(-1, 0);
    }
}
