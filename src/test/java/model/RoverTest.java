package model;

import model.direction.MoveEast;
import model.direction.MoveNorth;
import model.direction.MoveSouth;
import model.direction.MoveWest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoverTest {
    @Test
    void movesNorthAndWrapsAtTheLastRow() {
        Grid grid = Grid.createGrid(10, 10);
        Rover rover = Rover.spawn(grid, 9, 5);

        rover.move(new MoveNorth());

        assertEquals("Position : Cell[row=0, column=5]", rover.toString());
        assertTrue(grid.getRoverAt(new Cell(0, 5)).isPresent());
        assertTrue(grid.getRoverAt(new Cell(9, 5)).isEmpty());
    }

    @Test
    void movesSouthAndWrapsAtTheFirstRow() {
        Grid grid = Grid.createGrid(10, 10);
        Rover rover = Rover.spawn(grid, 0, 5);

        rover.move(new MoveSouth());

        assertEquals("Position : Cell[row=9, column=5]", rover.toString());
        assertTrue(grid.getRoverAt(new Cell(9, 5)).isPresent());
        assertTrue(grid.getRoverAt(new Cell(0, 5)).isEmpty());
    }

    @Test
    void movesEastAndWrapsAtTheLastColumn() {
        Grid grid = Grid.createGrid(10, 10);
        Rover rover = Rover.spawn(grid, 5, 9);

        rover.move(new MoveEast());

        assertEquals("Position : Cell[row=5, column=0]", rover.toString());
        assertTrue(grid.getRoverAt(new Cell(5, 0)).isPresent());
        assertTrue(grid.getRoverAt(new Cell(5, 9)).isEmpty());
    }

    @Test
    void movesWestAndWrapsAtTheFirstColumn() {
        Grid grid = Grid.createGrid(10, 10);
        Rover rover = Rover.spawn(grid, 5, 0);

        rover.move(new MoveWest());

        assertEquals("Position : Cell[row=5, column=9]", rover.toString());
        assertTrue(grid.getRoverAt(new Cell(5, 9)).isPresent());
        assertTrue(grid.getRoverAt(new Cell(5, 0)).isEmpty());
    }

    @Test
    void wrapsInitialSpawnPositionAndUsesRectangularDimensions() {
        Grid grid = Grid.createGrid(4, 7);
        Rover rover = Rover.spawn(grid, 7, -1);

        assertEquals("Position : Cell[row=3, column=6]", rover.toString());
        assertTrue(grid.getRoverAt(new Cell(3, 6)).isPresent());
    }

    @Test
    void gridsKeepIndependentRoverMaps() {
        Grid first = Grid.createGrid(3);
        Grid second = Grid.createGrid(3);
        Rover rover = Rover.spawn(first, 1, 1);

        assertTrue(first.getRoverAt(new Cell(1, 1)).isPresent());
        assertTrue(second.getRoverAt(new Cell(1, 1)).isEmpty());
    }
}
