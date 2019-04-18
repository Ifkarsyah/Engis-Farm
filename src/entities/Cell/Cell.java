package entities.Cell;

import entities.Renderable;

import java.awt.*;

public abstract class Cell extends Renderable {
    private final Point point;

    Cell(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }
}
