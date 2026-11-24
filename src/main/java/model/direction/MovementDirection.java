package model.direction;

import io.vavr.collection.List;
import model.Cell;

public interface MovementDirection {
    public List<Integer> moveToward(Cell currentCell);
}
