package entities.Cell;

import entities.Renderable;

import java.awt.*;

public abstract class Cell extends Renderable {
    private final Point point;

    /**
     * Konstruktor kelas Cell
     * 
     * @param point
     */
    Cell(Point point) {
        this.point = point;
    }


    /**
     * Mengembalikan point dari Cell
     * @return Point
     */
    public Point getPoint() {
        return point;
    }
}
