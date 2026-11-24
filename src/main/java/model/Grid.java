package model;

import java.util.HashMap;
import java.util.Optional;

public final class Grid {
    private final HashMap<Cell, Optional<Rover>> grid;
    private final int width;
    private final int height;

    private Grid(int length, HashMap<Cell, Optional<Rover>> grid) {
        this.grid = grid;
        this.width = length;
        this.height = length;
    }

    private Grid(int width, int height, HashMap<Cell, Optional<Rover>> grid) {
        this.grid = grid;
        this.width = width;
        this.height = height;
    }

    private Grid() {
        throw new IllegalArgumentException("Cannot instantiate an empty Board");
    }

    public static Grid createGrid(int length){
        HashMap<Cell, Optional<Rover>> temporary = new HashMap<>();
        for( int row = 0; row < length; row++ ){
            for( int column = 0; column < length; column++ ){
                temporary.put(new Cell(row, column), Optional.empty());
            }
        }

        return new Grid(length, temporary);
    }

    public static Grid createGrid(int width, int height){
        HashMap<Cell, Optional<Rover>> temporary = new HashMap<>();
        for( int row = 0; row < width; row++ ){
            for( int column = 0; column < height; column++ ){
                temporary.put(new Cell(row, column), Optional.empty());
            }
        }

        return new Grid(width, height, temporary);
    }

    public void putRoverOnCell(Cell cell, Rover rover) {
        Cell wrappedCell = wrap(cell);
        grid.put(wrappedCell, Optional.of(rover));
    }

    public void removeRoverFromCell(Cell cell) {
        grid.put(wrap(cell), Optional.empty());
    }

    public Optional<Rover> getRoverAt(Cell cell) {
        return grid.get(wrap(cell));
    }

    public Cell wrap(Cell cell) {
        return new Cell(
                Math.floorMod(cell.row(), width),
                Math.floorMod(cell.column(), height)
        );
    }

}
