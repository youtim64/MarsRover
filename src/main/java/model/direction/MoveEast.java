package model.direction;

import io.vavr.collection.List;
import model.Cell;

public final class MoveEast implements MovementDirection {

    @Override
    public List<Integer> moveToward(Cell currentCell) {
        return List.of(0, 1);
    }
}
