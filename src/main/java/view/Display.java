package view;

import model.Grid;
import model.Rover;
import model.direction.MoveEast;
import model.direction.MoveNorth;
import model.direction.MoveSouth;
import model.direction.MoveWest;

public class Display {
    public static void main(String[] args) {
        Grid grid = Grid.createGrid(10, 10);
        Rover rover = Rover.spawn(grid, 5, 5);

        System.out.println(rover);

        rover.move(new MoveEast());
        System.out.println(rover);

        rover.move(new MoveWest());
        System.out.println(rover);

        rover.move(new MoveNorth());
        System.out.println(rover);

        rover.move(new MoveSouth());
        System.out.println(rover);
    }
}
