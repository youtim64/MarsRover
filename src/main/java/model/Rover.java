package model;

import model.direction.MovementDirection;

public class Rover {
    private Cell currentCell;
    private final Grid grid;

    private Rover(Grid grid, Cell cell) {
        this.currentCell = cell;
        this.grid = grid;

        grid.setRoversCell(currentCell, this);
    }

    public static Rover spawn(Grid grid, int row, int col) {
        Cell roversCell = new Cell(row, col);
        return new Rover(grid, roversCell);
    }

    public void move(MovementDirection direction) {
        Cell newPosition = new Cell(
                currentCell.row() + direction.moveToward(currentCell).get(0),
                currentCell.row() + direction.moveToward(currentCell).get(1)
        );

        updatePosition(newPosition);
    }

    private void updatePosition(Cell newPosition) {
        currentCell = newPosition;
        grid.setRoversCell(currentCell, this);
    }

    @Override
    public String toString() {
        return "Position : " + currentCell;
    }
}
